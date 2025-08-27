package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class AppraisalResponseCreateRequest {
@NotNull(message = "appraisalResponseAppraisalId is required")
public int appraisalResponseAppraisalId;
@NotNull(message = "appraisalResponseQuestionId is required")
public int appraisalResponseQuestionId;
public Double appraisalResponseScore;
public String appraisalResponseValue;
}
