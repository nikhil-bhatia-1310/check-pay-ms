package com.checkpay.mapper;

import org.mapstruct.Mapper;

import com.checkpay.entity.Account;
import com.checkpay.model.AccountVO;

@Mapper(componentModel = "spring")
public interface AccountMapper {
	Account mapAccountVoToEntity(AccountVO account);
}
