package com.wipro.webflux.service;

import com.wipro.webflux.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUserService {

    Mono<Object> createUser(User user);

    Mono<User> updateUser(Long id, User user);

    Mono<User> getUserById(Long id);

    Flux<User> getUsersByName(String name);

    Flux<User> getAllUsers();

    Mono<Void> deleteUs(Long id); // Added delete method
}
