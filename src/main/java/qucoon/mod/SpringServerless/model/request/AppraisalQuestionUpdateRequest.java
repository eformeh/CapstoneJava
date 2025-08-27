package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AppraisalQuestionUpdateRequest {
public int appraisalFormId;
public String appraisalQuestionCreatedAt;
public int appraisalQuestionId;
public String appraisalQuestionStatus;
public String appraisalQuestionText;
public String appraisalQuestionType;
public String appraisalQuestionUpdatedAt;
public Double appraisalQuestionWeight;
}
