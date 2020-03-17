package ua.lviv.lgs.map;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.lviv.lgs.domain.Bucket;

public class BucketMap {
	public static Bucket map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		int user_id = result.getInt("user_id");
		int product_id = result.getInt("product_id");
		Date date = result.getDate("date");

		return new Bucket(id, user_id, product_id, date);
	}
}
