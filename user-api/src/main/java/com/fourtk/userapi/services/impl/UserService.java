package com.fourtk.userapi.services.impl;

import com.fourtk.userapi.dtos.requesties.UserRequest;
import com.fourtk.userapi.entities.User;
import com.fourtk.userapi.repositories.UserRepository;
import com.fourtk.userapi.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository repository;

    public UserRequest insert(UserRequest request) {

        User user = repository.save(User.convert(request));
        return UserRequest.convert(user);
    }
}
