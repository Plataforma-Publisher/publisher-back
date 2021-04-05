package com.platformpublisher.mapper;

import com.platformpublisher.dto.request.UserRequestDTO;
import com.platformpublisher.dto.response.UserResponseDTO;
import com.platformpublisher.model.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUser(UserRequestDTO dto, @MappingTarget User user);

    User toModel(UserRequestDTO dto);

    UserResponseDTO toDto(User model);
}
