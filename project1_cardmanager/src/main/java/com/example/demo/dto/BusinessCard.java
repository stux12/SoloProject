package com.example.demo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter + setter + ToString
@AllArgsConstructor // 모든 필드값을 인자로 받는 생성자
@NoArgsConstructor // 기본 생성자
public class BusinessCard {
    private String name;
    private String phone;
    private String companyName;
    private Date createDate;

    public BusinessCard(String name, String phone, String companyName) {
        this.name = name;
        this.phone = phone;
        this.companyName = companyName;
    }


}
