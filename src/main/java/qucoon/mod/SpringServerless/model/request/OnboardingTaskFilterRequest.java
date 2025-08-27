package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class OnboardingTaskFilterRequest {

private String onboardingTaskCreatedAt;
private Integer onboardingTaskCreatedBy;
private String onboardingTaskDescription;
private Integer onboardingTaskId;
private String onboardingTaskStatus;
private String onboardingTaskUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
