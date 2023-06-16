package com.fourtk.userapi.services;

import com.fourtk.userapi.dtos.requesties.UserRequest;

public interface IUserService {
    public UserRequest insert (UserRequest request);
}
