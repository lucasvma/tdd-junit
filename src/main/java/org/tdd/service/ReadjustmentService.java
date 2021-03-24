package org.tdd.service;

import org.tdd.enums.Performance;
import org.tdd.model.Employee;

import java.math.BigDecimal;

public class ReadjustmentService {

    public void readjust(Employee employee, Performance performance) {
        BigDecimal percentage = performance.readjustmentPercentage();
        BigDecimal readjustment = employee.getSalary().multiply(percentage);
        employee.readjustSalary(readjustment);
    }
}
