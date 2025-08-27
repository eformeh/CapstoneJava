package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SalaryPaymentReadRequest {
@NotEmpty(message = "Salarypaymentamount is required")
public Double salaryPaymentAmount;
@NotEmpty(message = "Salarypaymentapprovedby is required")
public int salaryPaymentApprovedBy;
@NotEmpty(message = "Salarypaymentchannel is required")
public String salaryPaymentChannel;
@NotEmpty(message = "Salarypaymentcreatedat is required")
public String salaryPaymentCreatedAt;
@NotEmpty(message = "Salarypaymentemployeeaccountid is required")
public int salaryPaymentEmployeeAccountId;
@NotEmpty(message = "Salarypaymentid is required")
public int salaryPaymentId;
@NotEmpty(message = "Salarypaymentsalaryid is required")
public int salaryPaymentSalaryId;
@NotEmpty(message = "Salarypaymentstatus is required")
public String salaryPaymentStatus;
@NotEmpty(message = "Salarypaymenttransactionid is required")
public int salaryPaymentTransactionId;
@NotEmpty(message = "Salarypaymentupdatedat is required")
public String salaryPaymentUpdatedAt;
}
