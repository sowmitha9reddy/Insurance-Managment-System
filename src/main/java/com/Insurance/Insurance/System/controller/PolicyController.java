package com.Insurance.Insurance.System.controller;



import com.Insurance.Insurance.System.dto.PolicyDto;
import com.Insurance.Insurance.System.service.PolicyDaoImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policy")
public class PolicyController {
    @Autowired
    private PolicyDaoImpl policyDaoImpl;

    @PostMapping("/addag")
    public PolicyDto addPolicy(@Valid @RequestBody PolicyDto policyDto) {
        return  policyDaoImpl.addPolicy(policyDto);
    }

    @GetMapping("/getag/{id}")
    public PolicyDto getPolicy (@PathVariable  long id) {
        return   policyDaoImpl.getPolicy(id);
    }

    @GetMapping("/getphs")
    public List<PolicyDto> getAllPolicies() {
        return  policyDaoImpl.getAllPolicies();
    }

    @PutMapping("/update/{id}")
    public PolicyDto updatePolicy(@PathVariable long id,@Valid @RequestBody PolicyDto policyDto) {
        return   policyDaoImpl.updatePolicies(id,policyDto);
    }

    @DeleteMapping("/deleteph/{id}")
    public void deletePolicy(@PathVariable long id) {
        policyDaoImpl.deletePolicy(id);
    }

    @DeleteMapping("/deleteAllEmps")
    public void deleteAllPolicies(){ policyDaoImpl.deleteAllPolicies();
    }

    @PostMapping("/linkPolicyToHolder/{policyHolderId}/{policyId}")
    public void  linkPolicyToHolder(@PathVariable Long policyHolderId,@PathVariable  Long policyId) {
        policyDaoImpl.linkPolicyToHolder(policyHolderId,policyId);


    }

    @PostMapping("/linkPolicyToAgent/{policyId}/{agentId}")
    public void  linkPolicyToAgent(@PathVariable Long policyId,@PathVariable Long agentId) {
        policyDaoImpl.linkPolicyToAgent(policyId,agentId);
    }

}
