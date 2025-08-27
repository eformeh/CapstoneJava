package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class EmployeeAccountCreateRequest {
public String employeeAccountBankName;
@NotNull(message = "employeeAccountEmployeeId is required")
public int employeeAccountEmployeeId;
public String employeeAccountName;
public String employeeAccountNumber;
}
