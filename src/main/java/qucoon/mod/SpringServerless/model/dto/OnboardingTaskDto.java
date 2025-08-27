package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.OnboardingTask;


@Data
public class OnboardingTaskDto  {

private String onboardingTaskCreatedAt;
private Integer onboardingTaskCreatedBy;
private String onboardingTaskDescription;
private Integer onboardingTaskId;
private String onboardingTaskStatus;
private String onboardingTaskUpdatedAt;

public static OnboardingTaskDto from(OnboardingTask p) {
    OnboardingTaskDto dto = new OnboardingTaskDto();

    dto.setOnboardingTaskCreatedAt(p.getOnboardingTaskCreatedAt());
    dto.setOnboardingTaskCreatedBy(p.getOnboardingTaskCreatedBy());
    dto.setOnboardingTaskDescription(p.getOnboardingTaskDescription());
    dto.setOnboardingTaskId(p.getOnboardingTaskId());
    dto.setOnboardingTaskStatus(p.getOnboardingTaskStatus());
    dto.setOnboardingTaskUpdatedAt(p.getOnboardingTaskUpdatedAt());
    return dto;
   }
}
