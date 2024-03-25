package com.example.eventfinder.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Tag_Id;

    private String Tag_Name;

    public Integer getTag_Id() {
        return Tag_Id;
    }

    public void setTag_Id(Integer tag_Id) {
        Tag_Id = tag_Id;
    }

    public String getTag_Name() {
        return Tag_Name;
    }

    public void setTag_Name(String tag_Name) {
        Tag_Name = tag_Name;
    }
}
