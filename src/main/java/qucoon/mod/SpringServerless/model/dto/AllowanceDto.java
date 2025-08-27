package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Allowance;


@Data
public class AllowanceDto  {

private Double allowanceAmount;
private String allowanceCreatedAt;
private Integer allowanceId;
private Integer allowanceSalaryId;
private String allowanceStatus;
private String allowanceType;
private String allowanceUpdatedAt;

public static AllowanceDto from(Allowance p) {
    AllowanceDto dto = new AllowanceDto();

    dto.setAllowanceAmount(p.getAllowanceAmount());
    dto.setAllowanceCreatedAt(p.getAllowanceCreatedAt());
    dto.setAllowanceId(p.getAllowanceId());
    dto.setAllowanceSalaryId(p.getAllowanceSalaryId());
    dto.setAllowanceStatus(p.getAllowanceStatus());
    dto.setAllowanceType(p.getAllowanceType());
    dto.setAllowanceUpdatedAt(p.getAllowanceUpdatedAt());
    return dto;
   }
}
