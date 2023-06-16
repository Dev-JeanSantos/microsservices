package com.fourtk.userapi.services.impl;

import com.fourtk.userapi.dtos.requesties.UserRequest;
import com.fourtk.userapi.dtos.responses.UserResponse;
import com.fourtk.userapi.entities.User;
import com.fourtk.userapi.repositories.UserRepository;
import com.fourtk.userapi.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository repository;

    @Transactional
    public UserRequest insert(UserRequest request) {
        User user = repository.save(User.convert(request));
        return UserRequest.convert(user);
    }
    @Transactional(readOnly = true)
    public List<UserResponse> getAll() {
        List<User> list = repository.findAll();
        return list.stream().map(UserResponse::convert).collect(Collectors.toList());
    }
}
