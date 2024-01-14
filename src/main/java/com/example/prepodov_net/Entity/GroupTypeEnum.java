package com.example.prepodov_net.Entity;

public enum GroupTypeEnum {
    FUN("Развлечения"),
    STUDY("Учёба"),
    BUSINESS("Бизнес");

    private String title;

    GroupTypeEnum(String title) {
        this.title = title;
    }
}
