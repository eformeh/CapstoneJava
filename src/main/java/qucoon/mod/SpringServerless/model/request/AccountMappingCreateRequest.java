package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class AccountMappingCreateRequest {
@NotNull(message = "accountMappingCrAccountId is required")
public int accountMappingCrAccountId;
public String accountMappingDescription;
@NotNull(message = "accountMappingDrAccountId is required")
public int accountMappingDrAccountId;
@NotNull(message = "accountMappingTransactionCategoryId is required")
public int accountMappingTransactionCategoryId;
}
