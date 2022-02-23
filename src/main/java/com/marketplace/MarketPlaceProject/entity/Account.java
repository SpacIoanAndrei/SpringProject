package com.marketplace.MarketPlaceProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    @Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    @NotBlank(message = "Email cannot be empty!") //mandatory when creating a new one
    private String email;

    private String firstName; //here or in another class used for log in ???????????????
    private String lastName; //here or in another class used for log in ???????????????
    private String userName; //here or in another class used for log in ???????????????

    @NotBlank(message = "Password cannot be empty!") //mandatory when creating a new one
    private String password;

    //@OneToMany(targetEntity=String.class, mappedBy="Account", fetch=FetchType.EAGER) --suitable for a list of defined class
    @ElementCollection
    private List<String> favorites;
    //@OneToMany(targetEntity=String.class, mappedBy="Account", fetch=FetchType.EAGER)
    @ElementCollection
    private List<String> postedAdds;

}
