package project0ShopDaos;

import project0ShopModels.product;

public interface ProductDAO {

	
	product productStatus(product p);
	product addProduct();
	boolean removeProduct(int id);
	
}
