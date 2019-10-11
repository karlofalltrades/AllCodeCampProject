package com.techprimers.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.querydsl.core.BooleanBuilder;
import com.techprimers.model.Todos;
import com.techprimers.model.User;

public interface TodoJpaRepository extends JpaRepository<Todos, Long>, QueryDslPredicateExecutor<Todos> {

    Todos findById(Long id);
//    List<Todos> findAll();
    Page<Todos> findByOwnerId(Long id,BooleanBuilder b, Pageable p);
}
