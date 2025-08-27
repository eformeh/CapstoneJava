package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class EmployeeCreateRequest {
public String employeeContractEndDate;
public String employeeDateOfBirth;
public String employeeEmail;
public String employeeEmploymentStatus;
public String employeeEmploymentType;
public String employeeFirstName;
public String employeeHireDate;
@NotNull(message = "employeeJobId is required")
public int employeeJobId;
public String employeeLastName;
public String employeeMaritalStatus;
public String employeeNationality;
public String employeePhone;
public String employeePhotoUrl;
}
