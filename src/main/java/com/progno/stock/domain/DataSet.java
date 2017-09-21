package com.progno.stock.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class DataSet implements Serializable {
	
	private static final long serialVersionUID = 5783850344208789484L;
	
	private DataSetData dataSetData;
	
	@JsonGetter("dataset_data")
	public DataSetData getDataSetData() {
		return dataSetData;
	}
	
	@JsonSetter("dataset_data")
	public void setDataSetData(DataSetData dataSetData) {
		this.dataSetData = dataSetData;
	}

	public DataSet() {
		dataSetData = new DataSetData();
	}
}
