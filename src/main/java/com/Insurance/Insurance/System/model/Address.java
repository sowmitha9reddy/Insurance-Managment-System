package com.Insurance.Insurance.System.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PolicyHolder_Address")
@Data
//@Setter
//@Getter
//@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Address {

//    id, street, city, state, zipcode,
    @Id
    @GeneratedValue
    private long id;
    private String street;
    private String city;
    private String state;
    private long zipcode;


    @ManyToOne
    @JoinColumn(name="ph_id")
    @JsonIgnore
    private PolicyHolder policyHolder;
}
