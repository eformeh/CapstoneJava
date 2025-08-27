package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AppraisalResponseUpdateRequest {
public int appraisalResponseAppraisalId;
public String appraisalResponseCreatedAt;
public int appraisalResponseId;
public int appraisalResponseQuestionId;
public Double appraisalResponseScore;
public String appraisalResponseStatus;
public String appraisalResponseUpdatedAt;
public String appraisalResponseValue;
}
