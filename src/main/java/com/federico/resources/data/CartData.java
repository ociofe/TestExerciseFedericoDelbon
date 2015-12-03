package com.federico.resources.data;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class CartData {
	
	public List<ProductData> products;
	
	public double saleTaxes;
	
	public double total;

	public List<ProductData> getProducts() {
		return products;
	}

	public void setProducts(List<ProductData> products) {
		this.products = products;
	}

	public double getSaleTaxes() {
		return saleTaxes;
	}

	public void setSaleTaxes(double saleTaxes) {
		this.saleTaxes = saleTaxes;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	

}
