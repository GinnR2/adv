package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.ProductDao;
import ua.lviv.lgs.dao.impl.ProductDaoImpl;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.service.ProductService;

public class ProductServiceImpl implements ProductService {

	private ProductDao ent;

	private static Logger LOGGER = Logger.getLogger(ProductServiceImpl.class);
	private static ProductService productServiceImpl;


	private ProductServiceImpl() {
		try {
			ent = new ProductDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOGGER.error(e);
		}
	}

	public static ProductService getProductService() {
		if (productServiceImpl == null) {
			productServiceImpl = new ProductServiceImpl();
		}

		return productServiceImpl;
	}

	@Override
	public Product add(Product t) {
		return ent.add(t);
	}

	@Override
	public Product update(int i, Product t) {
		return ent.update(i, t);
	}

	@Override
	public Product get(int i) {
		return ent.get(i);
	}

	@Override
	public Product delete(int i) {
		return ent.delete(i);
	}

	@Override
	public List<Product> getAll() {
		return ent.getAll();
	}

	@Override
	public Map<Integer, Product> getAllMap() {
		return getAll().stream().collect(Collectors.toMap(Product::getId, Function.identity()));
	}

}
