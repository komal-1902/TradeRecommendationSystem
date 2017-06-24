package com.recommendation.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class HistoricalDataController {
	
	@Autowired 
	RestTemplate restTemplate;

}
