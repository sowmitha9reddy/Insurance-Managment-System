package com.Insurance.Insurance.System.service.interfacess;

import com.Insurance.Insurance.System.dto.ClaimDto;

import java.util.List;

public interface ClaimDao {
    public ClaimDto addClaim(ClaimDto claimDto);

    public  ClaimDto getClaim(long id);

    public List<ClaimDto> getAllClaims() ;


    public ClaimDto updateClaim(long id, ClaimDto claimDto) ;

    public  void deleteClaim(long id) ;

    public  void deleteAllClaims();
}
