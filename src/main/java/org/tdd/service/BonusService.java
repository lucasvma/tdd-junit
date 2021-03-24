package org.tdd.service;

import org.tdd.model.Employee;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BonusService {

    public BigDecimal calculateBonus(Employee employee) {
        BigDecimal value = employee.getSalary().multiply(new BigDecimal("0.1"));

        if (value.compareTo(new BigDecimal("1000")) > 0) {
            throw new IllegalArgumentException("Employee with salary bigger than 10000 could receive bonus!");
        }

        return value.setScale(2, RoundingMode.HALF_UP);
    }
}
