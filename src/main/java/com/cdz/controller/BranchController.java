package com.cdz.controller;

import com.cdz.exceptions.UserException;
import com.cdz.payload.dto.BranchDTO;
import com.cdz.payload.response.ApiResponse;
import com.cdz.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/branches")
public class BranchController {


    private final BranchService branchService;

    @PostMapping
    public ResponseEntity<BranchDTO> createBranch(@RequestBody BranchDTO branchDTO) throws UserException {

        BranchDTO createdbranch = branchService.createBranch(branchDTO);
        return ResponseEntity.ok(createdbranch);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchDTO> getBranchById(
            @PathVariable Long id) throws Exception {

        BranchDTO createdbranch = branchService.getBranchById(id);
        return ResponseEntity.ok(createdbranch);
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<BranchDTO>> getAllBranchesByStoreId(
            @PathVariable Long storeId) throws Exception {

        List<BranchDTO> createdbranch = branchService.getAllBranchesByStoreId(storeId);
        return ResponseEntity.ok(createdbranch);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BranchDTO> updateBranch(
            @PathVariable Long id,
            @RequestBody BranchDTO branchDTO) throws Exception {

        BranchDTO createdbranch = branchService.updateBranch(id, branchDTO);
        return ResponseEntity.ok(createdbranch);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteBranch(
            @PathVariable Long id) throws Exception {

        branchService.deleteBranch(id);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Successfully deleted branch");

        return ResponseEntity.ok(apiResponse);
    }


}
