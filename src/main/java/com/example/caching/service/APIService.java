package com.example.caching.service;

import com.example.caching.model.Adress;
import com.example.caching.model.Student;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class APIService {

    @CacheEvict(value = "twenty-second-cache", key = "'StudentInCache' + #studentId", condition = "#isCacheable == null || !#isCacheable", beforeInvocation = true)
    @Cacheable(value = "twenty-second-cache", key = "'StudentInCache' + #studentId")
    public Optional<Student> fetchStudent(String studentId, boolean isCacheable) throws InterruptedException {
        Thread.sleep(4000);


        List<Student> studentList = Arrays.asList(new Student("15UKJ", "John", "Malkovich", new Adress("15", "kneza Milosa", "Belgrade", "11000"))
        ,new Student("58PL", "Tom", "Hanks", new Adress("85", "kneza Milosa", "Novi Sad", "21000"))
        ,new Student("85IK", "Robert", "Redford", new Adress("25", "Danilova", "Nis", "25000")));

        return studentList.stream().filter(student -> student.getStudentId().equalsIgnoreCase(studentId)).findFirst();
    }
}
