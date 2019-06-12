package com.sly.seata.account.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sly.seata.common.constant.SeataConstant;

import io.seata.core.context.RootContext;

/**
 * Http Rest请求拦截器，用于把当前上下文中获取到的XID放到RootContext
 * @author sly
 * @time 2019年6月12日
 */
public class SeataXidFilter extends OncePerRequestFilter {
	protected Logger logger = LoggerFactory.getLogger(SeataXidFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String xid = RootContext.getXID();
		String restXid = request.getHeader(SeataConstant.XID_HEADER);
		boolean bind = false;
		if (StringUtils.isBlank(xid) && StringUtils.isNotBlank(restXid)) {
			RootContext.bind(restXid);
			bind = true;
			if (logger.isDebugEnabled()) {
				logger.debug("bind[" + restXid + "] to RootContext");
			}
		}
		try {
			filterChain.doFilter(request, response);
		} finally {
			if (bind) {
				String unbindXid = RootContext.unbind();
				if (logger.isDebugEnabled()) {
					logger.debug("unbind[" + unbindXid + "] from RootContext");
				}
				if (!restXid.equalsIgnoreCase(unbindXid)) {
					logger.warn("xid in change during http rest from " + restXid + " to " + unbindXid);
					if (unbindXid != null) {
						RootContext.bind(unbindXid);
						logger.warn("bind [" + unbindXid + "] back to RootContext");
					}
				}
			}
		}

	}

}
