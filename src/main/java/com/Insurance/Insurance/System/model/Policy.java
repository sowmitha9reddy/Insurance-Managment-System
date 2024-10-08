package com.Insurance.Insurance.System.model;

import com.Insurance.Insurance.System.dto.PolicyDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="Policy")
@Data
//@Setter
//@Getter
//@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Policy {
    //Policy: id, policyNumber, type, claims, agent, policyHolder

    @Id
    @GeneratedValue
    private long id;


    private String policyNumber;


    @Enumerated(EnumType.STRING)
    private PolicyDto.Type type;

    @OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    private List<Claim> claims;

    @ManyToOne
    @JoinColumn(name="agent_id")
    @JsonIgnore
    private Agent agent;


    @ManyToOne
    @JoinColumn(name="ph_id")
    @JsonIgnore
    private PolicyHolder policyHolder;

    public Policy(PolicyDto policyDto) {

        this.policyNumber=policyDto.getPolicyNumber();
         this.type=policyDto.getType();

        this.claims=policyDto.getClaims();
    }

    public enum Type {
        LIFE_INSURANCE,
        HEALTH_INSURANCE,
        VEHICLE_INSURANCE,
        HOME_INSURANCE

    }



}
