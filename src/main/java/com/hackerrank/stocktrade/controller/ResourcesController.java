package com.hackerrank.stocktrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.hackerrank.stocktrade.service.TradeService;

@RestController

public class ResourcesController {
	
	@Autowired
	TradeService tradeService;
	
	@RequestMapping(value = "/erase",  method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteAllData(){
		tradeService.deleteAllData();
	}
    
}
