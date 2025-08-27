package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class EmployeeUpdateRequest {
public String employeeContractEndDate;
public String employeeCreatedAt;
public String employeeDateOfBirth;
public String employeeEmail;
public String employeeEmploymentStatus;
public String employeeEmploymentType;
public String employeeFirstName;
public String employeeHireDate;
public int employeeId;
public int employeeJobId;
public String employeeLastName;
public String employeeMaritalStatus;
public String employeeNationality;
public String employeePhone;
public String employeePhotoUrl;
public String employeeStatus;
public String employeeUpdatedAt;
}
