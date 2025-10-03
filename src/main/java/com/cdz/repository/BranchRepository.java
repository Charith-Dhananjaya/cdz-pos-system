package com.cdz.repository;

import com.cdz.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, Long> {

    List<Branch> findAllByStoreId(Long storeId);

}
