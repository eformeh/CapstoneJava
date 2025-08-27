package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AccountTypeUpdateRequest {
public String accountTypeAccountTypeName;
public String accountTypeCreatedAt;
public String accountTypeDescription;
public int accountTypeId;
public String accountTypeNormalBalance;
public String accountTypeStatus;
public String accountTypeUpdatedAt;
}
