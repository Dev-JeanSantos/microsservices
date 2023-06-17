package com.fourtk.userapi.services.exceptions;

public class ResourcesNotFoundException extends RuntimeException {
    public ResourcesNotFoundException(String msg) {
        super(msg);
    }
}
