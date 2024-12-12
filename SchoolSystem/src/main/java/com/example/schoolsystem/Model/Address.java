package com.example.schoolsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    private Integer id;

    @Column(columnDefinition = "varchar(16) not null")
    private String area;

    @Column(columnDefinition = "varchar(21) not null")
    private String street;

    @Column(columnDefinition = "int not null")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
