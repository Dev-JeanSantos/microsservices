package com.fourtk.userapi.services.validations;

import com.fourtk.userapi.configs.FieldMessage;
import com.fourtk.userapi.dtos.requesties.UserRequest;
import com.fourtk.userapi.entities.User;
import com.fourtk.userapi.repositories.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CpfValidator implements ConstraintValidator<CpfValid, UserRequest> {

    @Autowired
    private UserRepository repository;

    @Override
    public void initialize(CpfValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(UserRequest request, ConstraintValidatorContext constraintValidatorContext) {

        List<FieldMessage> list = new ArrayList<>();
        User user = repository.findByCpf(request.getCpf());
        if (user != null) {
            list.add(new FieldMessage("CPF", "CPF already exists"));
        }
        for (FieldMessage e : list) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
