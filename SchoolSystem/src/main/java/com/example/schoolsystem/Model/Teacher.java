package com.example.schoolsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.Check;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Check(constraints = "length(name) >= 3 AND " +
        "age >= 25 AND " +
        "email LIKE '%@%' AND " +
        "email LIKE '%.%' AND " +
        "salary > 0")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(21) not null")
    @NotEmpty(message = "Teacher Name cannot be empty")
    @Size(min = 3, message = "Teacher Name must be more than 2 characters")
    private String name;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "Teacher Age cannot be empty")
    @Min(value = 25, message = "Teacher Age must be 25 or above")
    private Integer age;

    @Column(columnDefinition = "varchar(36) not null unique")
    @NotEmpty(message = "Teacher Email cannot be empty")
    @Email(message = "Teacher Email must be in valid email format")
    private String email;

    @Column(columnDefinition = "decimal not null")
    @NotNull(message = "Teacher Salary cannot be empty")
    private Double salary;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Course> courses;
}
