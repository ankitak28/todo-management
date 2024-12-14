package com.jwt.example.services;

import com.jwt.example.models.Users;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<Users> store = new ArrayList<>();

    public UserService(){
       store.add(new Users("1234","anki","anki@gmail.com"));
    }

    public List<Users> getUsers(){
        return this.store;
    }
}
