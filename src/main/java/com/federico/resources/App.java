package com.federico.resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.federico.resources.data.CartData;
import com.federico.resources.data.LineData;
import com.federico.resources.data.ProductData;
import com.federico.resources.facades.CartFacade;
import com.federico.resources.facades.DefaultProductFacade;
import com.federico.resources.facades.ProductFacade;
import com.federico.resources.utils.MineUtils;
/**
 * Hello world!
 *
 */
public class App 
{

	public static ProductFacade productFacade;
	public static CartFacade cartFacade;
	
    public static void main( String[] args ) throws IOException
    {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
 
    		//InputStream in = new FileInputStream(new File("C:/Users/Federico/Documents/shoppingBag.txt"));
		    InputStream in = new FileInputStream(new File("/Users/federicodelbon/Documents/example.txt"));
		    BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		    //StringBuilder out = new StringBuilder();
		    String line;
		    CartData cart = new CartData();
		    while ((line = reader.readLine()) != null) {
		    	List<ProductData> listProductDatas = new ArrayList<ProductData>();
		       if (line.startsWith("Input")){
		    	   
		    	   
		    	   //Processo il carrello solo finche non ne inizia uno nuovo
		    	   if(!cartFacade.isEmpty(cart)){
		    		   cartFacade.processCart(cart);
		    		   
		    	   }
		    	   line = line.replace("Input", "Output");
		    	   System.out.println(line);
		    	   //Reset Cart
		    	   cart = new CartData();
		    	   continue;
		       }
		    	   //split line 
		    	   LineData lineData = MineUtils.splitLine(line);
		    	   //create Product
		    	   ProductData prod = productFacade.populate(lineData);
		    	   //add Product to cart
		    	   cartFacade.addToCart(cart, prod);
		    	  
		    	   
		    	   //build product
		    	   //ProductData product= new ProductData(price, qta, description)
		       }
		    
		    cartFacade.processCart(cart);
		    reader.close();
		    
		    }

	public ProductFacade getProductFacade() {
		return productFacade;
	}

	public static CartFacade getCartFacade() {
		return cartFacade;
	}

	public static void setCartFacade(CartFacade cartFacade) {
		App.cartFacade = cartFacade;
	}

	public static void setProductFacade(ProductFacade productFacade) {
		App.productFacade = productFacade;
	}




    }

