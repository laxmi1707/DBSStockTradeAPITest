package com.hackerrank.stocktrade.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.service.TradeService;



@RestController

public class TradesController {
    
	@Autowired
	TradeService tradeService;
	
	@RequestMapping( value = "/trades",method = RequestMethod.POST, consumes = "application/json", produces ="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void createNewTradeData(@RequestBody @Valid Trade model) {
		tradeService.createTradeData(model);
	}
	
	@RequestMapping( value = "/trades",method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Trade> getAllTrades() {
		return tradeService.findAll();
	}
	
	@RequestMapping( value = "/trades/{id}",method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Trade getTradeById(@PathVariable("id") Long id) {
		return tradeService.findById(id);
	}

	
	@RequestMapping( value = "/trades/users/{userId}",method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Trade> getTradeByUserId(@PathVariable("userId") Long userId) {
		return tradeService.findByUserId(userId);
	}
	
	@RequestMapping( value = "/trades/users/{userId}/stocks/{stocksym}",method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Trade> getTradeByUserId(@PathVariable("userId") Long userId, @PathVariable("stocksym")String symbol) {
		return tradeService.findByUserIdandStock(userId, symbol);
	}
	
	@RequestMapping( value = "/trades/stocks/{stocksym}",method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Trade> getTradeByUserId( @PathVariable("stocksym")String symbol) {
		return tradeService.findByStockSymbol(symbol);
	}

}
