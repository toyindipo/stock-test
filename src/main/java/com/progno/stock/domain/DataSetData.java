package com.progno.stock.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class DataSetData implements Serializable {
	private static final long serialVersionUID = -371643916497502302L;
	
	private Integer limit;
	private Boolean transform;
	@JsonProperty("column_index")
	private Integer columnIndex;
	@JsonProperty("column_names")
	private List<String> columnNames;	
	private String startDate;
	private String endDate;
	private String frequency;
	private List<Object[]> data;
	private Boolean collapse;
	private String order;
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Boolean getTransform() {
		return transform;
	}
	public void setTransform(Boolean transform) {
		this.transform = transform;
	}
	public Integer getColumnIndex() {
		return columnIndex;
	}
	public void setColumnIndex(Integer columnIndex) {
		this.columnIndex = columnIndex;
	}
	public List<String> getColumnNames() {
		return columnNames;
	}
	public void setColumnNames(List<String> columnNames) {
		this.columnNames = columnNames;
	}
	
	@JsonGetter("start_date")
	public String getStartDate() {
		return startDate;
	}
	@JsonSetter("start_date")
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	@JsonGetter("end_date")
	public String getEndDate() {
		return endDate;
	}
	
	@JsonSetter("end_date")
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public List<Object[]> getData() {
		return data;
	}
	public void setData(List<Object[]> data) {
		this.data = data;
	}
	public Boolean getCollapse() {
		return collapse;
	}
	public void setCollapse(Boolean collapse) {
		this.collapse = collapse;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public DataSetData() {
		columnNames = new ArrayList<>();
		data = new ArrayList<>();
	}
	
}
