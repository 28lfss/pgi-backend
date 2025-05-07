package com.lfssa.pgi.utils;

import com.lfssa.pgi.adapters.outbound.entities.JpaUserEntity;
import com.lfssa.pgi.domain.user.User;
import com.lfssa.pgi.domain.user.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserJpaMapper {
    User jpaUserToUser(JpaUserEntity userEntity);

    JpaUserEntity userToJpaUser(User user);

    UserResponseDTO userToResponse(User user);
}
