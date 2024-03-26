package com.jpastudy.account.entity;

import com.jpastudy.account.enums.Role;
import com.jpastudy.account.request.SaveAccountRequest;
import com.jpastudy.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// 아무런 매개변수가 없는 생성자를 생성하되 다른 패키지에 소속된 클래스는 접근을 불허한다
// JPA에서 지연로딩 시 프록시 객체로 조회를 하는데 AccessLevel.PRIVATE 일 경우 프록시 객채 생성이 불가능하다.
public class Account extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;
    private String name;

    @Column(unique = true)
    private String loginId;
    private String password;
    private boolean active;
    private LocalDateTime activeTime;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Account(SaveAccountRequest request){
        this.name = request.getName();
        this.loginId = request.getLoginId();
        this.password = request.getPassword();
        this.role = request.getRole();
    }

    public void activeAccount(){
        this.active = true;
        this.activeTime = LocalDateTime.now();
    }
}
