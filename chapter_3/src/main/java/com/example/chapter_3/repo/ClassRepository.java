package com.example.chapter_3.repo;

import com.example.chapter_3.entity.Class;
import com.example.chapter_3.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class, Integer> {
    Page<Class> findAllByNameLike(String name, Pageable pageable);
}
