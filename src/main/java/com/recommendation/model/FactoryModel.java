package com.recommendation.model;

public class FactoryModel {
	double openPrice, closePrice, highPrice, lowPrice;

	public double getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}

	public double getClosePrice() {
		return closePrice;
	}

	public void setClosePrice(double closePrice) {
		this.closePrice = closePrice;
	}

	public double getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}

	public double getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}

	public FactoryModel(double openPrice, double closePrice, double highPrice, double lowPrice) {
		super();
		this.openPrice = openPrice;
		this.closePrice = closePrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
	}

	public FactoryModel() {
		super();
	}
	
	
}
