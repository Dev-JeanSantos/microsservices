package com.fourtk.userapi.services.impl;

import com.fourtk.userapi.dtos.requesties.UserRequest;
import com.fourtk.userapi.dtos.responses.UserResponse;
import com.fourtk.userapi.entities.User;
import com.fourtk.userapi.repositories.UserRepository;
import com.fourtk.userapi.services.IUserService;
import com.fourtk.userapi.services.exceptions.ResourcesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository repository;

    @Transactional
    public UserRequest insert(UserRequest request) {
        User user = repository.save(User.converterRequest(request));
        return UserRequest.convert(user);
    }

    @Transactional(readOnly = true)
    public List<UserResponse> getAll() {
        List<User> list = repository.findAll();
        return list.stream().map(UserResponse::convert).collect(Collectors.toList());
    }

    @Override
    public UserResponse findById(Long id) {
        Optional<User> obj = repository.findById(id);
        obj.orElseThrow(() -> new ResourcesNotFoundException("User Not Found!"));
        return UserResponse.convert(obj.get());

    }

    @Override
    public UserResponse findByCpf(String cpf) {
        try {
            User user = repository.findByCpf(cpf);
            return UserResponse.convert(user);
        } catch (NullPointerException e) {
            throw new ResourcesNotFoundException("CPF Not Found");
        }
    }

    @Override
    public void delete(Long id) {
        Optional<User> user = repository.findById(id);
        user.orElseThrow(() -> new ResourcesNotFoundException("User Not Found!"));
        repository.delete(user.get());
    }

    @Override
    public List<UserResponse> queryByName(String name) {
        String nameUperCase = name.toLowerCase();
        System.out.println(nameUperCase);
        List<User> users = repository.getUsersByName(nameUperCase);
        return users.stream().map(UserResponse::convert).collect(Collectors.toList());
    }
}
