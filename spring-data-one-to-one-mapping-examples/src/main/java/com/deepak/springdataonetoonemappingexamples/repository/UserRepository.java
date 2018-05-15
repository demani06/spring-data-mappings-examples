package com.deepak.springdataonetoonemappingexamples.repository;

import com.deepak.springdataonetoonemappingexamples.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
