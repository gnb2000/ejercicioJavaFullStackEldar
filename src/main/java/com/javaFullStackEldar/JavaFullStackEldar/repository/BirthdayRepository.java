package com.javaFullStackEldar.JavaFullStackEldar.repository;

import com.javaFullStackEldar.JavaFullStackEldar.model.Birthday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirthdayRepository extends JpaRepository<Birthday,Long> {
}
