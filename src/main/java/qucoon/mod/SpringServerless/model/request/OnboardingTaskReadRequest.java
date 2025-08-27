package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OnboardingTaskReadRequest {
@NotEmpty(message = "Onboardingtaskcreatedat is required")
public String onboardingTaskCreatedAt;
@NotEmpty(message = "Onboardingtaskcreatedby is required")
public int onboardingTaskCreatedBy;
@NotEmpty(message = "Onboardingtaskdescription is required")
public String onboardingTaskDescription;
@NotEmpty(message = "Onboardingtaskid is required")
public int onboardingTaskId;
@NotEmpty(message = "Onboardingtaskstatus is required")
public String onboardingTaskStatus;
@NotEmpty(message = "Onboardingtaskupdatedat is required")
public String onboardingTaskUpdatedAt;
}
