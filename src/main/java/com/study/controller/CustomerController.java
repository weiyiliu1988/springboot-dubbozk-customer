package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.study.entity.City;
import com.study.service.CityDubboConsumerService;

/**
 * @author LIU
 *
 */
@RestController
@RequestMapping("/consumer")
public class CustomerController {

	@Autowired
	private CityDubboConsumerService consumerService;

	@RequestMapping(path = "/city", method = RequestMethod.GET)
	public City getCity() {
		return consumerService.getCityByName("luoyang");
	}
}
