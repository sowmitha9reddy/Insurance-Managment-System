package com.Insurance.Insurance.System.repository;

import com.Insurance.Insurance.System.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository  extends JpaRepository<Claim,Long> {
}
