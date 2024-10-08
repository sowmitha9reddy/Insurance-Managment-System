package com.Insurance.Insurance.System.service;

import com.Insurance.Insurance.System.dto.ClaimDto;
import com.Insurance.Insurance.System.exception.ClaimNotFoundException;
import com.Insurance.Insurance.System.exception.PolicyNotFoundException;
import com.Insurance.Insurance.System.service.interfacess.ClaimDao;
import com.Insurance.Insurance.System.model.Claim;
import com.Insurance.Insurance.System.model.Policy;
import com.Insurance.Insurance.System.repository.ClaimRepository;
import com.Insurance.Insurance.System.repository.PolicyRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClaimDaoImpl implements ClaimDao {

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private PolicyRepositroy policyRepositroy;

    @Override
    public ClaimDto addClaim(ClaimDto claimDto) {
       Claim claimData= new Claim(claimDto);
       return mapToDTO(claimRepository.save(claimData));

    }



    private ClaimDto mapToDTO(Claim claim) {
        ClaimDto claimDto = new ClaimDto();
        claimDto.setClaimNumber(claim.getClaimNumber());
        claimDto.setAmount(claim.getAmount());
        claimDto.setStatus(claim.getStatus());
        return claimDto;
    }


    @Override
    public ClaimDto getClaim(long id) {
       return mapToDTO(claimRepository.findById(id).orElseThrow(() -> new ClaimNotFoundException(("Id not found"))));
    }




    @Override
    public List<ClaimDto> getAllClaims() {
        return claimRepository.findAll().stream()
                .map(policyHolder -> mapToDTO(policyHolder))
                .collect(Collectors.toList());
    }

    @Override
    public ClaimDto updateClaim(long id, ClaimDto claimDto) {
        Claim claimData =claimRepository.findById(id)
         .orElseThrow(() -> new ClaimNotFoundException("Claim ID not found"));

        if (claimData != null) {
            claimData.setClaimNumber(claimDto.getClaimNumber());
            claimData.setAmount(claimDto.getAmount());
            claimData.setStatus(claimDto.getStatus());
            return mapToDTO(claimRepository.save(claimData));
        }
        return null;

    }

    @Override
    public void deleteClaim(long id) {
        ClaimDto  claimDto=getClaim(id);
        Claim claim=new Claim(claimDto);

        claimRepository.delete(claim);
        System.out.println(("Deleted Successufully"));

    }

    @Override
    public void deleteAllClaims() {
        claimRepository.deleteAll();
    }

    public void  linkClaimtoPolicy(Long policyId, Long claimId) {

        Claim claim=claimRepository.findById(claimId)
                .orElseThrow(() -> new ClaimNotFoundException("Claim ID not found"));

        Policy policy = policyRepositroy.findById(policyId)
                .orElseThrow(() -> new PolicyNotFoundException("policy Id not found Exception"));


         claim.setPolicy(policy);
         claimRepository.save(claim);

        System.out.println("Claim linked to Policy successfully");



    }
}



