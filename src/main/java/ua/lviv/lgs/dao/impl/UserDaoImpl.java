package ua.lviv.lgs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.UserDao;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.map.UserMap;
import ua.lviv.lgs.utils.Connector;

public class UserDaoImpl implements UserDao {

	private static final String READ_ALL = "SELECT * FROM user";
	private static final String ADD = "INSERT INTO user(`email`,`name`,`surname`,`group`,`password`) VALUES (?,?,?,?,?)";
	private static final String READ_BY_ID = "SELECT * FROM user WHERE id = ?";
	private static final String UPDATE_BY_ID = "UPDATE user SET email=?, name=?, surname=?, `group`=?, `password`=? WHERE id=?";
	private static final String DELETE_BY_ID = "DELETE FROM user WHERE id=?";
	private static final String READ_BY_EMAIL = "SELECT * FROM user WHERE email = ?";
	
	private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
	
	private Connection connection;
	private PreparedStatement preparedStatement;

	public UserDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.connection = Connector.open();
	}

	@Override
	public User add(User t) {
		try {
			preparedStatement = connection.prepareStatement(ADD, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, t.getEmail());
			preparedStatement.setString(2, t.getName());
			preparedStatement.setString(3, t.getSurname());
			preparedStatement.setString(4, t.getGroup());
			preparedStatement.setString(5, t.getPassword());

			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			t.setId(rs.getInt(1));
			
			LOGGER.debug("Added user "+t.toString());
			//throw new SQLException();
		} catch (SQLException e) {
			LOGGER.error(e);
			return null;
		}
		return t;

	}

	@Override
	public User update(int i, User t) {
		try {

			preparedStatement = connection.prepareStatement(UPDATE_BY_ID, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, t.getEmail());
			preparedStatement.setString(2, t.getName());
			preparedStatement.setString(3, t.getSurname());
			preparedStatement.setString(4, t.getGroup());
			preparedStatement.setString(5, t.getPassword());

			preparedStatement.setInt(6, i);

			preparedStatement.executeUpdate();
			
			//LOGGER.debug("Updated user "+t.toString());
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return t;
	}

	@Override
	public User get(int i) {
		User user = null;
		try {

			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, i);

			ResultSet result = preparedStatement.executeQuery();
			result.next();

			user = UserMap.map(result);
			
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return user;
	}

	@Override
	public User delete(int i) {
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
	public List<User> getAll() {
		List<User> list = new ArrayList<>();
		try {

			preparedStatement = connection.prepareStatement(READ_ALL);

			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				list.add(UserMap.map(result));
			}

		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return list;
	}

	public User getByEmail(String email) {
		User user = null;
		try {

			preparedStatement = connection.prepareStatement(READ_BY_EMAIL);
			preparedStatement.setString(1, email);

			ResultSet result = preparedStatement.executeQuery();
			result.next();

			user = UserMap.map(result);

		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return user;
	}
}
