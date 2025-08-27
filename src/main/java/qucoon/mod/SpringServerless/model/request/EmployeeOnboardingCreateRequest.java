package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class EmployeeOnboardingCreateRequest {
@NotNull(message = "employeeOnboardingAssignedBy is required")
public int employeeOnboardingAssignedBy;
public String employeeOnboardingAttachmentUrl;
public String employeeOnboardingCompletedDate;
public String employeeOnboardingDueDate;
@NotNull(message = "employeeOnboardingEmployeeId is required")
public int employeeOnboardingEmployeeId;
public String employeeOnboardingNotes;
@NotNull(message = "employeeOnboardingTaskId is required")
public int employeeOnboardingTaskId;
}
