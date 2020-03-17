package ua.lviv.lgs.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.BucketDao;
import ua.lviv.lgs.domain.Bucket;

import ua.lviv.lgs.map.BucketMap;

import ua.lviv.lgs.utils.Connector;

public class BucketDaoImpl implements BucketDao {

	private static final String READ_ALL = "SELECT * FROM bucket";
	private static final String ADD = "INSERT INTO bucket(`user_id`,`product_id`,`date`) VALUES (?,?,?)";
	private static final String READ_BY_ID = "SELECT * FROM bucket WHERE id = ?";
	// private static final String UPDATE_BY_ID = "UPDATE bucket SET user_id = ?,
	// product_id = ?, date = ? WHERE id = ?";
	private static final String DELETE_BY_ID = "DELETE FROM bucket WHERE id=?";
	
	private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

	private Connection connection;
	private PreparedStatement preparedStatement;

	public BucketDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.connection = Connector.open();
	}

	@Override
	public Bucket add(Bucket t) {
		try {

			preparedStatement = connection.prepareStatement(ADD, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, t.getUser_id());
			preparedStatement.setInt(2, t.getProduct_id());
			preparedStatement.setDate(3, new Date(t.getDate().getTime()));
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
	public Bucket update(int i, Bucket t) {
		throw new IllegalStateException("not supported");
	}

	@Override
	public Bucket get(int id) {
		Bucket bucket = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();

			bucket = BucketMap.map(result);
		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return bucket;
	}

	@Override
	public Bucket delete(int id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return null;
	}

	@Override
	public List<Bucket> getAll() {
		List<Bucket> list = new ArrayList<>();
		try {

			preparedStatement = connection.prepareStatement(READ_ALL);

			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				list.add(BucketMap.map(result));
			}

		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return list;
	}

}
