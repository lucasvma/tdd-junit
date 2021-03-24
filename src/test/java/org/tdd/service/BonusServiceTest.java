package org.tdd.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.tdd.model.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {

    private BonusService service;
    private Employee employee;

    @BeforeEach
    public void initialize() {
        this.service = new BonusService();
        this.employee = new Employee("Rodrigo", LocalDate.now(), new BigDecimal("0"));
    }

    @Test
    public void shouldReturnZeroForEmployeeWithVeryHighSalary() {
        employee.setSalary(new BigDecimal("25000"));
        assertThrows(IllegalArgumentException.class, () -> service.calculateBonus(employee));
    }

    @Test
    public void shouldReturnTenPercentOfSalary() {
        employee.setSalary(new BigDecimal("2500"));
        BigDecimal bonus = service.calculateBonus(employee);

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    public void shouldReturnTenPercentOfSalaryWithSalaryEquals10000() {
        employee.setSalary(new BigDecimal("10000"));
        BigDecimal bonus = service.calculateBonus(employee);

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
