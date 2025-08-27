package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class DeductionCreateRequest {
public Double deductionAmount;
@NotNull(message = "deductionSalaryId is required")
public int deductionSalaryId;
public String deductionType;
}
