package com.wipro.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.wipro.webflux.entity.User;
import com.wipro.webflux.service.IUserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    
    @Autowired
    private IUserService service;

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/getall")
    public Flux<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/getbyid/{id}")
    public Mono<User> getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Object> createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @PutMapping("/update/{id}")
    public Mono<User> updateUser(@PathVariable long id, @RequestBody User user) {
        return service.updateUser(id, user);
    }

    @GetMapping("/name/{name}")
    public Flux<User> getUsersByName(@PathVariable String name) {
        return service.getUsersByName(name);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteUser(@PathVariable Long id) {
        return service.deleteUs(id);
    }
}
