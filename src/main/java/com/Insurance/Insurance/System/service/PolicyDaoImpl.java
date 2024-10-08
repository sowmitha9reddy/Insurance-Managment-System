package com.Insurance.Insurance.System.service;

import com.Insurance.Insurance.System.dto.PolicyDto;
import com.Insurance.Insurance.System.exception.AgentNotFoundException;
import com.Insurance.Insurance.System.exception.PolicyHolderNotFoundException;
import com.Insurance.Insurance.System.exception.PolicyNotFoundException;
import com.Insurance.Insurance.System.service.interfacess.PolicyDao;
import com.Insurance.Insurance.System.model.Agent;
import com.Insurance.Insurance.System.model.Claim;
import com.Insurance.Insurance.System.model.Policy;
import com.Insurance.Insurance.System.model.PolicyHolder;
import com.Insurance.Insurance.System.repository.AgentRepository;
import com.Insurance.Insurance.System.repository.PolicyHolderRepository;
import com.Insurance.Insurance.System.repository.PolicyRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PolicyDaoImpl implements PolicyDao {

    @Autowired
    private PolicyRepositroy policyRepositroy;

    @Autowired
    private PolicyHolderRepository policyHolderRepository;

    @Autowired
    private AgentRepository agentRepository;


    @Override
    public PolicyDto addPolicy(PolicyDto policyDto) {
      Policy policy=new Policy(policyDto);
      List<Claim> claims=policyDto.getClaims();
      if(claims!=null){
          claims.forEach(claim -> claim.setPolicy(policy));
      }

      return mapToDto(policyRepositroy.save(policy));
    }

    private PolicyDto mapToDto(Policy policy) {
        PolicyDto policyDto=new PolicyDto();
        policyDto.setPolicyNumber(policy.getPolicyNumber());
        policyDto.setType(policy.getType());
        policyDto.setClaims(policy.getClaims());

        return policyDto;
    }

    @Override
    public PolicyDto getPolicy(long id) {
        return mapToDto(policyRepositroy.findById(id).orElseThrow(() -> new PolicyNotFoundException("Policy id Not found")));
    }

    @Override
    public List<PolicyDto> getAllPolicies() {
        return policyRepositroy.findAll().stream()
                .map(policy -> mapToDto(policy))
                .collect(Collectors.toList());
    }

    @Override
    public PolicyDto updatePolicies(long id, PolicyDto policyDto) {
        Policy policy =policyRepositroy.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException("policy Id not found Exception"));

        if (policy != null) {
            policy.setPolicyNumber(policyDto.getPolicyNumber());
            policy.setType(policyDto.getType());
            List<Claim> claims=policyDto.getClaims();
            claims.forEach(claim -> claim.setPolicy(policy));

            policy.setClaims(claims);

           return mapToDto(policyRepositroy.save(policy));
        }
        return null;
    }

    @Override
    public void deletePolicy(long id) {
        PolicyDto policyDto=getPolicy(id);
        Policy policy=new Policy(policyDto);
        policyRepositroy.delete(policy);

    }

    @Override
    public void deleteAllPolicies() {
      policyRepositroy.deleteAll();
    }

    public void  linkPolicyToHolder(Long policyHolderId, Long policyId) {

        PolicyHolder holder =policyHolderRepository.findById(policyHolderId)
                .orElseThrow(() -> new PolicyHolderNotFoundException("Policy Holder ID not found"));
        Policy policy = policyRepositroy.findById(policyId)
                .orElseThrow(() -> new PolicyNotFoundException("policy Id not found Exception"));


        policy.setPolicyHolder(holder);
        policyRepositroy.save(policy);

        System.out.println("Policy given to policy holder Successfully");



    }
    public void  linkPolicyToAgent(Long policyId, Long agentId) {

       Agent agent=agentRepository.findById(agentId).orElseThrow(() -> new AgentNotFoundException("Agent id not found"));

        Policy policy = policyRepositroy.findById(policyId)
                .orElseThrow(() -> new PolicyNotFoundException("policy Id not found Exception"));


        policy.setAgent(agent);
        policyRepositroy.save(policy);

        System.out.println("Policy added to the agent  Successfully");
    }


}
