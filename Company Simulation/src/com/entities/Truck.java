package com.entities;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;

import com.entities.Product.productType;
import com.gamelogic.Company;
import com.gamelogic.ImageProvider;
import com.gamelogic.Task;

public class Truck extends Entity{

	private boolean isArrived = false;
	private boolean isIdling = false;
	private static ArrayList<Product> orderedProducts = new ArrayList<Product>();
	private static ArrayList<Product> productsToSell = new ArrayList<Product>();
	private Company company = new Company(false);
	
	public Truck(Image image, int xPos, int yPos, Dimension orientation) {
		super(image, xPos, yPos, 0);
		// TODO Auto-generated constructor stub
	}

	public void orderProducts(productType type, int number) {
		for (int i = 0; i < number; i++) {
			orderedProducts.add(new Product(null, 0, 0, type));
		}
		company.addTask(Task.Tasks.GET_PRODUCTS_FROM_TRUCK);
	}
	
	public void addProductsToSell(Product productToSell) {
		productsToSell.add(productToSell);
	}
	
	public double sell(double pricePerProduct) {
		double profit = productsToSell.size() * pricePerProduct;
		productsToSell.clear();
		isIdling = false;
		return profit;
	}
	
	public Product getProduct() {
		Product toReturnProduct = orderedProducts.get(0);
		orderedProducts.remove(0);
		isIdling = orderedProducts.size() > 0;
		return toReturnProduct;
	}

	public boolean getIsArrived() {
		return isArrived;
	}

	public void setIsArrived(boolean isArrived) {
		this.isArrived = isArrived;
		if(isArrived) {
			isIdling = true;
		}
	}

	public boolean getIsIdling() {
		return isIdling;
	}
	
}
