package com.Insurance.Insurance.System.dto;


import com.Insurance.Insurance.System.model.Claim;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PolicyDto {

    @NotNull
    private String policyNumber;


    private  Type type;


    private List<Claim> claims;


    public enum Type {
        LIFE_INSURANCE,
        HEALTH_INSURANCE,
        VEHICLE_INSURANCE,
        HOME_INSURANCE
    }


}
