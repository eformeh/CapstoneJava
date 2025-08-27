package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.EmployeeOnboarding;


@Data
public class EmployeeOnboardingDto  {

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

public static EmployeeOnboardingDto from(EmployeeOnboarding p) {
    EmployeeOnboardingDto dto = new EmployeeOnboardingDto();

    dto.setEmployeeOnboardingAssignedBy(p.getEmployeeOnboardingAssignedBy());
    dto.setEmployeeOnboardingAttachmentUrl(p.getEmployeeOnboardingAttachmentUrl());
    dto.setEmployeeOnboardingCompletedDate(p.getEmployeeOnboardingCompletedDate());
    dto.setEmployeeOnboardingCreatedAt(p.getEmployeeOnboardingCreatedAt());
    dto.setEmployeeOnboardingDueDate(p.getEmployeeOnboardingDueDate());
    dto.setEmployeeOnboardingEmployeeId(p.getEmployeeOnboardingEmployeeId());
    dto.setEmployeeOnboardingId(p.getEmployeeOnboardingId());
    dto.setEmployeeOnboardingNotes(p.getEmployeeOnboardingNotes());
    dto.setEmployeeOnboardingStatus(p.getEmployeeOnboardingStatus());
    dto.setEmployeeOnboardingTaskId(p.getEmployeeOnboardingTaskId());
    dto.setEmployeeOnboardingUpdatedAt(p.getEmployeeOnboardingUpdatedAt());
    return dto;
   }
}
