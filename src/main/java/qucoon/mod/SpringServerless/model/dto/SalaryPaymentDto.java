package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.SalaryPayment;


@Data
public class SalaryPaymentDto  {

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

public static SalaryPaymentDto from(SalaryPayment p) {
    SalaryPaymentDto dto = new SalaryPaymentDto();

    dto.setSalaryPaymentAmount(p.getSalaryPaymentAmount());
    dto.setSalaryPaymentApprovedBy(p.getSalaryPaymentApprovedBy());
    dto.setSalaryPaymentChannel(p.getSalaryPaymentChannel());
    dto.setSalaryPaymentCreatedAt(p.getSalaryPaymentCreatedAt());
    dto.setSalaryPaymentEmployeeAccountId(p.getSalaryPaymentEmployeeAccountId());
    dto.setSalaryPaymentId(p.getSalaryPaymentId());
    dto.setSalaryPaymentSalaryId(p.getSalaryPaymentSalaryId());
    dto.setSalaryPaymentStatus(p.getSalaryPaymentStatus());
    dto.setSalaryPaymentTransactionId(p.getSalaryPaymentTransactionId());
    dto.setSalaryPaymentUpdatedAt(p.getSalaryPaymentUpdatedAt());
    return dto;
   }
}
