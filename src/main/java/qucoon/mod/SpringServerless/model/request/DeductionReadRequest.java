package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class DeductionReadRequest {
@NotEmpty(message = "Deductionamount is required")
public Double deductionAmount;
@NotEmpty(message = "Deductioncreatedat is required")
public String deductionCreatedAt;
@NotEmpty(message = "Deductionid is required")
public int deductionId;
@NotEmpty(message = "Deductionsalaryid is required")
public int deductionSalaryId;
@NotEmpty(message = "Deductionstatus is required")
public String deductionStatus;
@NotEmpty(message = "Deductiontype is required")
public String deductionType;
@NotEmpty(message = "Deductionupdatedat is required")
public String deductionUpdatedAt;
}
