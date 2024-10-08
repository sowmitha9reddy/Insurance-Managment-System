package com.Insurance.Insurance.System.service;

import com.Insurance.Insurance.System.dto.PolicyHolderDto;
import com.Insurance.Insurance.System.exception.PolicyHolderNotFoundException;
import com.Insurance.Insurance.System.service.interfacess.PolicyHolderDao;
import com.Insurance.Insurance.System.model.Address;
import com.Insurance.Insurance.System.model.Policy;
import com.Insurance.Insurance.System.model.PolicyHolder;
import com.Insurance.Insurance.System.repository.PolicyHolderRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PolicyHolderDaoImpl implements PolicyHolderDao {

    @Autowired
   private PolicyHolderRepository policyHolderRepository;


 @Override
 public PolicyHolderDto addPolicyHolder(PolicyHolderDto policyHolderDto) {
 PolicyHolder policyHolderData = new PolicyHolder(policyHolderDto);
    List<Address> addresses = policyHolderDto.getAddresses();

        if (addresses != null) {
            addresses.forEach(address -> address.setPolicyHolder(policyHolderData));
        }
     List<Policy> policies=policyHolderDto.getPolicies();


  return mapTODTO(policyHolderRepository.save(policyHolderData));

 }

    private PolicyHolderDto mapTODTO(PolicyHolder policyHolder) {
        PolicyHolderDto policyHolderDto = new PolicyHolderDto();
        policyHolderDto.setName(policyHolder.getName());
      policyHolderDto.setEmail(policyHolder.getEmail());
      policyHolderDto.setAddresses(policyHolder.getAddresses());
      policyHolderDto.setPolicies(policyHolder.getPolicies());
       return policyHolderDto;
    }

 @Override
 public PolicyHolderDto getPolicyHolder(long id) {
  return mapTODTO(policyHolderRepository.findById(id).orElseThrow(() -> new PolicyHolderNotFoundException("Id not found")));
 }

 @Override
 public List<PolicyHolderDto> getAllPolicyHolders() {
  return policyHolderRepository.findAll().stream()
                .map(policyHolder -> mapTODTO(policyHolder))
                .collect(Collectors.toList());
 }

 @Override
 public PolicyHolderDto updatePolicyHolder(long id, PolicyHolderDto policyHolderDto) {
  PolicyHolder policyHolderData = policyHolderRepository.findById(id)
                .orElseThrow(() -> new PolicyHolderNotFoundException("Policy Holder ID not found"));

        if(policyHolderData!=null) {
         policyHolderData.setName(policyHolderDto.getName());
         policyHolderData.setEmail(policyHolderDto.getEmail());

            List<Address> addresses=policyHolderDto.getAddresses();
            addresses.forEach(address -> address.setPolicyHolder(policyHolderData));
         policyHolderData.setAddresses(addresses);

          List<Policy> policies=policyHolderDto.getPolicies();
          policies.forEach(policy -> policy.setPolicyHolder(policyHolderData));
         policyHolderData.setPolicies(policies);
            return mapTODTO( policyHolderRepository.save(policyHolderData));
        }
        return null;
 }

 @Override
 public void deletePolicyHolder(long id) {
  PolicyHolderDto  policyHolderDto=getPolicyHolder(id);
  PolicyHolder policyHolder=new PolicyHolder(policyHolderDto);
 policyHolderRepository.delete(policyHolder);

 }

 @Override
 public void deleteAllPolicyHolders() {
     policyHolderRepository.deleteAll();
 }


}
