package com.github.durakin.gbtest.csv;

import com.github.durakin.gbtest.dto.UsersDTO;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CsvUtil {
    public static List<UsersDTO> parseCsvToUsers(String fileName) throws IOException {
        List<UsersCsvMap> parsed;
        try (FileReader fileReader = new FileReader(fileName); Reader reader = new BufferedReader(fileReader)) {
            CsvToBean<UsersCsvMap> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(UsersCsvMap.class)
                    .withSeparator(';').
                    build();
            parsed = csvToBean.parse();
        }
        return parsed.stream().map(parsedUser -> {
            UsersDTO usersDTO = new UsersDTO();
            usersDTO.setName(parsedUser.getName());
            usersDTO.setCity(parsedUser.getCity());
            usersDTO.setAge(parsedUser.getAge());
            return usersDTO;
        }).toList();
    }
}
