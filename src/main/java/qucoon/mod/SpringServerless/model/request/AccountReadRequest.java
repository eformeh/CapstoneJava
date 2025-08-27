package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AccountReadRequest {
@NotEmpty(message = "Accountaccountname is required")
public String accountAccountName;
@NotEmpty(message = "Accountaccounttypeid is required")
public int accountAccountTypeId;
@NotEmpty(message = "Accountcreatedat is required")
public String accountCreatedAt;
@NotEmpty(message = "Accountdescription is required")
public String accountDescription;
@NotEmpty(message = "Accountid is required")
public int accountId;
@NotEmpty(message = "Accountstatus is required")
public String accountStatus;
@NotEmpty(message = "Accountupdatedat is required")
public String accountUpdatedAt;
}
