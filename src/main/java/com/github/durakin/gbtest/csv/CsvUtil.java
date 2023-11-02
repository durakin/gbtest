package com.github.durakin.gbtest.csv;

import com.github.durakin.gbtest.dto.UsersDTO;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CsvUtil {
    public static List<UsersDTO> parseCsvToUsers(String fileName) throws FileNotFoundException {
        Reader reader = new BufferedReader(new FileReader(fileName));
        CsvToBean<UsersCsvMap> csvToBean = new CsvToBeanBuilder(reader)
                .withType(UsersCsvMap.class)
                .withSeparator(';').
                build();
        List<UsersCsvMap> parsed = csvToBean.parse();
        List<UsersDTO> result = new ArrayList<>();
        for (UsersCsvMap user : parsed) {
            UsersDTO usersDTO = new UsersDTO();
            usersDTO.setName(user.getName());
            usersDTO.setCity(user.getCity());
            usersDTO.setAge(user.getAge());
            result.add(usersDTO);
        }
        return result;
    }
}
