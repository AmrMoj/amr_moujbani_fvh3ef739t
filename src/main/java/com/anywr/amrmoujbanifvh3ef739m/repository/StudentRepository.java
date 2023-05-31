package com.anywr.amrmoujbanifvh3ef739m.repository;

import com.anywr.amrmoujbanifvh3ef739m.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("Select "
            + "DISTINCT std from Student std "
            + "join std.classroom clrm "
            + "join clrm.teacher tchr "
            + "where std.classroom.className=:className "
            + "and tchr.firstName=:teacherFirstName "
            + "and tchr.lastName=:teacherLastName ")
    Page<Student> getStudentByClassNameAndTeacherName (
           @Param("className") String className,
           @Param("teacherFirstName")String teacherFirstName,
           @Param("teacherLastName")String teacherLastName,
           Pageable pageable

   );

    @Query("Select "
            + "DISTINCT std from Student std "
            + "join std.classroom clrm "
            + "where std.classroom.className=:className "
            )
    Page<Student> getStudentByClassName (
            @Param("className") String className,
            Pageable pageable
    );

    @Query("SELECT s FROM Student s " +
            "JOIN s.classroom c " +
            "JOIN c.teacher t " +
            "WHERE t.firstName = :teacherFirstName " +
            "and t.lastName=:teacherLastName")
    Page<Student> getStudentByTeacherName (
            @Param("teacherFirstName")String teacherFirstName,
            @Param("teacherLastName")String teacherLastName,
            Pageable pageable
    );


}
