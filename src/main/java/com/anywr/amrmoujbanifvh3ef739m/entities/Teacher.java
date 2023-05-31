package com.anywr.amrmoujbanifvh3ef739m.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("Teacher")
public class Teacher extends Person {

    @JsonIgnore
    @OneToOne(mappedBy="teacher")
    private Classroom classroom;
}
