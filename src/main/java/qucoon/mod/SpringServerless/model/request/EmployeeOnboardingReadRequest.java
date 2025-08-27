package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class EmployeeOnboardingReadRequest {
@NotEmpty(message = "Employeeonboardingassignedby is required")
public int employeeOnboardingAssignedBy;
@NotEmpty(message = "Employeeonboardingattachmenturl is required")
public String employeeOnboardingAttachmentUrl;
@NotEmpty(message = "Employeeonboardingcompleteddate is required")
public String employeeOnboardingCompletedDate;
@NotEmpty(message = "Employeeonboardingcreatedat is required")
public String employeeOnboardingCreatedAt;
@NotEmpty(message = "Employeeonboardingduedate is required")
public String employeeOnboardingDueDate;
@NotEmpty(message = "Employeeonboardingemployeeid is required")
public int employeeOnboardingEmployeeId;
@NotEmpty(message = "Employeeonboardingid is required")
public int employeeOnboardingId;
@NotEmpty(message = "Employeeonboardingnotes is required")
public String employeeOnboardingNotes;
@NotEmpty(message = "Employeeonboardingstatus is required")
public String employeeOnboardingStatus;
@NotEmpty(message = "Employeeonboardingtaskid is required")
public int employeeOnboardingTaskId;
@NotEmpty(message = "Employeeonboardingupdatedat is required")
public String employeeOnboardingUpdatedAt;
}
