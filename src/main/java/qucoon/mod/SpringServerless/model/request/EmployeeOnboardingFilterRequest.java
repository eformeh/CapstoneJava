package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EmployeeOnboardingFilterRequest {

private Integer employeeOnboardingAssignedBy;
private String employeeOnboardingAttachmentUrl;
private String employeeOnboardingCompletedDate;
private String employeeOnboardingCreatedAt;
private String employeeOnboardingDueDate;
private Integer employeeOnboardingEmployeeId;
private Integer employeeOnboardingId;
private String employeeOnboardingNotes;
private String employeeOnboardingStatus;
private Integer employeeOnboardingTaskId;
private String employeeOnboardingUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
