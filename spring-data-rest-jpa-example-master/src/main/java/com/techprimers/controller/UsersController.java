package com.techprimers.controller;

import com.techprimers.model.User;
import com.techprimers.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UsersController {

	/** The JPA repository */
//    @Autowired
//    private UserJpaRespository userJpaRespository;

	@Autowired
	private UserService service;
	
	/**
	 * Used to fetch all the users from DB
	 * 
	 * @return list of {@link User}
	 */
    @GetMapping(name="")
    public Page<User> findAll(
    		@RequestParam(required = false) String firstName,
    		@RequestParam(required = false) String occupation,
    		@PageableDefault(size=2, page=0, sort = "id")Pageable pageable) {
        return service.findAllUsers(firstName,occupation,pageable);
    }
  
    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable final Long id){
        service.deleteUser(id);
    }

    /**
	 * Used to find and return a user by name
	 * 
	 * @param name refers to the name of the user
	 * @return {@link User} object
	 */
//    @GetMapping(value = "/name/{name}")
//    public User findByName(@PathVariable final String name){
//        return service.findByName(name);
//    }
    
    @GetMapping(value = "/{id}")
    public User findById(@PathVariable final Long id){
        return service.findById(id);
    }
    
    @PutMapping(value="/{id}")
    public User updateUser(@PathVariable final Long id,@RequestBody final User users) {
		return service.updateUser(id, users);
    }
    /**
	 * Used to create a User in the DB
	 * 
	 * @param users refers to the User needs to be saved
	 * @return the {@link User} created
	 */
    @PostMapping
    public User load(@RequestBody final User users) {
        return service.saveUser(users);
        //return service.findByName(users.getName());
    }
}
