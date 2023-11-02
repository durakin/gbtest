package com.github.durakin.gbtest.controller;

import com.github.durakin.gbtest.dto.UsersDTO;
import com.github.durakin.gbtest.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    @GetMapping
    public List<UsersDTO> findAllUsers() {
        return usersService.findAllUsers();
    }

    @PostMapping
    public void fillUsersTableFromJSON(@RequestBody List<UsersDTO> users) {
        usersService.fillUsersTable(users);
    }

    @GetMapping("/fill")
    public void fillUsersTableFromFile() {
        usersService.fillUsersTableFromFile();
    }
}
