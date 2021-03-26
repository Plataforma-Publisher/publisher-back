package com.platformpublisher.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum UserType {

    ACTIVE("Active"),
    INACTIVE("Inactive");

    private final String description ;
}
