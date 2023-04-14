package com.example.chapter_3;

import com.example.chapter_3.entity.Class;
import com.example.chapter_3.entity.Student;
import com.example.chapter_3.repo.ClassRepository;
import com.example.chapter_3.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Chapter3Application {
	@Autowired
	private ClassRepository classRepository;
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Chapter3Application.class, args);
	}

	@Bean
	public CommandLineRunner demoData(ClassRepository classRepository, StudentRepository studentRepository) {
		return args -> {
			classRepository.saveAll(Arrays.asList(Class.builder().name("E1").build(),
					Class.builder().name("E2").build(),
					Class.builder().name("E3").build(),
					Class.builder().name("E4").build()
			));
			
			studentRepository.saveAll(Arrays.asList(
					Student.builder().name("hung").studentCode("1").build(),
					Student.builder().name("tung").studentCode("2").build(),
					Student.builder().name("cuc").studentCode("3").build(),
					Student.builder().name("mai").studentCode("4").build()
			));
			
		};
	}

}
