package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class EmployeeAccountUpdateRequest {
public String employeeAccountBankName;
public String employeeAccountCreatedAt;
public int employeeAccountEmployeeId;
public int employeeAccountId;
public String employeeAccountName;
public String employeeAccountNumber;
public String employeeAccountStatus;
public String employeeAccountUpdatedAt;
}
