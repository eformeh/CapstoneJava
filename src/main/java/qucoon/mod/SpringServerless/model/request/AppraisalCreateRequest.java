package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class AppraisalCreateRequest {
public String appraisalDate;
@NotNull(message = "appraisalEmployeeIdRoleId is required")
public int appraisalEmployeeIdRoleId;
@NotNull(message = "appraisalFormId is required")
public int appraisalFormId;
public String appraisalGeneralFeedback;
public Double appraisalOverallScore;
@NotNull(message = "appraisalReviewerId is required")
public int appraisalReviewerId;
}
