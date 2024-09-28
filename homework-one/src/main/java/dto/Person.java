package dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString

public class Person {
    private String name;
    private int age;
    private boolean married;

    public Person(String name, int age, boolean married) {
        this.name = name;
        this.age = age;
        this.married = married;
    }

    public void display() {
        System.out.println(this.toString());
    }

}