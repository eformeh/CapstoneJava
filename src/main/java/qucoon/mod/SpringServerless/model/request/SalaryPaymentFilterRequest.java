package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SalaryPaymentFilterRequest {

private Double salaryPaymentAmount;
private Integer salaryPaymentApprovedBy;
private String salaryPaymentChannel;
private String salaryPaymentCreatedAt;
private Integer salaryPaymentEmployeeAccountId;
private Integer salaryPaymentId;
private Integer salaryPaymentSalaryId;
private String salaryPaymentStatus;
private Integer salaryPaymentTransactionId;
private String salaryPaymentUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
