package com.federico.resources.facades;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.federico.resources.data.GoodsType;
import com.federico.resources.data.LineData;
import com.federico.resources.data.ProductData;

public class DefaultProductFacade implements ProductFacade{

	public ProductData populate(LineData linedata) {
		ProductData prod = new ProductData(linedata.getPrice(), linedata.getQta(), linedata.getDescription());
		prod = SetProductType(prod);
		return prod;
	}
	
	public static ProductData SetProductType(ProductData prod){
		prod.setGoodsType(new ArrayList<GoodsType>());
		Pattern pattern = Pattern.compile("chocolate|book|headache");
		if (!pattern.matcher(prod.getDescription()).find()) {
			List<GoodsType> listGoods = new ArrayList<GoodsType>(prod.getGoodsType());
			listGoods.add(GoodsType.BASETAX);
			prod.setGoodsType(listGoods);
		}
		if(prod.getDescription().contains("imported")){
			List<GoodsType> listGoods = new ArrayList<GoodsType>(prod.getGoodsType());
			listGoods.add(GoodsType.IMPORTED);
			prod.setGoodsType(listGoods);
		}
		
		return prod;
		
	}

}
