package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AppraisalResponseReadRequest {
@NotEmpty(message = "Appraisalresponseappraisalid is required")
public int appraisalResponseAppraisalId;
@NotEmpty(message = "Appraisalresponsecreatedat is required")
public String appraisalResponseCreatedAt;
@NotEmpty(message = "Appraisalresponseid is required")
public int appraisalResponseId;
@NotEmpty(message = "Appraisalresponsequestionid is required")
public int appraisalResponseQuestionId;
@NotEmpty(message = "Appraisalresponsescore is required")
public Double appraisalResponseScore;
@NotEmpty(message = "Appraisalresponsestatus is required")
public String appraisalResponseStatus;
@NotEmpty(message = "Appraisalresponseupdatedat is required")
public String appraisalResponseUpdatedAt;
@NotEmpty(message = "Appraisalresponsevalue is required")
public String appraisalResponseValue;
}
