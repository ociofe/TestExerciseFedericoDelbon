package com.federico.resources.data;

public class TaxData {

	public GoodsType goodsType;
	
	public double percentage;

	public TaxData(double percentage){
		this.percentage = percentage;
	}
	public GoodsType getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
}
