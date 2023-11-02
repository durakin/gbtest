package com.github.durakin.gbtest.controller;

import com.github.durakin.gbtest.dto.UsersDTO;
import com.github.durakin.gbtest.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @GetMapping("/users")
    public List<UsersDTO> findAllUsers() {
        return usersService.findAllUsers();
    }

    @PostMapping("/users")
    public void fillUsersTableFromJSON(@RequestBody List<UsersDTO> users) {
        usersService.fillUsersTable(users);
    }

    @GetMapping("/fill")
    public void fillUsersTableFromFile() {
        usersService.fillUsersTableFromFile();
    }
}
