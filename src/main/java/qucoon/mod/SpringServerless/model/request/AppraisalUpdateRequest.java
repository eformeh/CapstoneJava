package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AppraisalUpdateRequest {
public String appraisalCreatedAt;
public String appraisalDate;
public int appraisalEmployeeIdRoleId;
public int appraisalFormId;
public String appraisalGeneralFeedback;
public int appraisalId;
public Double appraisalOverallScore;
public int appraisalReviewerId;
public String appraisalStatus;
public String appraisalUpdatedAt;
}
