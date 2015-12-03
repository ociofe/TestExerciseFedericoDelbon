package com.federico.resources.facades;

import com.federico.resources.data.CartData;
import com.federico.resources.data.ProductData;

public interface CartFacade {

	public boolean isEmpty(CartData cart);
	public CartData addToCart(CartData cart,  ProductData prod);
	public void processCart(CartData cart);
}
