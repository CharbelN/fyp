package com.example.eventfinder.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Event_Id;

    private Integer User_Id;

    private String Event_Title;

    private LocalDateTime Event_Date_Time;

    @ManyToOne
    @JoinColumn(name = "address_id") // Specify the foreign key column
    private Address address; // Establish relationship with Address entity
    private int Image;

    private String Description;

    @ManyToMany
    @JoinTable(
            name = "event_tag",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

    // Getters and setters for other fields

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Integer getEvent_Id() {
        return Event_Id;
    }

    public void setEvent_Id(Integer event_Id) {
        Event_Id = event_Id;
    }

    public int getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(int user_Id) {
        User_Id = user_Id;
    }

    public String getEvent_Title() {
        return Event_Title;
    }

    public void setEvent_Title(String event_Title) {
        Event_Title = event_Title;
    }

    public LocalDateTime getEvent_Date_Time() {
        return Event_Date_Time;
    }

    public void setEvent_Date_Time(LocalDateTime event_Date_Time) {
        Event_Date_Time = event_Date_Time;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
