package ua.lviv.lgs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.ProductDao;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.map.ProductMap;
import ua.lviv.lgs.utils.Connector;

public class ProductDaoImpl implements ProductDao {

	private static final String READ_ALL = "SELECT * FROM product";
	private static final String ADD = "INSERT INTO product(`name`,`desc`,`price`) VALUES (?,?,?)";
	private static final String READ_BY_ID = "SELECT * FROM product WHERE id = ?";
	private static final String UPDATE_BY_ID = "UPDATE product SET name = ?, `desc` = ?, price = ? WHERE id = ?";
	private static final String DELETE_BY_ID = "DELETE FROM product WHERE id=?";
	
	private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
	
	private Connection connection;
	private PreparedStatement preparedStatement;

	public ProductDaoImpl()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.connection = Connector.open();
	}

	@Override
	public Product add(Product t) {
		try {

			preparedStatement = connection.prepareStatement(ADD, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, t.getName());
			preparedStatement.setString(2, t.getDesc());
			preparedStatement.setDouble(3, t.getPrice());

			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			t.setId(rs.getInt(1));

		} catch (SQLException e) {
			LOGGER.error(e);

		}
		return t;
	}

	@Override
	public Product update(int i, Product t) {
		try {

			preparedStatement = connection.prepareStatement(UPDATE_BY_ID, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, t.getName());
			preparedStatement.setString(2, t.getDesc());
			preparedStatement.setDouble(3, t.getPrice());

			preparedStatement.setInt(4, i);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return t;
	}

	@Override
	public Product get(int i) {
		Product product = null;
		try {

			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, i);

			ResultSet result = preparedStatement.executeQuery();
			result.next();
			product = ProductMap.map(result);

		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return product;
	}

	@Override
	public Product delete(int i) {
		try {

			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, i);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return null;
	}

	@Override
	public List<Product> getAll() {
		List<Product> list = new ArrayList<>();
		try {

			preparedStatement = connection.prepareStatement(READ_ALL);

			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				list.add(ProductMap.map(result));
			}

		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return list;
	}

}
