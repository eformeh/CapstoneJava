package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class AllowanceCreateRequest {
public Double allowanceAmount;
@NotNull(message = "allowanceSalaryId is required")
public int allowanceSalaryId;
public String allowanceType;
}
