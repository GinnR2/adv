package ua.lviv.lgs.service;

import java.util.Map;

import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.shared.CRUD;

public interface ProductService extends CRUD<Product> {
	public Map<Integer, Product> getAllMap();
}
