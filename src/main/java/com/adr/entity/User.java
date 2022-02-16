package com.adr.entity;

import java.math.BigInteger;

public class User {
    int id;
    BigInteger hospId;
    int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigInteger getHospId() {
        return hospId;
    }

    public void setHospId(BigInteger hospId) {
        this.hospId = hospId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
