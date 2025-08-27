package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class SalaryCreateRequest {
public Double salaryBasicAmount;
@NotNull(message = "salaryEmployeeId is required")
public int salaryEmployeeId;
public Double salaryGrossPay;
public Double salaryNetPay;
@NotNull(message = "salaryPayPeriodId is required")
public int salaryPayPeriodId;
}
