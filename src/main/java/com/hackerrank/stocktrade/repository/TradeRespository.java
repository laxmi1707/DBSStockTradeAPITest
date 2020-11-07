package com.hackerrank.stocktrade.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hackerrank.stocktrade.model.Trade;


@Repository("tradeRespository")
public interface TradeRespository extends   JpaRepository<Trade, Long> {


	@Query("select a from Trade a where a.user.id = :id")
	List<Trade> findByUserId(@Param("id") Long id);

	@Query("select a from Trade a where a.user.id = :userId and a.symbol = :symbol")
	List<Trade> findByUserIdandStockSymbol(@Param("userId") Long userId, @Param("symbol")String symbol);

	@Query("select a from Trade a where  a.symbol = :symbol")
	List<Trade> findByStockSymbol(@Param("symbol")String symbol);


}
