package ua.lviv.lgs.map;

import java.sql.ResultSet;
import java.sql.SQLException;

import ua.lviv.lgs.domain.Product;

public class ProductMap {
	public static Product map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String name = result.getString("name");
		String desc = result.getString("desc");
		double price = result.getDouble("price");

		return new Product(id, name, desc, price);
	}
}
