package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AccountMappingReadRequest {
@NotEmpty(message = "Accountmappingcraccountid is required")
public int accountMappingCrAccountId;
@NotEmpty(message = "Accountmappingcreatedat is required")
public String accountMappingCreatedAt;
@NotEmpty(message = "Accountmappingdescription is required")
public String accountMappingDescription;
@NotEmpty(message = "Accountmappingdraccountid is required")
public int accountMappingDrAccountId;
@NotEmpty(message = "Accountmappingid is required")
public int accountMappingId;
@NotEmpty(message = "Accountmappingstatus is required")
public String accountMappingStatus;
@NotEmpty(message = "Accountmappingtransactioncategoryid is required")
public int accountMappingTransactionCategoryId;
@NotEmpty(message = "Accountmappingupdatedat is required")
public String accountMappingUpdatedAt;
}
