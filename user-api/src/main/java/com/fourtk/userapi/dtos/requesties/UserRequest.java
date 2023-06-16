package com.fourtk.userapi.dtos.requesties;

import com.fourtk.userapi.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private Long id;
    private String name;
    private String cpf;
    private String address;
    private String email;
    private String phone;
    private LocalDate registrationDate = LocalDate.now();

    public static UserRequest convert(User user) {
        UserRequest userRequest = new UserRequest();
        userRequest.setName(user.getName());
        userRequest.setCpf(user.getCpf());
        userRequest.setAddress(user.getAddress());
        userRequest.setId(user.getId());
        userRequest.setEmail(user.getEmail());
        userRequest.setPhone(user.getPhone());
        userRequest.setRegistrationDate(user.getRegistrationDate());
        return userRequest;
    }
}
