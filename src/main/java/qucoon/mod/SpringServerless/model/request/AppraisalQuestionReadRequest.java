package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AppraisalQuestionReadRequest {
@NotEmpty(message = "Appraisalformid is required")
public int appraisalFormId;
@NotEmpty(message = "Appraisalquestioncreatedat is required")
public String appraisalQuestionCreatedAt;
@NotEmpty(message = "Appraisalquestionid is required")
public int appraisalQuestionId;
@NotEmpty(message = "Appraisalquestionstatus is required")
public String appraisalQuestionStatus;
@NotEmpty(message = "Appraisalquestiontext is required")
public String appraisalQuestionText;
@NotEmpty(message = "Appraisalquestiontype is required")
public String appraisalQuestionType;
@NotEmpty(message = "Appraisalquestionupdatedat is required")
public String appraisalQuestionUpdatedAt;
@NotEmpty(message = "Appraisalquestionweight is required")
public Double appraisalQuestionWeight;
}
