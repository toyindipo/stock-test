package com.progno.stock.services;

import java.net.URISyntaxException;

import org.springframework.cache.annotation.Cacheable;

import com.progno.stock.domain.DataSet;

public interface StockService {
	@Cacheable(value="stockCache", key="T(java.util.Objects).hash(#p0,#p1)")
	DataSet getStocksForDates(String company, String[] dates) throws URISyntaxException;
}
