package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AppraisalFormUpdateRequest {
public String appraisalFormCreatedAt;
public int appraisalFormCreatedBy;
public String appraisalFormDescription;
public int appraisalFormId;
public String appraisalFormName;
public String appraisalFormStatus;
public String appraisalFormUpdatedAt;
}
