package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AppraisalReadRequest {
@NotEmpty(message = "Appraisalcreatedat is required")
public String appraisalCreatedAt;
@NotEmpty(message = "Appraisaldate is required")
public String appraisalDate;
@NotEmpty(message = "Appraisalemployeeidroleid is required")
public int appraisalEmployeeIdRoleId;
@NotEmpty(message = "Appraisalformid is required")
public int appraisalFormId;
@NotEmpty(message = "Appraisalgeneralfeedback is required")
public String appraisalGeneralFeedback;
@NotEmpty(message = "Appraisalid is required")
public int appraisalId;
@NotEmpty(message = "Appraisaloverallscore is required")
public Double appraisalOverallScore;
@NotEmpty(message = "Appraisalreviewerid is required")
public int appraisalReviewerId;
@NotEmpty(message = "Appraisalstatus is required")
public String appraisalStatus;
@NotEmpty(message = "Appraisalupdatedat is required")
public String appraisalUpdatedAt;
}
