package com.wipro.webflux.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;

import com.wipro.webflux.entity.User;
import com.wipro.webflux.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImp implements IUserService {
    
    @Autowired
    private UserRepository repo;
    
    @Autowired
    private DatabaseClient databaseClient;
    
    @Override
    public Mono<Object> createUser(User user) {
        return this.databaseClient.sql("INSERT INTO myuser(id, name, email) VALUES(:id, :name, :email)")   
                .filter((statement, executeFunction) -> statement.returnGeneratedValues("user").execute())
                .bind("id", user.getId())
                .bind("name", user.getName())
                .bind("email", user.getEmail())
                .fetch()
                .first()
                .map((r) -> user);
    }

    @Override
    public Mono<User> getUserById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Flux<User> getUsersByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public Flux<User> getAllUsers() {
        return repo.findAll().delayElements(Duration.ofSeconds(2)); // Introduce delay for back pressure
    }

    @Override
    public Mono<User> updateUser(Long id, User user) {
        return repo.findById(id)
                .flatMap(existingUser -> {
                    existingUser.setName(user.getName());
                    existingUser.setEmail(user.getEmail());
                    return repo.save(existingUser);
                });
    }

    @Override
    public Mono<Void> deleteUs(Long id) {
        return repo.deleteById(id);
    }
}
