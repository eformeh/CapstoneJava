package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class SalaryPaymentCreateRequest {
public Double salaryPaymentAmount;
@NotNull(message = "salaryPaymentApprovedBy is required")
public int salaryPaymentApprovedBy;
public String salaryPaymentChannel;
@NotNull(message = "salaryPaymentEmployeeAccountId is required")
public int salaryPaymentEmployeeAccountId;
@NotNull(message = "salaryPaymentSalaryId is required")
public int salaryPaymentSalaryId;
@NotNull(message = "salaryPaymentTransactionId is required")
public int salaryPaymentTransactionId;
}
