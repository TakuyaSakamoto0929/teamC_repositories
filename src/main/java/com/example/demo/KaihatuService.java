package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class KaihatuService {
	@Autowired
	private KaihatuMapper mapper;
	
	public List<Entity>selectById(int id){
		List<Entity> entity = mapper.selectById(id);
		
		return mapper.selectById(id);
	}
	
	public void update(Entity entity) {
		mapper.update(entity);}

	
		
	
	//public void delete (int id) {
		
		//mapper.delete(id);
	//}

}
