package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SalaryUpdateRequest {
public Double salaryBasicAmount;
public String salaryCreatedAt;
public int salaryEmployeeId;
public Double salaryGrossPay;
public int salaryId;
public Double salaryNetPay;
public int salaryPayPeriodId;
public String salaryStatus;
public String salaryUpdatedAt;
}
