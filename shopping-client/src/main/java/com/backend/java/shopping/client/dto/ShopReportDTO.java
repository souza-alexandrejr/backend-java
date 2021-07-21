package com.backend.java.shopping.client.dto;

public class ShopReportDTO {
	
	public Integer getCount() {
		return count;
	}
	
	public Double getMean() {
		return mean;
	}
	
	public Double getTotal() {
		return total;
	}
	
	public void setCount(Integer count) {
		this.count = count;
	}
	
	public void setMean(Double mean) {
		this.mean = mean;
	}
	
	public void setTotal(Double total) {
		this.total = total;
	}

	private Integer count;
	private Double mean;
	private Double total;

}
