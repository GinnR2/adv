package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.UserDao;
import ua.lviv.lgs.dao.impl.UserDaoImpl;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao ent;
	private static Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	private static UserService userServiceImpl;
	
	private UserServiceImpl() {
		try {
			ent = new UserDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			LOGGER.error(e);
		}
	}

	public static UserService getInstance() {
		if (userServiceImpl == null) {
			userServiceImpl = new UserServiceImpl();
		}

		return userServiceImpl;
	}

	@Override
	public User add(User t) {
		return ent.add(t);
	}

	@Override
	public User update(int i, User t) {
		return ent.update(i, t);
	}

	@Override
	public User get(int i) {
		return ent.get(i);
	}

	@Override
	public User delete(int i) {
		return ent.delete(i);
	}

	@Override
	public List<User> getAll() {
		return ent.getAll();
	}
	
	public User getByEmail(String email) {
		return ((UserDaoImpl) ent).getByEmail(email);
	}

}
