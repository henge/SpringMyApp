package jp.springbook.springmyapp;

import java.io.Serializable;
import java.util.List;

public interface MyDataDao<T> extends Serializable {
	
	public List<T> getAll();
	public T findById(long id);
	public List<T> findByName(String name);
	public void add(T data);
	public void update(T data);
	public void delete(T data);
	public void delete(long id);
}
