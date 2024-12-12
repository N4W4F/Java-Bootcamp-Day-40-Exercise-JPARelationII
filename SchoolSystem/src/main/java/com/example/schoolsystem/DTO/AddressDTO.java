package com.example.schoolsystem.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private Integer teacher_id;

    @NotEmpty(message = "Address Area cannot be empty")
    private String area;

    @NotEmpty(message = "Address Street cannot be empty")
    private String street;

    @NotNull(message = "Building Number cannot be empty")
    private Integer buildingNumber;
}
