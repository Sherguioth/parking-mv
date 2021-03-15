package io.github.sherguioth.config;

import java.util.List;

public interface IRepository<T, ID> {
	
	T save(T obj);
	
	T findById(ID id);
	
	List<T> findAll();
	
	void update(T obj);
	
	void delete(T obj);
}
