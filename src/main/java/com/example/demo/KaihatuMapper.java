package com.example.demo;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
@Mapper
public interface KaihatuMapper {
	
	@Select("SELECT * FROM java WHERE id=#{id}")List<Entity>selectById(int id);
	
	
	@Update("UPDATE java SET name=#{name} ,age=#{age} , password=#{password} , kaishi=#{kaishi} , shuryo=#{shuryo} WHERE id=#{id} ")
	void update(Entity entity);

	
	
	//@Delete("DELETE FROM java WHERE id={id}")void delete(int id);
	
	
	

}
