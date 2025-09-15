package com.cdz.service.impl;

import com.cdz.exceptions.UserException;
import com.cdz.mapper.StoreMapper;
import com.cdz.model.Store;
import com.cdz.model.User;
import com.cdz.payload.dto.StoreDto;
import com.cdz.repository.StoreRepository;
import com.cdz.service.StoreService;
import com.cdz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final UserService userService;

    @Override
    public StoreDto createStore(StoreDto storeDto, User user) {

        Store store = StoreMapper.toEntity(storeDto,  user);

        return StoreMapper.toDTO(storeRepository.save(store));
    }

    @Override
    public StoreDto getStoreById(Long id) throws Exception {

        Store store = storeRepository.findById(id).orElseThrow(
                () -> new Exception("Store not found...")
        );
        return StoreMapper.toDTO(store);
    }

    @Override
    public List<StoreDto> getAllStores() {
        List<Store> dtos = storeRepository.findAll();
        return dtos.stream().map(StoreMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Store getStoreByAdmin() throws UserException {
        User admin = userService.getCurrentUser();
        return storeRepository.findByStoreAdminId(admin.getId());
    }

    @Override
    public StoreDto updateStore(Long id, StoreDto storeDto) {
        return null;
    }

    @Override
    public StoreDto deleteStore(Long id) {
        return null;
    }

    @Override
    public StoreDto getStoreByEmployee() throws UserException {

        User currentUser = userService.getCurrentUser();
        if (currentUser == null) {
            throw new UserException("Permission not granted");
        }

        return StoreMapper.toDTO(currentUser.getStore());
    }
}
