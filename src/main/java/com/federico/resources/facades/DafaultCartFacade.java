package com.federico.resources.facades;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.federico.resources.data.CartData;
import com.federico.resources.data.GoodsType;
import com.federico.resources.data.ProductData;
import com.federico.resources.data.TaxData;
import com.federico.resources.strategy.TaxStrategy;

public class DafaultCartFacade implements CartFacade{

	
	private static final BigDecimal ROUND_FACTOR = new BigDecimal("0.05");
	private int basicTax;
	private int importedTax;
	private Map<String, TaxStrategy> strategyMapping;
	
	public boolean isEmpty(CartData cart) {
		if(cart.getProducts() == null || cart.getProducts().isEmpty()){
			return true;
		}else{
			return false;
		}
	
	}

	public CartData addToCart(CartData cart, ProductData prod) {
		if(isEmpty(cart)){
			List<ProductData> listProd = new ArrayList<ProductData>();
			cart.setProducts(listProd);
		}
		cart.getProducts().add(prod);
		return cart;
	}

	public void processCart(CartData cart) {
		
		for (ProductData product : cart.getProducts()) {
			product = getTotalForProduct(product);
			double productTax = 0;
			cart.setTotal(cart.getTotal() + product.getPrice());
			for( GoodsType goodsType : product.getGoodsType()){
				product = strategyMapping.get(goodsType.getGoodsType()).calculateTax(product);
			}
			if(product.getTaxData() != null)
				for(TaxData tax : product.getTaxData()){
					productTax = productTax +tax.getPercentage();
				}
			
			double tax = calculateTaxValue(product.getPrice(), productTax);
			cart = setTaxToCart(cart,tax);
			printProductInfo(product, tax);
			productTax = 0;
		}
		printCartInfo(cart);

	}

	private void printCartInfo(CartData cart) {
		System.out.println("Sales Taxes: " +  new DecimalFormat("0.00").format(cart.getSaleTaxes()));
		System.out.println("Total: " + new DecimalFormat("0.00").format(cart.getTotal()+cart.getSaleTaxes()));
		System.out.println();
	}

	private void printProductInfo(ProductData product, double tax) {
		System.out.print(new DecimalFormat("#.##").format(product.getQta()) + " ");
		System.out.print(product.getDescription());
		System.out.println(new DecimalFormat("0.00").format(calculateProductTotal(product.getPrice() , tax)));
	}
	
	private ProductData getTotalForProduct(ProductData prod){
		prod.setPrice(prod.getPrice() * prod.getQta());
		return prod;
	}
	
	private CartData setTaxToCart(CartData cart, double productTax){
		cart.setSaleTaxes(cart.getSaleTaxes()+ productTax);
		return cart;
	}
	
	private double calculateProductTotal(double prodCost , double tax){
		
		return prodCost + tax;
	}
	
	private double calculateTaxValue(double prodCost , double productTaxPercentage){
		double percent = prodCost*productTaxPercentage /100;
		return Math.ceil(percent * 20) / 20.0;
	}
	

	
	public int getBasicTax() {
		return basicTax;
	}

	public void setBasicTax(int basicTax) {
		this.basicTax = basicTax;
	}

	public int getImportedTax() {
		return importedTax;
	}

	public void setImportedTax(int importedTax) {
		this.importedTax = importedTax;
	}

	public Map<String, TaxStrategy> getStrategyMapping() {
		return strategyMapping;
	}

	public void setStrategyMapping(Map<String, TaxStrategy> strategyMapping) {
		this.strategyMapping = strategyMapping;
	}

}
