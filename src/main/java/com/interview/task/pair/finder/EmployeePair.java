/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.interview.task.pair.finder;

public class EmployeePair {
    
    private int employeeId1;
    private int employeeId2;
    private int projectId;
    private long overlapDays;

    public EmployeePair(int employeeId1, int employeeId2, int projectId, long overlapDays) {
        this.employeeId1 = employeeId1;
        this.employeeId2 = employeeId2;
        this.projectId = projectId;
        this.overlapDays = overlapDays;
    }

    public int getEmployeeId1() {
        return employeeId1;
    }

    public void setEmployeeId1(int employeeId1) {
        this.employeeId1 = employeeId1;
    }

    public int getEmployeeId2() {
        return employeeId2;
    }

    public void setEmployeeId2(int employeeId2) {
        this.employeeId2 = employeeId2;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public long getOverlapDays() {
        return overlapDays;
    }

    public void setOverlapDays(long overlapDays) {
        this.overlapDays = overlapDays;
    }

    @Override
    public String toString() {
        return employeeId1 + "," + employeeId2 + "," + projectId + "," + overlapDays;
    }    
}
