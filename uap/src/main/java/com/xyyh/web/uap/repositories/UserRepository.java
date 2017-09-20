package com.xyyh.web.uap.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.xyyh.web.uap.entity.User;

public interface UserRepository extends JpaRepository<User, Long>, QueryDslPredicateExecutor<User> {

	public User findByUsername(String username);

	public Page<User> findByUsernameContaining(String username, Pageable pageable);

}
