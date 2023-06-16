package com.fourtk.userapi.dtos.responses;

import com.fourtk.userapi.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String name;
    private String cpf;
    private String address;
    private String email;
    private String phone;
    private LocalDate registrationDate;

    public static UserResponse convert(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setCpf(user.getCpf());
        userResponse.setAddress(user.getAddress());
        userResponse.setEmail(user.getEmail());
        userResponse.setPhone(user.getPhone());
        userResponse.setRegistrationDate(user.getRegistrationDate());
        return userResponse;
    }

}
