package com.progno.stock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.progno.stock.domain.DataSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockApplicationTests {

	@Test
	public void contextLoads() throws JsonParseException, JsonMappingException, IOException {
		loadFromJSON();
	}
	
	private void loadFromJSON() throws JsonParseException, JsonMappingException, IOException {
        InputStream in = DataSet.class.getResourceAsStream("/data.json");
        Reader reader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
        ObjectMapper mapper = new ObjectMapper();
        DataSet dataSet = mapper.readValue(reader, DataSet.class);
        System.out.println(dataSet);
    }

}
