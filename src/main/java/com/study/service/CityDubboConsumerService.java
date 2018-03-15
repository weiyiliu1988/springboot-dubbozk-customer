package com.study.service;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.study.api.CityDubboService;
import com.study.entity.City;

/**
 * @author LIU
 *
 */
@Service
public class CityDubboConsumerService {

	// 与服务器配置一致
	@Reference(version = "1.0.1")
	CityDubboService cityDubboService;

	public City getCityByName(String cityName) {
		System.out.println("[客户侧] 请求数据处理开始");
		City city = cityDubboService.findCityByName(cityName);
		System.out.println("[客户侧] 请求数据处理结束");
		return city;

	}
}
