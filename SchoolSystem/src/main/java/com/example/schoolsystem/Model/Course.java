package com.example.schoolsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Check;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Check(constraints = "length(name) between 3 and 21 AND name <> ''")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(21) not null")
    @NotEmpty(message = "Course Name cannot be empty")
    @Size(min = 3, max = 21, message = "Course Name must be between 3 to 21 characters")
    private String name;

    @ManyToOne
    @JsonIgnore
    private Teacher teacher;
}
