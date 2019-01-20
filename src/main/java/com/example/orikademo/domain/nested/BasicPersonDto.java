package com.example.orikademo.domain.nested;

class BasicPersonDto {
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "BasicPersonDto{" +
                "firstName='" + firstName + '\'' +
                '}';
    }
}