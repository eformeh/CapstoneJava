package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AccountTypeFilterRequest {

private String accountTypeAccountTypeName;
private String accountTypeCreatedAt;
private String accountTypeDescription;
private Integer accountTypeId;
private String accountTypeNormalBalance;
private String accountTypeStatus;
private String accountTypeUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
