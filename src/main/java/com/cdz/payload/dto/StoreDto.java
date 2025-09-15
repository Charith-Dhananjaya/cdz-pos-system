package com.cdz.payload.dto;

import com.cdz.domain.StoreStatus;
import com.cdz.model.StoreContact;
import com.cdz.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;

public class StoreDto {

    private long Id;

    private String brand;

    private UserDto storeAdmin;

    private String description;

    private String storeType;

    private StoreStatus status;

    private StoreContact contact;

}
