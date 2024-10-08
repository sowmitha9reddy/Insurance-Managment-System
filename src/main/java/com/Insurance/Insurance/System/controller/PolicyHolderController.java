package com.Insurance.Insurance.System.controller;

import com.Insurance.Insurance.System.dto.PolicyHolderDto;
import com.Insurance.Insurance.System.service.PolicyHolderDaoImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policyholder")
public class PolicyHolderController {

    @Autowired
    private PolicyHolderDaoImpl policyHolderDaoImpl;

    @PostMapping("/addph")
    public PolicyHolderDto addPolicyHolder(@Valid @RequestBody PolicyHolderDto policyHolderDto) {
        return  policyHolderDaoImpl.addPolicyHolder(policyHolderDto);
    }

    @GetMapping("/getph/{id}")
    public PolicyHolderDto getPolicyHolder(@PathVariable  long id) {
        return  policyHolderDaoImpl.getPolicyHolder(id);
    }

    @GetMapping("/getphs")
    public List<PolicyHolderDto> getAllPolicyHolders() {
        return policyHolderDaoImpl.getAllPolicyHolders();
    }

    @PutMapping("/update/{id}")
    public PolicyHolderDto updateEmployee(@PathVariable long id,@Valid @RequestBody PolicyHolderDto policyHolderDto) {
        return  policyHolderDaoImpl.updatePolicyHolder(id,policyHolderDto);
    }

    @DeleteMapping("/deleteph/{id}")
    public void deleteEmployee(@PathVariable long id) {
        policyHolderDaoImpl.deletePolicyHolder(id);
    }

    @DeleteMapping("/deleteAllEmps")
    public void deleteAllEmployees(){policyHolderDaoImpl.deleteAllPolicyHolders();
    }


}
