/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.interview.task.parser.model;

import com.interview.task.parser.DateConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import java.time.LocalDate;

public class EmployeeRow {
    
    @CsvBindByName(column = "EmpID")
    private int employeeId;

    @CsvBindByName(column = "ProjectID")
    private short projectId;

    @CsvCustomBindByName(column = "DateFrom", converter = DateConverter.class)
    private LocalDate startDate;

    @CsvCustomBindByName(column = "DateTo", converter = DateConverter.class)
    private LocalDate endDate;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public short getProjectId() {
        return projectId;
    }

    public void setProjectId(short projectId) {
        this.projectId = projectId;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
