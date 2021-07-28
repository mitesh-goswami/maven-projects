package com.phoenix.daos;

import java.util.List;
/*
 * @author: mitesh goswami
 */
import com.phoenix.data.Product;

public interface ProductDao {

	Product getProductbyId(int id);
	List<Product> getAllProducts();
	void insert(Product product);
	void update(Product product);
	void delete(Product product);

}
