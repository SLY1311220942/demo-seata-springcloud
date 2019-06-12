package com.sly.seata.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sly.seata.business.service.BusinessService;

/**
 * 业务controller
 * 
 * @author sly
 * @time 2019年6月12日
 */
@Controller
@RequestMapping("/business")
public class BusinessController {
	@Autowired
	private BusinessService businessService;

	/**
	 * 购买
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	@ResponseBody
	@RequestMapping("/purchase")
	public Object purchase(HttpServletRequest request, HttpServletResponse response) {
		String accountId = "1";
		String orderId = "2";
		String storageId = "3";
		Map<String, Object> result = businessService.purchase(accountId, orderId, storageId);
		return result;
	}
}
