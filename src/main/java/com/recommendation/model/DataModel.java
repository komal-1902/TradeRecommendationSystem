package com.recommendation.model;

public class DataModel {
	String symbol, ltp, prevclose, open, high, low, close;

	public DataModel(String symbol, String ltp) {
		super();
		this.symbol = symbol;
		this.ltp = ltp;
	}
	
	public DataModel() {
		super();
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getLtp() {
		return ltp;
	}

	public void setLtp(String ltp) {
		this.ltp = ltp;
	}

	public String getPrevclose() {
		return prevclose;
	}

	public void setPrevclose(String prevclose) {
		this.prevclose = prevclose;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public DataModel(String symbol, String ltp, String prevclose, String open, String high, String low, String close) {
		super();
		this.symbol = symbol;
		this.ltp = ltp;
		this.prevclose = prevclose;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
	}
	
	
}
