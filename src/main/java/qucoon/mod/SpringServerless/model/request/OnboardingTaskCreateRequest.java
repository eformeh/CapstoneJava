package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class OnboardingTaskCreateRequest {
@NotNull(message = "onboardingTaskCreatedBy is required")
public int onboardingTaskCreatedBy;
public String onboardingTaskDescription;
}
