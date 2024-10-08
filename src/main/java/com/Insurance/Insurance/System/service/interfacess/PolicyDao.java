package com.Insurance.Insurance.System.service.interfacess;

import com.Insurance.Insurance.System.dto.PolicyDto;

import java.util.List;

public interface PolicyDao {
    public PolicyDto addPolicy(PolicyDto policyDto);

    public  PolicyDto getPolicy(long id);

    public List<PolicyDto> getAllPolicies() ;


    public PolicyDto updatePolicies(long id,PolicyDto policyDto) ;

    public  void deletePolicy(long id) ;

    public  void deleteAllPolicies();
}
