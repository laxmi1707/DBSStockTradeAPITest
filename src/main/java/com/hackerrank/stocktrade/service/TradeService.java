package com.hackerrank.stocktrade.service;

import java.util.List;

import javax.validation.Valid;

import com.hackerrank.stocktrade.model.Trade;

public interface TradeService {

	
	void deleteAllData();

	void createTradeData( Trade model);

	List<Trade> findAll();

	Trade findById(Long Id);

	List<Trade> findByUserId(Long Id);

	List<Trade> findByUserIdandStock(Long userId, String symbol);

	List<Trade> findByStockSymbol(String symbol);

}
