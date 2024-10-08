package com.Insurance.Insurance.System.controller;

import com.Insurance.Insurance.System.dto.ClaimDto;
import com.Insurance.Insurance.System.service.ClaimDaoImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/claim")
public class ClaimController {
    @Autowired
    private ClaimDaoImpl claimDaoImpl;

    @PostMapping("/addph")
    public ClaimDto addPolicyHolder(@Valid @RequestBody ClaimDto claimDto) {
        return  claimDaoImpl.addClaim(claimDto);
    }

    @GetMapping("/getph/{id}")
    public ClaimDto getPolicyHolder(@PathVariable  long id) {
        return  claimDaoImpl.getClaim(id);
    }

    @GetMapping("/getphs")
    public List<ClaimDto> getAllPolicyHolders() {
        return claimDaoImpl.getAllClaims();
    }

    @PutMapping("/update/{id}")
    public ClaimDto updateEmployee(@PathVariable long id,@Valid @RequestBody ClaimDto claimDto) {
        return  claimDaoImpl.updateClaim(id,claimDto);
    }

    @DeleteMapping("/deleteph/{id}")
    public void deleteEmployee(@PathVariable long id) {
        claimDaoImpl.deleteClaim(id);
    }

    @DeleteMapping("/deleteAllEmps")
    public void deleteAllEmployees() {
        claimDaoImpl.deleteAllClaims();
    }

    @PostMapping("/linkClaimtoPolicy/{policyId}/{claimId}")
    public void linkClaimtoPolicy(@PathVariable Long policyId,@PathVariable Long claimId){
        claimDaoImpl.linkClaimtoPolicy(policyId,claimId);
    }

}
