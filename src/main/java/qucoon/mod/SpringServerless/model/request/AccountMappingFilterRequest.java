package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AccountMappingFilterRequest {

private Integer accountMappingCrAccountId;
private String accountMappingCreatedAt;
private String accountMappingDescription;
private Integer accountMappingDrAccountId;
private Integer accountMappingId;
private String accountMappingStatus;
private Integer accountMappingTransactionCategoryId;
private String accountMappingUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
