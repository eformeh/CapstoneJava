package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.AccountMapping;


@Data
public class AccountMappingDto  {

private Integer accountMappingCrAccountId;
private String accountMappingCreatedAt;
private String accountMappingDescription;
private Integer accountMappingDrAccountId;
private Integer accountMappingId;
private String accountMappingStatus;
private Integer accountMappingTransactionCategoryId;
private String accountMappingUpdatedAt;

public static AccountMappingDto from(AccountMapping p) {
    AccountMappingDto dto = new AccountMappingDto();

    dto.setAccountMappingCrAccountId(p.getAccountMappingCrAccountId());
    dto.setAccountMappingCreatedAt(p.getAccountMappingCreatedAt());
    dto.setAccountMappingDescription(p.getAccountMappingDescription());
    dto.setAccountMappingDrAccountId(p.getAccountMappingDrAccountId());
    dto.setAccountMappingId(p.getAccountMappingId());
    dto.setAccountMappingStatus(p.getAccountMappingStatus());
    dto.setAccountMappingTransactionCategoryId(p.getAccountMappingTransactionCategoryId());
    dto.setAccountMappingUpdatedAt(p.getAccountMappingUpdatedAt());
    return dto;
   }
}
