package com.techprimers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techprimers.model.Todos;
import com.techprimers.service.TodosService;

@RestController
@RequestMapping("/todos")
@CrossOrigin
public class TodosController {

	@Autowired
	private TodosService service;
	
    @GetMapping(name="")
    public Page<Todos> findAll(@RequestParam(required = false) Long ownerId,
    		@PageableDefault(size=2, page=0, sort = "id")Pageable pageable) {
    	return service.findAllTodos(ownerId, pageable);
    }
    
//    @GetMapping(name="")
//    public Todos findAllOwner(@RequestParam(required = false) Long ownerId) {
//        	return service.findByOwnerId(ownerId);
//    }
    
    @DeleteMapping(value = "/{id}")
    public void deleteTodos(@PathVariable final Long id){
        service.deleteTodo(id);
    }
    
    @GetMapping(value = "/{id}")
    public Todos findById(@PathVariable final Long id){
        return service.findById(id);
    }
    
    @PutMapping(value="/{id}")
    public Todos updateTodos(@PathVariable final Long id, @RequestBody final Todos todos) {
		return service.updateTodo(id, todos);
    }
    
    @PostMapping
    public Todos load(@RequestBody final Todos todos) {
        return service.saveTodos(todos);
        //return service.findByName(users.getName());
    }
    
}
