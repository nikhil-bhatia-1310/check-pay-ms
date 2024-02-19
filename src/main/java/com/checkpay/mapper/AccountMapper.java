package com.checkpay.mapper;

import org.mapstruct.Mapper;

import com.checkpay.entity.User;
import com.checkpay.model.AccountVO;

@Mapper(componentModel = "spring")
public interface AccountMapper {
	User mapAccountVoToEntity(AccountVO account);
}
