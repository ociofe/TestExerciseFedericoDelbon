package com.federico.resources.data;

public enum GoodsType {
	
	BASETAX("BASETAX"), IMPORTED("IMPORTED"), NOTAX("NOTAX"), OTHER("OTHER");
	

	private String goodsType;

	private GoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

}
