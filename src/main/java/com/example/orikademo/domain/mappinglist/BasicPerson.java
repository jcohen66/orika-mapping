package com.example.orikademo.domain.mappinglist;

import java.util.List;

public class BasicPerson {
    private List<String> nameParts;

    public List<String> getNameParts() {
        return nameParts;
    }

    public void setNameParts(List<String> nameParts) {
        this.nameParts = nameParts;
    }

    @Override
    public String toString() {
        return "BasicPerson{" +
                "nameParts=" + nameParts +
                '}';
    }
}