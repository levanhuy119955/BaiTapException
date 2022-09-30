package com.tmt.exception.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CategoryExceptionEntity {
    private Integer code;
    private String message;
    private Date timestamp;
}
