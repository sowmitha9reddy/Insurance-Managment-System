package com.Insurance.Insurance.System.service.interfacess;

import com.Insurance.Insurance.System.dto.PolicyHolderDto;

import java.util.List;

public interface PolicyHolderDao {
    public PolicyHolderDto addPolicyHolder(PolicyHolderDto policyHolderDto);

    public  PolicyHolderDto getPolicyHolder(long id);

    public List<PolicyHolderDto> getAllPolicyHolders() ;


    public  PolicyHolderDto updatePolicyHolder(long id, PolicyHolderDto policyHolderDto) ;

    public  void deletePolicyHolder(long id) ;

    public  void deleteAllPolicyHolders();
}
