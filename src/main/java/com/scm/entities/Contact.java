package com.scm.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Contact {

    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String picture;
    @Column(length = 1000)
    private String description;
    private boolean favourite = false;

    private String websiteLink;
    private String linkedInLink;
    //private List<String>socialLinks=new ArrayList<>();

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "contact", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<SocialLink> links = new ArrayList<>();


}
