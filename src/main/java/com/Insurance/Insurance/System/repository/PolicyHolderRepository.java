package com.Insurance.Insurance.System.repository;

import com.Insurance.Insurance.System.model.PolicyHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyHolderRepository extends JpaRepository<PolicyHolder,Long> {
}
