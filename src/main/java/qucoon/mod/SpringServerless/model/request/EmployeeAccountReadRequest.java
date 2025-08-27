package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class EmployeeAccountReadRequest {
@NotEmpty(message = "Employeeaccountbankname is required")
public String employeeAccountBankName;
@NotEmpty(message = "Employeeaccountcreatedat is required")
public String employeeAccountCreatedAt;
@NotEmpty(message = "Employeeaccountemployeeid is required")
public int employeeAccountEmployeeId;
@NotEmpty(message = "Employeeaccountid is required")
public int employeeAccountId;
@NotEmpty(message = "Employeeaccountname is required")
public String employeeAccountName;
@NotEmpty(message = "Employeeaccountnumber is required")
public String employeeAccountNumber;
@NotEmpty(message = "Employeeaccountstatus is required")
public String employeeAccountStatus;
@NotEmpty(message = "Employeeaccountupdatedat is required")
public String employeeAccountUpdatedAt;
}
