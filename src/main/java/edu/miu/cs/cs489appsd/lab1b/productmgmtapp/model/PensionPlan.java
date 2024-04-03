package edu.miu.cs.cs489appsd.lab1b.productmgmtapp.model;

import java.time.LocalDate;

public class PensionPlan {
    private String planReferenceNumber;

    public String getPlanReferenceNumber() {
        return planReferenceNumber;
    }

    public void setPlanReferenceNumber(String planReferencePlan) {
        this.planReferenceNumber = planReferencePlan;
    }

    private LocalDate enrollmentDate;

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    private double monthlyContribution;

    public double getMonthlyContribution() {
        return monthlyContribution;
    }

    public void setMonthlyContribution(double monthlyContribution) {
        this.monthlyContribution = monthlyContribution;
    }

    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
        employee.setPensionPlan(this);
    }

    public PensionPlan(String planReferenceNumber, LocalDate enrollmentDate, double monthlyContribution,
            Employee employee) {
        this.planReferenceNumber = planReferenceNumber;
        this.enrollmentDate = enrollmentDate;
        this.monthlyContribution = monthlyContribution;
        this.employee = employee;
        employee.setPensionPlan(this);
    }

    public PensionPlan() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n\t\t{ ");
        sb.append("\"planReferenceNumber\":\"").append(this.planReferenceNumber)
                .append("\", \"enrollmentDate\":\"").append(this.enrollmentDate)
                .append("\", \"monthlyContribution\":").append(this.monthlyContribution)
                .append(" }");
        return sb.toString();
    }

}
