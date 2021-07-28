package com.phoenix.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.phoenix.daos.ProductDao;
import com.phoenix.daos.ProductDaoImpl;
import com.phoenix.data.Product;
import com.phoenix.exceptions.ProductNotFoundException;
import com.phoenix.exceptions.SeviceException;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;
	public ProductServiceImpl()
	{
		productDao=new ProductDaoImpl();
	}
	@Override
	public List<Product> findAll() throws SeviceException {
		// TODO Auto-generated method stub
		
		return productDao.getAllProducts();
	}
	@Override
	public Product findProductById(int id) throws SeviceException, ProductNotFoundException {
		Product product= productDao.getProductbyId(id);
		if(product!=null)
			return product;
		else
			throw new ProductNotFoundException("product not found");
	}
	@Override
	public void add(Product product) throws SeviceException {
		productDao.insert(product);
	}
	@Override
	public void edit(Product product) throws SeviceException {
		productDao.update(product);
	}
	@Override
	public void remove(Product product) throws SeviceException {
		productDao.delete(product);
	}
	@Override
	public List<Product> findByName(String name) throws SeviceException {
		// TODO Auto-generated method stub
		List<Product> dbProducts = findAll();
		List<Product> productsByName = new ArrayList<Product>();
		for(Product product : dbProducts) {
			if(product.getName().equals(name)) {
				productsByName.add(product);
			}
		}
		
		return productsByName;
		//return null;
	}
	@Override
	public List<Product> findByBrand(String brand) throws SeviceException {
		// TODO Auto-generated method stub
List<Product> dbProducts = findAll();
		
		List<Product> productsByBrand = new ArrayList<Product>();
		for(Product product : dbProducts) {
			if(product.getBrand().equals(brand)) {
				productsByBrand.add(product);
			}
		}
		return productsByBrand;
		//return null;
	}
	@Override
	public List<Product> findByPrice(float price) throws SeviceException {
		// TODO Auto-generated method stub
		List<Product> dbProducts = findAll();
		
		List<Product> productsByPrice = new ArrayList<Product>();
		for(Product product : dbProducts) {
			if(product.getPrice() == price) {
				productsByPrice.add(product);
			}
		}
		return productsByPrice;
		//return null;
	}
	@Override
	public List<Product> findByPriceRange(float minPrice, float maxPrice) throws SeviceException {
		// TODO Auto-generated method stub
List<Product> dbProducts = findAll();
		
		List<Product> productsByPriceRange = new ArrayList<Product>();
		for(Product product : dbProducts) {
			if(product.getPrice() >= maxPrice && product.getPrice() <= minPrice) {
				productsByPriceRange.add(product);
			}
		}
		return productsByPriceRange;
		//return null;
	}
	@Override
	public List<Product> findByNameAndBrand(String name, String Brand) throws SeviceException {
		// TODO Auto-generated method stub
		List<Product> dbProducts = findAll();
		
		List<Product> productsByBrand = new ArrayList<Product>();
		for(Product product : dbProducts) {
			if(product.getBrand().equals(Brand)) {
				productsByBrand.add(product);
			}
		}
		return productsByBrand;
		//return null;
	}
	@Override
	public List<Product> findByNameAndPrice(String name, float price) throws SeviceException {
		// TODO Auto-generated method stub
List<Product> dbProducts = findAll();
		
		List<Product> productsByNameAndPrice = new ArrayList<Product>();
		for(Product product : dbProducts) {
			if(product.getName().equals(name) && product.getPrice() == price) {
				productsByNameAndPrice.add(product);
			}
		}
		return productsByNameAndPrice;
		//return null;
	}
	@Override
	public List<Product> findByBrandAndPrice(String brand, float price) throws SeviceException {
		// TODO Auto-generated method stub
List<Product> dbProducts = findAll();
		
		List<Product> productsByBrandAndPrice = new ArrayList<Product>();
		for(Product product : dbProducts) {
			if(product.getBrand().equals(brand) && product.getPrice() == price) {
				productsByBrandAndPrice.add(product);
			}
		}
		return productsByBrandAndPrice;
		//return null;
	}
	@Override
	public List<Product> sortByName() throws SeviceException {
		// TODO Auto-generated method stub
		List<Product> dbProducts = findAll();
		List<Product> hi= new ArrayList<Product>();
		dbProducts.sort(Comparator.comparing(Product::getName));
		for(Product p :dbProducts)
		{
			hi.add(p);
		}
		return hi;
	}
	@Override
	public List<Product> sortByBrand() throws SeviceException {
		// TODO Auto-generated method stub
		List<Product> dbProducts = findAll();
		
		dbProducts.sort(Comparator.comparing(Product::getBrand));
		
		return dbProducts;
		
		
	}
	@Override
	public List<Product> sortByPrice() throws SeviceException {
		// TODO Auto-generated method stub
		List<Product> dbProducts = findAll();
		
		dbProducts.sort(Comparator.comparing(Product::getPrice));
		
		return dbProducts;
	}
	@Override
	public List<Product> sortByPriceDesc() throws SeviceException {
		// TODO Auto-generated method stub
		List<Product> dbProducts = findAll();
		
		dbProducts.sort(Comparator.comparing(Product::getName).reversed());
		
		return dbProducts;
		
	}
	

}
