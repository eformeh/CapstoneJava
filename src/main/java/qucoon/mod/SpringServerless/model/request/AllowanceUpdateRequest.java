package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AllowanceUpdateRequest {
public Double allowanceAmount;
public String allowanceCreatedAt;
public int allowanceId;
public int allowanceSalaryId;
public String allowanceStatus;
public String allowanceType;
public String allowanceUpdatedAt;
}
