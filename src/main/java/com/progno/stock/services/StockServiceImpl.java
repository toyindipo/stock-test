package com.progno.stock.services;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.progno.stock.domain.DataSet;

@Service
public class StockServiceImpl implements StockService {
	private static final String uri = "https://www.quandl.com/api/v3/datasets/WIKI/$company"
			+ "/data.json?column_index=4&sort_order=asc";
	@Override
	public DataSet getStocksForDates(String company, String[] dates) throws URISyntaxException {
		URI url = new URI(uri.replace("$company", company));
		UriComponentsBuilder builder = 
				UriComponentsBuilder.fromUri(url);
		builder.queryParam("start_date", dates[0]);
		builder.queryParam("end_date", dates[1]);
		
		url = builder.build().encode().toUri();
		
		RestTemplate rest = new RestTemplate();		
		
		RequestEntity<?> requestEntity	= 
				new RequestEntity<Object>(HttpMethod.GET, url);
		
		ResponseEntity<DataSet> response = 
				rest.exchange(requestEntity, DataSet.class);
		return response.getBody();
	}
	
}
