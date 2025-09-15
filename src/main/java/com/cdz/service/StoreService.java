package com.cdz.service;

import com.cdz.exceptions.UserException;
import com.cdz.model.Store;
import com.cdz.model.User;
import com.cdz.payload.dto.StoreDto;

import java.util.List;

public interface StoreService {

    StoreDto createStore(StoreDto storeDto, User user);
    StoreDto getStoreById(Long id) throws Exception;
    List<StoreDto> getAllStores();
    Store getStoreByAdmin() throws UserException;
    StoreDto updateStore(Long id, StoreDto storeDto);
    StoreDto deleteStore(Long id);
    StoreDto getStoreByEmployee() throws UserException;

}
