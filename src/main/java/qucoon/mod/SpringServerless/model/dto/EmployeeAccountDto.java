package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.EmployeeAccount;


@Data
public class EmployeeAccountDto  {

private String employeeAccountBankName;
private String employeeAccountCreatedAt;
private Integer employeeAccountEmployeeId;
private Integer employeeAccountId;
private String employeeAccountName;
private String employeeAccountNumber;
private String employeeAccountStatus;
private String employeeAccountUpdatedAt;

public static EmployeeAccountDto from(EmployeeAccount p) {
    EmployeeAccountDto dto = new EmployeeAccountDto();

    dto.setEmployeeAccountBankName(p.getEmployeeAccountBankName());
    dto.setEmployeeAccountCreatedAt(p.getEmployeeAccountCreatedAt());
    dto.setEmployeeAccountEmployeeId(p.getEmployeeAccountEmployeeId());
    dto.setEmployeeAccountId(p.getEmployeeAccountId());
    dto.setEmployeeAccountName(p.getEmployeeAccountName());
    dto.setEmployeeAccountNumber(p.getEmployeeAccountNumber());
    dto.setEmployeeAccountStatus(p.getEmployeeAccountStatus());
    dto.setEmployeeAccountUpdatedAt(p.getEmployeeAccountUpdatedAt());
    return dto;
   }
}
