package com.progno.stock.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.progno.stock.domain.DataSet;
import com.progno.stock.services.StockService;
import com.progno.stock.utils.DateLibs;

@Controller
@RequestMapping("/stocks")
public class StockController {
	private StockService stockService;
	
	@Autowired
	public StockController(StockService stockService) {
		this.stockService = stockService;
	}
	
	@RequestMapping(method=GET)
	public String getTasks( Model model) {
		model.addAttribute("dataset", new DataSet());
		return "views/stocks";
	}
	
	@RequestMapping(method=POST)
	public String createTask(String company, Model model) {
		if (company == null || company.trim().equals("")) {
			model.addAttribute("dataset", new DataSet());
		}  else {
			String[] dates = DateLibs.getPreviousMonAndFriday();
			DataSet data;
			try {
				data = stockService.getStocksForDates(company, dates);
				model.addAttribute("dataset", data);
			} catch (URISyntaxException e) {
				model.addAttribute("dataset", new DataSet());
			}			
		}
			
		return "tables/stock :: stock-list";
	}
}
