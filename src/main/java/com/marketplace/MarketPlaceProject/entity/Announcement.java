package com.marketplace.MarketPlaceProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long announcementId;

    @NotBlank(message = "Please add Announcement title!") //mandatory when creating a new one
    private String announcementName;
    private String announcementDescription;
    private String category;
    private String announcementCity;
    private Integer price;
    private Integer phoneNumber;
    private Boolean reserved;
}
