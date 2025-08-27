package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AllowanceReadRequest {
@NotEmpty(message = "Allowanceamount is required")
public Double allowanceAmount;
@NotEmpty(message = "Allowancecreatedat is required")
public String allowanceCreatedAt;
@NotEmpty(message = "Allowanceid is required")
public int allowanceId;
@NotEmpty(message = "Allowancesalaryid is required")
public int allowanceSalaryId;
@NotEmpty(message = "Allowancestatus is required")
public String allowanceStatus;
@NotEmpty(message = "Allowancetype is required")
public String allowanceType;
@NotEmpty(message = "Allowanceupdatedat is required")
public String allowanceUpdatedAt;
}
