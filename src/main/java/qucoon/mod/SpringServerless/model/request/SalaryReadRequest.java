package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SalaryReadRequest {
@NotEmpty(message = "Salarybasicamount is required")
public Double salaryBasicAmount;
@NotEmpty(message = "Salarycreatedat is required")
public String salaryCreatedAt;
@NotEmpty(message = "Salaryemployeeid is required")
public int salaryEmployeeId;
@NotEmpty(message = "Salarygrosspay is required")
public Double salaryGrossPay;
@NotEmpty(message = "Salaryid is required")
public int salaryId;
@NotEmpty(message = "Salarynetpay is required")
public Double salaryNetPay;
@NotEmpty(message = "Salarypayperiodid is required")
public int salaryPayPeriodId;
@NotEmpty(message = "Salarystatus is required")
public String salaryStatus;
@NotEmpty(message = "Salaryupdatedat is required")
public String salaryUpdatedAt;
}
