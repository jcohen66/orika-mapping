package com.example.orikademo.domain.nestedmulti;

import java.util.List;

public class Person {
    private List<Name> names;


    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "Person{" +
                "names=" + names +
                '}';
    }
}
