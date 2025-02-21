package com.sample.data.country.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Country implements Serializable {
    private Integer id;
    private String name;
    private String code;
    private String createdBy;
    private String modifiedBy;
    private boolean deleted;
}
