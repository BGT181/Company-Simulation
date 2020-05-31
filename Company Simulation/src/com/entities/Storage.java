package com.entities;

import java.awt.Dimension;
import java.awt.Image;

public class Storage extends Entity {

	private Product[] storedProducts = new Product[20];
	private int numberOfStoredProducts = 0;
	private boolean storageAvailable = true;

	// _______________________________________________________________________________________________________________________
	public Storage(Image image, int xPos, int yPos, Dimension orientation) {
		super(image, xPos, yPos, 0);
		// TODO Auto-generated constructor stub
	}

	// _______________________________________________________________________________________________________________________
	private void testAvailableStorage() {
		storageAvailable = numberOfStoredProducts < storedProducts.length;
	}
	
	public boolean testProductAvailability(Product.productType type) {
		boolean result = false;
			outerloop: for (int i = 0; i < storedProducts.length; i++) {
				if(type == storedProducts[i].getType()) {
					result = true;
					break outerloop;
				}
			}
		return result;
	}

	public void storeProduct(Product toStoreProduct) {
		outerloop: if (storageAvailable) {
			for (int i = 0; i < storedProducts.length; i++) {
				if (storedProducts[i] == null) {
					storedProducts[i] = toStoreProduct;
					numberOfStoredProducts++;
					testAvailableStorage();
					break outerloop;
				}
			}
		} else {
			// Fehler: Kein Platz im Lager
		}
	}

	public Product extractProduct(Product.productType type) {
		Product extractedProduct = null;
		outerloop: if(numberOfStoredProducts > 0 && testProductAvailability(type)) {
			for (int i = 0; i < storedProducts.length; i++) {
				if(type == storedProducts[i].getType()) {
					extractedProduct = storedProducts[i];
					storedProducts[i] = null;
					numberOfStoredProducts--;
					testAvailableStorage();
					break outerloop;
				}
			}
		} else {
			// Fehler: Das Lager ist leer
		}
		return extractedProduct;
	}
	// _______________________________________________________________________________________________________________________
	public Product[] getStoredProducts() {
		return storedProducts;
	}

	public void setStoredProducts(Product[] storedProducts) {
		this.storedProducts = storedProducts;
	}

	public int getNumberOfStoredProducts() {
		return numberOfStoredProducts;
	}

	public void setNumberOfStoredProducts(int numberOfStoredProducts) {
		this.numberOfStoredProducts = numberOfStoredProducts;
	}

	public boolean isStorageAvailable() {
		return storageAvailable;
	}

	public void setStorageAvailable(boolean storageAvailable) {
		this.storageAvailable = storageAvailable;
	}

}
