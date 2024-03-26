package com.jpastudy.account.request;

import com.jpastudy.account.enums.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaveAccountRequest {

    @NotBlank(message = "이름을 입력해주세요")
    private String name;
    @NotBlank(message = "아이디를 입력해주세요")
    private String loginId;
    @NotBlank(message = "패스워드를 입력해주세요")
    private String password;
    @NotBlank(message = "권한을 선택해주세요")
    private Role role;

    public void encodePassword(String password){
        this.password = password;
    }
}
