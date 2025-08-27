package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EmployeeFilterRequest {

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
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
