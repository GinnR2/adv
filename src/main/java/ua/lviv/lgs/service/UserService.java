package ua.lviv.lgs.service;

import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.shared.CRUD;

public interface UserService extends CRUD<User> {
	User getByEmail(String email);
}
