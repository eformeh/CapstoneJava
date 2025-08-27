package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AppraisalFormReadRequest {
@NotEmpty(message = "Appraisalformcreatedat is required")
public String appraisalFormCreatedAt;
@NotEmpty(message = "Appraisalformcreatedby is required")
public int appraisalFormCreatedBy;
@NotEmpty(message = "Appraisalformdescription is required")
public String appraisalFormDescription;
@NotEmpty(message = "Appraisalformid is required")
public int appraisalFormId;
@NotEmpty(message = "Appraisalformname is required")
public String appraisalFormName;
@NotEmpty(message = "Appraisalformstatus is required")
public String appraisalFormStatus;
@NotEmpty(message = "Appraisalformupdatedat is required")
public String appraisalFormUpdatedAt;
}
