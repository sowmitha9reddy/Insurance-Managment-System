package com.Insurance.Insurance.System.model;

import com.Insurance.Insurance.System.dto.ClaimDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "Claim")
@Data
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Claim {

    //id, claimNumber, date, amount, status, policy
    @Id
    @GeneratedValue

    private  long id;


    private String claimNumber;

    @CreationTimestamp
    private LocalDate date;


    private float amount;

    @Enumerated(EnumType.STRING)
    private  Status status;

    @ManyToOne
    @JoinColumn(name="policy_id")
    @JsonIgnore
    private Policy policy;

    public Claim(ClaimDto claimDto) {
        this.amount=claimDto.getAmount();
        this.claimNumber=claimDto.getClaimNumber();
        this.status=claimDto.getStatus();

    }

    public enum Status {
        PENDING,
        APPROVED,
        REJECTED
    }


}
