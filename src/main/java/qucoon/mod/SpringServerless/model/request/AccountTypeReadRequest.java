package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AccountTypeReadRequest {
@NotEmpty(message = "Accounttypeaccounttypename is required")
public String accountTypeAccountTypeName;
@NotEmpty(message = "Accounttypecreatedat is required")
public String accountTypeCreatedAt;
@NotEmpty(message = "Accounttypedescription is required")
public String accountTypeDescription;
@NotEmpty(message = "Accounttypeid is required")
public int accountTypeId;
@NotEmpty(message = "Accounttypenormalbalance is required")
public String accountTypeNormalBalance;
@NotEmpty(message = "Accounttypestatus is required")
public String accountTypeStatus;
@NotEmpty(message = "Accounttypeupdatedat is required")
public String accountTypeUpdatedAt;
}
