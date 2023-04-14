package com.example.chapter_3.repo;

import com.example.chapter_3.entity.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentClassRepository extends JpaRepository<StudentClass, Integer> {
}
