package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OnboardingTaskUpdateRequest {
public String onboardingTaskCreatedAt;
public int onboardingTaskCreatedBy;
public String onboardingTaskDescription;
public int onboardingTaskId;
public String onboardingTaskStatus;
public String onboardingTaskUpdatedAt;
}
