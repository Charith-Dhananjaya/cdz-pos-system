package com.cdz.mapper;

import com.cdz.model.Branch;
import com.cdz.model.Store;
import com.cdz.payload.dto.BranchDTO;

import java.time.LocalDateTime;

public class BranchMapper {

    public static BranchDTO toDTO(Branch branch){

        return BranchDTO.builder()
                .id(branch.getId())
                .name(branch.getName())
                .address(branch.getAddress())
                .phone(branch.getPhone())
                .email(branch.getEmail())
                .closeTime(branch.getCloseTime())
                .openTime(branch.getOpenTime())
                .workingDays(branch.getWorkingDays())
                .storeId(branch.getStore()!=null?branch.getStore().getId():null)
                .createdAt(branch.getCreatedAt())
                .updatedAt(branch.getUpdatedAt())
                .build();
    }

    public static Branch toEntity(BranchDTO branchDTO, Store store){

        return Branch.builder()
                .name(branchDTO.getName())
                .address(branchDTO.getAddress())
                .store(store)
                .phone(branchDTO.getPhone())
                .email(branchDTO.getEmail())
                .closeTime(branchDTO.getCloseTime())
                .openTime(branchDTO.getOpenTime())
                .workingDays(branchDTO.getWorkingDays())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
