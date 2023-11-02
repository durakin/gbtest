package com.github.durakin.gbtest.service;

import com.github.durakin.gbtest.csv.CsvUtil;
import com.github.durakin.gbtest.dto.UsersDTO;
import com.github.durakin.gbtest.entity.Users;
import com.github.durakin.gbtest.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public List<UsersDTO> findAllUsers() {
        return usersRepository.findAll().stream().map(UsersDTO::new).collect(Collectors.toList());
    }

    public void fillUsersTable(List<UsersDTO> users) {
        users.forEach(usersDTO -> {
            Users newUser = new Users();
            newUser.setName(usersDTO.getName());
            newUser.setCity(usersDTO.getCity());
            newUser.setAge(usersDTO.getAge());
            usersRepository.save(newUser);
        });
    }

    public void fillUsersTableFromFile() {
        List<UsersDTO> parsedUsers = parseUsersFromCsv("C:/gbtest/testCSV.csv");
        fillUsersTable(parsedUsers);
    }

    private List<UsersDTO> parseUsersFromCsv(String filename) {
        List<UsersDTO> parsed;
        try {
            parsed = CsvUtil.parseCsvToUsers(filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return parsed;
    }
}
