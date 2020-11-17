package com.example.caching.controller;

import com.example.caching.model.Student;
import com.example.caching.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class ApiController {

    @Autowired
    private APIService apiService;

    @GetMapping
    public ResponseEntity<Student> fetchStudent(@RequestParam(name = "studentId") String studentId,
                                                @RequestParam(name = "isCacheable") boolean isCacheable) throws InterruptedException {
        return new ResponseEntity<Student>(apiService.fetchStudent(studentId, isCacheable).get(), HttpStatus.OK);
    }
}
