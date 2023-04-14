package com.example.chapter_3.repo;

import com.example.chapter_3.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @EntityGraph(value = "classes", attributePaths = {"classes"})
    Page<Student> findAllByNameLike(String name, Pageable pageable);
}
