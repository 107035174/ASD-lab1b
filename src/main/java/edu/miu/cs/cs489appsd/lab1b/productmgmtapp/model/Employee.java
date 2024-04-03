package edu.miu.cs.cs489appsd.lab1b.productmgmtapp.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class Employee {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private double yearlySalary;
    private PensionPlan pensionPlan;

    public PensionPlan getPensionPlan() {
        return pensionPlan;
    }

    public void setPensionPlan(PensionPlan pensionPlan) {
        this.pensionPlan = pensionPlan;
    }

    public Employee(String firstName, String lastName, double yearlySalary, LocalDate employmentDate) {
        this.employeeId = new Random().nextLong();
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yearlySalary;
    }

    public Employee() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n\t{ ");
        sb.append("\"employeeId\":").append(this.employeeId)
                .append(", \"firstName\":\"").append(this.firstName)
                .append("\", \"lastName\":\"").append(this.lastName)
                .append("\", \"yearlySalary\":").append(this.yearlySalary)
                .append(", \"employmentDate\":\"").append(this.employmentDate)
                .append("\", \"pensionPlan\":").append(this.pensionPlan)
                .append(" },\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Employee emp = (Employee) o;
        return Objects.equals(this.lastName, emp.getLastName());
    }

}
