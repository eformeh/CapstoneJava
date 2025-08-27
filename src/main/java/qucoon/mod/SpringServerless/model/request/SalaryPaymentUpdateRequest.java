package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SalaryPaymentUpdateRequest {
public Double salaryPaymentAmount;
public int salaryPaymentApprovedBy;
public String salaryPaymentChannel;
public String salaryPaymentCreatedAt;
public int salaryPaymentEmployeeAccountId;
public int salaryPaymentId;
public int salaryPaymentSalaryId;
public String salaryPaymentStatus;
public int salaryPaymentTransactionId;
public String salaryPaymentUpdatedAt;
}
