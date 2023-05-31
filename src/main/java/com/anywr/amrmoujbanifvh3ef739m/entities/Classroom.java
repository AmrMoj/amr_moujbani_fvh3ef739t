package com.anywr.amrmoujbanifvh3ef739m.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Classroom {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "class_name", length=40)
    private String className;

    @JsonIgnore
    @OneToMany(mappedBy = "classroom")
    private List<Student> students;

    @OneToOne
    private Teacher teacher;
}
