package com.codeup.zenithspringadlister.repository;

import com.codeup.zenithspringadlister.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Long> {
    Ad findById(long id);
}
