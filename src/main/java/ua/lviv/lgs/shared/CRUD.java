package ua.lviv.lgs.shared;

import java.util.List;

public interface CRUD<T> {
	T add(T t);

	T update(int i, T t);

	T get(int i);

	T delete(int i);

	List<T> getAll();
}
