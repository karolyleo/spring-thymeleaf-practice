package com.codeup.zenithspringadlister.repository;

import com.codeup.zenithspringadlister.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
