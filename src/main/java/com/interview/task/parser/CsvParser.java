/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.interview.task.parser;

import com.interview.task.parser.model.EmployeeRow;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class CsvParser {
    
    public List<EmployeeRow> parse(Path path) throws Exception {
        try (Reader reader = Files.newBufferedReader(path)) {
            CsvToBean<EmployeeRow> cb = new CsvToBeanBuilder<EmployeeRow>(reader)
                    .withType(EmployeeRow.class)
                    .build();
            return cb.parse();
        }
    }
}
