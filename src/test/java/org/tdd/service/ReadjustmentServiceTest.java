package org.tdd.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.tdd.enums.Performance;
import org.tdd.model.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadjustmentServiceTest {

    private ReadjustmentService service;
    private Employee employee;

    @BeforeEach
    public void initialize() {
        this.service = new ReadjustmentService();
        this.employee = new Employee("Anna", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @Test
    public void shouldReadjustThreePercentWhenPerformanceIsDesired() {
        service.readjust(employee, Performance.DESIRED);

        assertEquals(new BigDecimal("1030.00"), employee.getSalary());
    }

    @Test
    public void shouldReadjustFifteenPercentWhenPerformanceIsDesired() {
        service.readjust(employee, Performance.GOOD);

        assertEquals(new BigDecimal("1150.00"), employee.getSalary());
    }

    @Test
    public void shouldReadjustTwentyPercentWhenPerformanceIsDesired() {
        service.readjust(employee, Performance.EXCELLENT);

        assertEquals(new BigDecimal("1200.00"), employee.getSalary());
    }
}
