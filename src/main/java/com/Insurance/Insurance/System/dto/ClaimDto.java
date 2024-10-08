package com.Insurance.Insurance.System.dto;

import com.Insurance.Insurance.System.model.Claim;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClaimDto {

    @NotEmpty
    private String claimNumber;

    @NotNull
    private float amount;


    private Claim.Status status;




    public enum Status {
        PENDING,
        APPROVED,
        REJECTED
    }


}
