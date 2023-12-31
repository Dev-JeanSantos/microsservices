package com.fourtk.userapi.controllers;

import com.fourtk.userapi.dtos.requesties.UserRequest;
import com.fourtk.userapi.dtos.responses.UserResponse;
import com.fourtk.userapi.services.impl.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserRequest> save(@Valid @RequestBody UserRequest request) {
        request = service.insert(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll(){
        List<UserResponse> users = service.getAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id){
        UserResponse response = service.findById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<UserResponse> getByCpf(@PathVariable String cpf){
        UserResponse response = service.findByCpf(cpf);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/search")
    public ResponseEntity<List<UserResponse>> getAllByName(@RequestParam(name="name",required = true) String name){
        List<UserResponse> users = service.queryByName(name);
        return ResponseEntity.ok().body(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> getByCpf(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
