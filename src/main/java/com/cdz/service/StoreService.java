package com.cdz.service;

import com.cdz.model.User;
import com.cdz.payload.dto.StoreDto;

import java.util.List;

public interface StoreService {

    StoreDto createStore(StoreDto storeDto, User user);
    StoreDto getStoreById(Long id);
    List<StoreDto> getAllStores();
    StoreDto getStoreByAdmin();
    StoreDto updateStore(Long id, StoreDto storeDto);
    StoreDto deleteStore(Long id);
    StoreDto getStoreByEmployee();

}
