package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Account;


@Data
public class AccountDto  {

private String accountAccountName;
private Integer accountAccountTypeId;
private String accountCreatedAt;
private String accountDescription;
private Integer accountId;
private String accountStatus;
private String accountUpdatedAt;

public static AccountDto from(Account p) {
    AccountDto dto = new AccountDto();

    dto.setAccountAccountName(p.getAccountAccountName());
    dto.setAccountAccountTypeId(p.getAccountAccountTypeId());
    dto.setAccountCreatedAt(p.getAccountCreatedAt());
    dto.setAccountDescription(p.getAccountDescription());
    dto.setAccountId(p.getAccountId());
    dto.setAccountStatus(p.getAccountStatus());
    dto.setAccountUpdatedAt(p.getAccountUpdatedAt());
    return dto;
   }
}
