package com.KNUT_CLUB.domain.member;

import com.KNUT_CLUB.domain.login.Login;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Getter @Setter
public class Member {
    private int num;
    private String name;
    private String department;
    private String birth;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private String detailAddress;

    Login login = new Login();

    String studentID = login.getStdentID();
    String password = login.getPassword();


    public Member(String name, String studentID, String password, String department, String birth,
                  String gender, String email, String phone, String address, String detailAddress) {
        this.name = name;
        this.studentID = studentID;
        this.password = password;
        this.department = department;
        this.birth = birth;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.detailAddress = detailAddress;
    }
}
