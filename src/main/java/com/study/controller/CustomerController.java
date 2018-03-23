package com.study.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CityDubboConsumerService consumerService;

	@RequestMapping(path = "/city", method = RequestMethod.GET)
	public City getCity() {
		return consumerService.getCityByName("luoyang");
	}

	@RequestMapping(path = "/test", method = RequestMethod.GET)
	public String test() {
		return test1();
	}

	public String test1() {
		return "hello world! er, what's your name?";
	}

	@RequestMapping(path = "/memory/dead/loop", method = RequestMethod.GET)
	public String testMemory() {
		logger.debug("线程启动");
		new Thread(new Runnable() {

			@Override
			public void run() {
				int i = 1;
				while (true) {
					logger.debug("线程启动==========> 循环次数:{}", i++);
					System.out.println("线程启动==========> 循环次数:" + i);
				}
			}

		}).start();
		return "dead-loop start";

	}
}
