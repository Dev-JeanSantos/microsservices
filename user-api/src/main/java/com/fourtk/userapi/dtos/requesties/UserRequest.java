package com.fourtk.userapi.dtos.requesties;

import com.fourtk.userapi.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private Long id;

    @NotBlank
    @Size(min = 5, max = 15)
    private String name;
    @CPF
    @NotBlank
    private String cpf;
    @NotBlank
    private String address;
    @NotBlank
    @Email
    private String email;
    @NotBlank
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
