package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.AccountType;


@Data
public class AccountTypeDto  {

private String accountTypeAccountTypeName;
private String accountTypeCreatedAt;
private String accountTypeDescription;
private Integer accountTypeId;
private String accountTypeNormalBalance;
private String accountTypeStatus;
private String accountTypeUpdatedAt;

public static AccountTypeDto from(AccountType p) {
    AccountTypeDto dto = new AccountTypeDto();

    dto.setAccountTypeAccountTypeName(p.getAccountTypeAccountTypeName());
    dto.setAccountTypeCreatedAt(p.getAccountTypeCreatedAt());
    dto.setAccountTypeDescription(p.getAccountTypeDescription());
    dto.setAccountTypeId(p.getAccountTypeId());
    dto.setAccountTypeNormalBalance(p.getAccountTypeNormalBalance());
    dto.setAccountTypeStatus(p.getAccountTypeStatus());
    dto.setAccountTypeUpdatedAt(p.getAccountTypeUpdatedAt());
    return dto;
   }
}
