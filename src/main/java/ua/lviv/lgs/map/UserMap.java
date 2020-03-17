package ua.lviv.lgs.map;

import java.sql.ResultSet;
import java.sql.SQLException;

import ua.lviv.lgs.domain.User;

public class UserMap {
	public static User map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String email = result.getString("email");
		String name = result.getString("name");
		String surname = result.getString("surname");
		String group = result.getString("group");
		String password = result.getString("password");

		return new User(id, email, name, surname, group, password);
	}
}
