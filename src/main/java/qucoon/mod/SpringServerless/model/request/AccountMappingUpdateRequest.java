package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AccountMappingUpdateRequest {
public int accountMappingCrAccountId;
public String accountMappingCreatedAt;
public String accountMappingDescription;
public int accountMappingDrAccountId;
public int accountMappingId;
public String accountMappingStatus;
public int accountMappingTransactionCategoryId;
public String accountMappingUpdatedAt;
}
