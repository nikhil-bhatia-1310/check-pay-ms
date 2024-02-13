package com.checkpay.mapper;

import org.mapstruct.Mapper;

import com.checkpay.entity.User;
import com.checkpay.model.UserVO;

@Mapper(componentModel = "spring")
public interface UserMapper {
	User mapUserVoToEntity(UserVO user);
}
