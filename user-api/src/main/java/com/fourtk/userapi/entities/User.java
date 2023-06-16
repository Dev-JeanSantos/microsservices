package com.fourtk.userapi.entities;

import com.fourtk.userapi.dtos.requesties.UserRequest;
import com.fourtk.userapi.dtos.responses.UserResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String cpf;
    @Column
    private String address;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private LocalDate registrationDate = LocalDate.now();

    public static User converterRequest(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setCpf(userRequest.getCpf());
        user.setAddress(userRequest.getAddress());
        user.setId(userRequest.getId());
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhone());
        user.setRegistrationDate(userRequest.getRegistrationDate());
        return user;
    }

    public static User converterResponse(UserResponse userResponse) {
        User user = new User();
        user.setName(userResponse.getName());
        user.setCpf(userResponse.getCpf());
        user.setAddress(userResponse.getAddress());
        user.setEmail(userResponse.getEmail());
        user.setPhone(userResponse.getPhone());
        user.setRegistrationDate(userResponse.getRegistrationDate());
        return user;
    }

}
