package com.fourtk.userapi.services;

import com.fourtk.userapi.dtos.requesties.UserRequest;
import com.fourtk.userapi.dtos.responses.UserResponse;

import java.util.List;

public interface IUserService {
    public UserRequest insert (UserRequest request);

    public List<UserResponse> getAll();
}
