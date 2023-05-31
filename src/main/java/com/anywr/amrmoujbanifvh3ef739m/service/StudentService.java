package com.anywr.amrmoujbanifvh3ef739m.service;

import com.anywr.amrmoujbanifvh3ef739m.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    Page<Student> getAllStudents(Pageable pageable);
    Page<Student> getStudentByClassNameAndTeacherName(String className, String teacherFullName,Pageable pageable);
    Page<Student> getStudentByClassName(String className,Pageable pageable);
    Page<Student> getStudentByTeacherName(String teacherFullName, Pageable pageable);
}
