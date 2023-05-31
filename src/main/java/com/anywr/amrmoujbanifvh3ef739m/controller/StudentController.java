package com.anywr.amrmoujbanifvh3ef739m.controller;

import com.anywr.amrmoujbanifvh3ef739m.entities.Student;
import com.anywr.amrmoujbanifvh3ef739m.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping()
    public Page<Student> getStudents(@RequestParam HashMap<String, String> filters,
                                     @RequestParam(defaultValue = "0") final Integer pageNumber,
                                     @RequestParam(defaultValue = "5") final Integer size) {

        final String classeName="className";
        final String teacheName="teacherName";

         if(filters.containsKey(classeName)
                && filters.containsKey(teacheName)) {

            return studentService.getStudentByClassNameAndTeacherName(
                    filters.get(classeName),
                    filters.get(teacheName),
                    PageRequest.of(pageNumber, size)
            );
        } else if (filters.containsKey(classeName) && !filters.containsKey(teacheName) ){
            return studentService.getStudentByClassName(filters.get(classeName), PageRequest.of(pageNumber, size));

         }else if (!filters.containsKey(classeName) && filters.containsKey(teacheName) ){
             return studentService.getStudentByTeacherName(filters.get(teacheName),PageRequest.of(pageNumber, size));
         }
         else return studentService.getAllStudents(PageRequest.of(pageNumber, size));

    }
}