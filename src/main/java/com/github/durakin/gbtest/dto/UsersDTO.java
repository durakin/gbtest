package com.github.durakin.gbtest.dto;

import com.github.durakin.gbtest.entity.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsersDTO {
    private String name;
    private Integer age;
    private String city;

    public UsersDTO(Users users) {
        this.name = users.getName();
        this.age = users.getAge();
        this.city = users.getCity();
    }
}
