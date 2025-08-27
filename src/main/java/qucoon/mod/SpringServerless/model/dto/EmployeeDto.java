package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Employee;


@Data
public class EmployeeDto  {

private String employeeContractEndDate;
private String employeeCreatedAt;
private String employeeDateOfBirth;
private String employeeEmail;
private String employeeEmploymentStatus;
private String employeeEmploymentType;
private String employeeFirstName;
private String employeeHireDate;
private Integer employeeId;
private Integer employeeJobId;
private String employeeLastName;
private String employeeMaritalStatus;
private String employeeNationality;
private String employeePhone;
private String employeePhotoUrl;
private String employeeStatus;
private String employeeUpdatedAt;

public static EmployeeDto from(Employee p) {
    EmployeeDto dto = new EmployeeDto();

    dto.setEmployeeContractEndDate(p.getEmployeeContractEndDate());
    dto.setEmployeeCreatedAt(p.getEmployeeCreatedAt());
    dto.setEmployeeDateOfBirth(p.getEmployeeDateOfBirth());
    dto.setEmployeeEmail(p.getEmployeeEmail());
    dto.setEmployeeEmploymentStatus(p.getEmployeeEmploymentStatus());
    dto.setEmployeeEmploymentType(p.getEmployeeEmploymentType());
    dto.setEmployeeFirstName(p.getEmployeeFirstName());
    dto.setEmployeeHireDate(p.getEmployeeHireDate());
    dto.setEmployeeId(p.getEmployeeId());
    dto.setEmployeeJobId(p.getEmployeeJobId());
    dto.setEmployeeLastName(p.getEmployeeLastName());
    dto.setEmployeeMaritalStatus(p.getEmployeeMaritalStatus());
    dto.setEmployeeNationality(p.getEmployeeNationality());
    dto.setEmployeePhone(p.getEmployeePhone());
    dto.setEmployeePhotoUrl(p.getEmployeePhotoUrl());
    dto.setEmployeeStatus(p.getEmployeeStatus());
    dto.setEmployeeUpdatedAt(p.getEmployeeUpdatedAt());
    return dto;
   }
}
