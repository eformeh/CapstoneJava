package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class EmployeeOnboardingUpdateRequest {
public int employeeOnboardingAssignedBy;
public String employeeOnboardingAttachmentUrl;
public String employeeOnboardingCompletedDate;
public String employeeOnboardingCreatedAt;
public String employeeOnboardingDueDate;
public int employeeOnboardingEmployeeId;
public int employeeOnboardingId;
public String employeeOnboardingNotes;
public String employeeOnboardingStatus;
public int employeeOnboardingTaskId;
public String employeeOnboardingUpdatedAt;
}
