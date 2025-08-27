package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class AppraisalQuestionCreateRequest {
@NotNull(message = "appraisalFormId is required")
public int appraisalFormId;
public String appraisalQuestionText;
public String appraisalQuestionType;
public Double appraisalQuestionWeight;
}
