package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class AppraisalFormCreateRequest {
@NotNull(message = "appraisalFormCreatedBy is required")
public int appraisalFormCreatedBy;
public String appraisalFormDescription;
public String appraisalFormName;
}
