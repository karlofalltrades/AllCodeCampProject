package com.techprimers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;
import com.techprimers.model.QTodos;
import com.techprimers.model.Todos;
import com.techprimers.model.User;
import com.techprimers.repository.TodoJpaRepository;
import com.techprimers.repository.UserJpaRespository;

@Service
public class TodosService {

	@Autowired
	private TodoJpaRepository todoJpaRepository;
	@Autowired UserJpaRespository userJpaRepository;
	
	public Todos saveTodos(Todos todo) {
		return todoJpaRepository.save(todo);
		
	}
	
	public Todos findById(Long id) {
		Todos todo = todoJpaRepository.findOne(id);
		if(todo==null) {
			throw new RuntimeException("Todo Not Found!");
		}
		return todo;
	}
	
//	public User findByName(String name) {
//		User user = userJpaRepository.findByName(name);
//		if(user==null) {
//			throw new RuntimeException("User Not Found!");
//		}
//		return user;
//	}
	
//	public List<Todos> findAllOwner(Long ownerId) {
//		return todoJpaRepository.findByOwnerId(ownerId);
//	}
	
	public Page<Todos> findAllTodos(Long ownerId, Pageable pageable){
		BooleanBuilder b = new BooleanBuilder();
		QTodos qtodos = QTodos.todos;
		if(ownerId!=null) {
    		return todoJpaRepository.findByOwnerId(ownerId,b,pageable);
    	}
		return todoJpaRepository.findAll(b,pageable);
	}
	
	public Todos updateTodo(Long id, Todos todo) {
		Todos todos = todoJpaRepository.findOne(id);
		User user = userJpaRepository.findOne(todo.getOwner().getId());
		todos.setName(todo.getName());
		todos.setDescription(todo.getDescription());
		todos.setStatus(todo.getStatus());
		todos.setOwner(user);
		Todos t = todoJpaRepository.save(todos);
		
		return t;
	}
	
	public void deleteTodo(Long id) {
		Todos todo = todoJpaRepository.findOne(id);
		if(todo==null) {
			throw new RuntimeException("Todo Not Found!");
		}
		todoJpaRepository.delete(id);
	}
}
