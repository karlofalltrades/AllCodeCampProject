package com.techprimers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;
import com.techprimers.model.QUser;
import com.techprimers.model.User;
import com.techprimers.repository.UserJpaRespository;

@Service
public class UserService {

	@Autowired
	private UserJpaRespository userJpaRepository;
	
	public User saveUser(User user) {
		return userJpaRepository.save(user);
		
	}
	
	public User findById(Long id) {
		User user = userJpaRepository.findOne(id);
		if(user==null) {
			throw new RuntimeException("User Not Found!");
		}
		return user;
	}
	
//	public User findByName(String name) {
//		User user = userJpaRepository.findByName(name);
//		if(user==null) {
//			throw new RuntimeException("User Not Found!");
//		}
//		return user;
//	}
	
	public Page<User> findAllUsers(String firstName, String occupation, Pageable pageable){
		BooleanBuilder b = new BooleanBuilder();
		QUser quser = QUser.user;
		if(firstName!=null) {
			b.and(quser.firstName.eq(firstName));
		}
		if(occupation!=null) {
			b.and(quser.occupation.eq(occupation));
		}
		return userJpaRepository.findAll(b,pageable);
	}
	
	public User updateUser(Long id, User user) {
		User users = userJpaRepository.findOne(id);
		
		users.setFirstName(user.getFirstName());
		users.setLastName(user.getLastName());
		users.setOccupation(user.getOccupation());
		users.setProfile_picture(user.getProfile_picture());
		User u = userJpaRepository.save(users);
		
		return u;
	}
	
	public void deleteUser(Long id) {
		User user = userJpaRepository.findOne(id);
		if(user==null) {
			throw new RuntimeException("User Not Found!");
		}
		userJpaRepository.delete(id);
	}
}