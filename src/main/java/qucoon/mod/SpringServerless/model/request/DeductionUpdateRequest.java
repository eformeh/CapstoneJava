package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class DeductionUpdateRequest {
public Double deductionAmount;
public String deductionCreatedAt;
public int deductionId;
public int deductionSalaryId;
public String deductionStatus;
public String deductionType;
public String deductionUpdatedAt;
}
