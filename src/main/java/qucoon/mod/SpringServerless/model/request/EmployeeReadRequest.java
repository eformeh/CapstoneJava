package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class EmployeeReadRequest {
@NotEmpty(message = "Employeecontractenddate is required")
public String employeeContractEndDate;
@NotEmpty(message = "Employeecreatedat is required")
public String employeeCreatedAt;
@NotEmpty(message = "Employeedateofbirth is required")
public String employeeDateOfBirth;
@NotEmpty(message = "Employeeemail is required")
public String employeeEmail;
@NotEmpty(message = "Employeeemploymentstatus is required")
public String employeeEmploymentStatus;
@NotEmpty(message = "Employeeemploymenttype is required")
public String employeeEmploymentType;
@NotEmpty(message = "Employeefirstname is required")
public String employeeFirstName;
@NotEmpty(message = "Employeehiredate is required")
public String employeeHireDate;
@NotEmpty(message = "Employeeid is required")
public int employeeId;
@NotEmpty(message = "Employeejobid is required")
public int employeeJobId;
@NotEmpty(message = "Employeelastname is required")
public String employeeLastName;
@NotEmpty(message = "Employeemaritalstatus is required")
public String employeeMaritalStatus;
@NotEmpty(message = "Employeenationality is required")
public String employeeNationality;
@NotEmpty(message = "Employeephone is required")
public String employeePhone;
@NotEmpty(message = "Employeephotourl is required")
public String employeePhotoUrl;
@NotEmpty(message = "Employeestatus is required")
public String employeeStatus;
@NotEmpty(message = "Employeeupdatedat is required")
public String employeeUpdatedAt;
}
