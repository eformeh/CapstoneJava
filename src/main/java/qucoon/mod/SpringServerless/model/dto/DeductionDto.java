package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Deduction;


@Data
public class DeductionDto  {

private Double deductionAmount;
private String deductionCreatedAt;
private Integer deductionId;
private Integer deductionSalaryId;
private String deductionStatus;
private String deductionType;
private String deductionUpdatedAt;

public static DeductionDto from(Deduction p) {
    DeductionDto dto = new DeductionDto();

    dto.setDeductionAmount(p.getDeductionAmount());
    dto.setDeductionCreatedAt(p.getDeductionCreatedAt());
    dto.setDeductionId(p.getDeductionId());
    dto.setDeductionSalaryId(p.getDeductionSalaryId());
    dto.setDeductionStatus(p.getDeductionStatus());
    dto.setDeductionType(p.getDeductionType());
    dto.setDeductionUpdatedAt(p.getDeductionUpdatedAt());
    return dto;
   }
}
