package org.sample.dao;



import org.sample.model.Todo;
import org.springframework.stereotype.Repository;

@Repository
public class TodoDao extends ModelDao<Todo>{

	@Override
	public Class<Todo> getClassName() {
		return Todo.class;
	}
	
	

}
