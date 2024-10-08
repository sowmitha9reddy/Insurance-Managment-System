package com.Insurance.Insurance.System.repository;

import com.Insurance.Insurance.System.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepositroy extends JpaRepository<Policy,Long> {
}
