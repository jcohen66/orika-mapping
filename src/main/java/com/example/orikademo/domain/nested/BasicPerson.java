package com.example.orikademo.domain.nested;

public class BasicPerson {
    private Name name;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BasicPerson{" +
                "name=" + name +
                '}';
    }
}