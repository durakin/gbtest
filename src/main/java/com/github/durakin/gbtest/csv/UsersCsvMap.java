package com.github.durakin.gbtest.csv;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class UsersCsvMap {
    @CsvBindByPosition(position = 0)
    private String name;

    @CsvBindByPosition(position = 1)
    private Integer age;

    @CsvBindByPosition(position = 2)
    private String city;
}
