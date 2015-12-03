package com.federico.resources.strategy;

import java.util.ArrayList;
import java.util.List;

import com.federico.resources.data.ProductData;
import com.federico.resources.data.TaxData;

public class ImportedStrategy implements TaxStrategy{

	public ProductData calculateTax(ProductData prod) {
		List<TaxData> taxData = prod.getTaxData();
		if(taxData!= null){
			taxData.add(new TaxData(5));
		}else{
			taxData = new ArrayList<TaxData>();
			taxData.add(new TaxData(5));
		}
		prod.setTaxData(taxData);
		return prod;
	}

}
