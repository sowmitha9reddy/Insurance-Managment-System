package com.Insurance.Insurance.System.model;

import com.Insurance.Insurance.System.dto.PolicyHolderDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name="Policy_Holder")
@Data
//@Setter
//@Getter
//@ToString
@AllArgsConstructor
@NoArgsConstructor

public class PolicyHolder {
   // id, name, email, policies, addresses
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "policyHolder",cascade=CascadeType.ALL)
    private List<Policy> policies;

    @OneToMany(mappedBy = "policyHolder",cascade=CascadeType.ALL)
    private List<Address> addresses;


    public PolicyHolder(PolicyHolderDto policyHolderDto) {

     this.name=policyHolderDto.getName();
     this.email=policyHolderDto.getEmail();
     this.policies=policyHolderDto.getPolicies();
     this.addresses=policyHolderDto.getAddresses();
    }
}

