package com.cdz.service.impl;

import com.cdz.exceptions.UserException;
import com.cdz.mapper.BranchMapper;
import com.cdz.model.Branch;
import com.cdz.model.Store;
import com.cdz.model.User;
import com.cdz.payload.dto.BranchDTO;
import com.cdz.repository.BranchRepository;
import com.cdz.repository.StoreRepository;
import com.cdz.service.BranchService;
import com.cdz.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final StoreRepository storeRepository;
    private final UserService userService;

    @Override
    public BranchDTO createBranch(BranchDTO branchDTO) throws UserException {
        User currentUser = userService.getCurrentUser();
        Store store = storeRepository.findByStoreAdminId(currentUser.getId());

        Branch branch = BranchMapper.toEntity(branchDTO, store);
        Branch savedBranch = branchRepository.save(branch);

        return BranchMapper.toDTO(savedBranch);
    }

    @Override
    public BranchDTO updateBranch(Long id, BranchDTO branchDTO) throws Exception {
        Branch existing =  branchRepository.findById(id).orElseThrow(
                ()-> new Exception("branch not found...")
        );

        existing.setName(branchDTO.getName());
        existing.setWorkingDays(branchDTO.getWorkingDays());
        existing.setEmail(branchDTO.getEmail());
        existing.setAddress(branchDTO.getAddress());
        existing.setPhone(branchDTO.getPhone());
        existing.setOpenTime(branchDTO.getOpenTime());
        existing.setCloseTime(branchDTO.getCloseTime());
        existing.setUpdatedAt(LocalDateTime.now());

        Branch updatedBranch = branchRepository.save(existing);

        return BranchMapper.toDTO(updatedBranch);
    }

    @Override
    public void deleteBranch(Long id) throws Exception {
        Branch existing =  branchRepository.findById(id).orElseThrow(
                ()-> new Exception("branch not found...")
        );
        branchRepository.delete(existing);

    }

    @Override
    public List<BranchDTO> getAllBranchesByStoreId(Long storeId) {
        List<Branch> branches = branchRepository.findAllByStoreId(storeId);

        return branches.stream().map(BranchMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BranchDTO getBranchById(Long id) throws Exception {
        Branch existing =  branchRepository.findById(id).orElseThrow(
                ()-> new Exception("branch not found...")
        );

        return BranchMapper.toDTO(existing);

    }


}
