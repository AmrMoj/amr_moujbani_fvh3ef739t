package com.anywr.amrmoujbanifvh3ef739m.service;

import com.anywr.amrmoujbanifvh3ef739m.entities.Student;
import com.anywr.amrmoujbanifvh3ef739m.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Page<Student> getAllStudents(Pageable pageable) {

        return studentRepository.findAll(pageable);
    }

    @Override
    public Page<Student> getStudentByClassNameAndTeacherName(
            String className, String teacherFullName, Pageable pageable
    )
    {

        String firstName=teacherFullName.split(" ")[0];
        String lastName=teacherFullName.split(" ")[1];

        return studentRepository.getStudentByClassNameAndTeacherName(
                className, firstName,lastName, pageable
        );
    }

    @Override
    public Page<Student> getStudentByClassName(String className, Pageable pageable) {
        System.out.println("class name :"  +className);
        return studentRepository.getStudentByClassName(className, pageable);
    }

    @Override
    public Page<Student> getStudentByTeacherName(String teacherFullName, Pageable pageable) {

        String firstName=teacherFullName.split(" ")[0];
        String lastName=teacherFullName.split(" ")[1];
        return studentRepository.getStudentByTeacherName(firstName,lastName, pageable);
    }


}
