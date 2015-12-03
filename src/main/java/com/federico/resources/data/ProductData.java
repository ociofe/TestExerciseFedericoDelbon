package com.federico.resources.data;

import java.util.List;

public class ProductData {
	
	public List<TaxData> taxData;
	public double price;
	public String description;
	public int qta;
	public List<GoodsType> goodsType;
	
	public ProductData(double price, int qta, String description ){
		this.description=description;
		this.price=price;
		this.qta=qta;
		
	}
	public List<TaxData> getTaxData() {
		return taxData;
	}
	public void setTaxData(List<TaxData> taxData) {
		this.taxData = taxData;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQta() {
		return qta;
	}
	public void setQta(int qta) {
		this.qta = qta;
	}
	public List<GoodsType> getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(List<GoodsType> goodsType) {
		this.goodsType = goodsType;
	}

}
