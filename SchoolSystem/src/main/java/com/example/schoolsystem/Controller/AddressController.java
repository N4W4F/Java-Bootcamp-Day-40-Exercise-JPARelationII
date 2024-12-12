package com.example.schoolsystem.Controller;

import com.example.schoolsystem.ApiResponse.ApiResponse;
import com.example.schoolsystem.DTO.AddressDTO;
import com.example.schoolsystem.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/addresses")
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity getAllAddresses() {
        return ResponseEntity.status(200).body(addressService.getAllAddresses());
    }

    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO addressDTO) {
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address has been added successfully"));
    }

    @PutMapping("/update")
    public ResponseEntity updateAddress(@RequestBody @Valid AddressDTO addressDTO) {
        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address with ID: " + addressDTO.getTeacher_id() + " has been updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body(new ApiResponse("Address with ID: " + id + " has been deleted successfully"));
    }
}
