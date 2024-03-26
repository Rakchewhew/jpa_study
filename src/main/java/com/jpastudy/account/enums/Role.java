package com.jpastudy.account.enums;

public enum Role {
    ADMIN("admin", "관리자"),
    USER("user", "사용자");

    private final String enRole;
    private final String koRole;

    public String getEnRole(){
        return enRole;
    }
    public String getKoRole(){
        return koRole;
    }

    Role(String enRole, String koRole){
        this.enRole = enRole;
        this.koRole = koRole;
    }
}
