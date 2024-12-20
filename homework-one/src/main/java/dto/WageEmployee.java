package dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
public class WageEmployee extends Employee {
    private double hours;
    private double wage;

    public WageEmployee(String name, int age, boolean married, String company,
                        String position, double baseSalary, double hours, double wage) {
        super(name, age, married, company, position, baseSalary);
        this.hours = hours;
        this.wage = wage;
    }

    public WageEmployee() {
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + hours * wage;
    }
}

