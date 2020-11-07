package com.hackerrank.stocktrade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.stocktrade.exception.BadRequestException;
import com.hackerrank.stocktrade.exception.NotFoundException;
import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.repository.TradeRespository;




@Service("tradeService")
public class TradeServiceImpl implements TradeService{

	@Autowired
	TradeRespository tradeRespository;
	
	public TradeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deleteAllData() {
		tradeRespository.deleteAll();
		
	}
	
	public void createTradeData(Trade model) {
		// TODO Auto-generated method stub
		if(tradeRespository.existsById(model.getId())){
			throw new BadRequestException();
		}else
		{
			Trade tmodel = tradeRespository.save(model);
		}
	
		
	}

	@Override
	public List<Trade> findAll() {
		// TODO Auto-generated method stub
		return tradeRespository.findAll();

	}

	@Override
	public Trade findById(Long Id) {
		// TODO Auto-generated method stub
		Optional<Trade> tt = tradeRespository.findById(Id);
	
		if(tt.isPresent()){
			return (Trade)tt.get();
		}else{
			throw new NotFoundException();
		}

	}
	
	@Override
	public List<Trade> findByUserId(Long Id) {
		// TODO Auto-generated method stub
		List<Trade> tt = tradeRespository.findByUserId(Id);
		if(tt!=null && tt.size()>0){
			return tt;
		}else{
			throw new NotFoundException();
		}

	}

	@Override
	public List<Trade> findByUserIdandStock(Long userId, String symbol) {
		// TODO Auto-generated method stub
		List<Trade> tt = tradeRespository.findByUserIdandStockSymbol(userId, symbol);
		if(tt!=null && tt.size()>0)
		{
			return tt;
		}else{
			throw new NotFoundException();
		}
	}


	@Override
	public List<Trade> findByStockSymbol(String symbol) {
		// TODO Auto-generated method stub
		List<Trade> tt = tradeRespository.findByStockSymbol(symbol);
		if(tt!=null && tt.size()>0)
		{
			return tt;
		}else{
			throw new NotFoundException();
		}
	}
}
