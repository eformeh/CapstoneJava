package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PayPeriodReadRequest {
@NotEmpty(message = "Payperiodcreatedat is required")
public String payPeriodCreatedAt;
@NotEmpty(message = "Payperiodenddate is required")
public String payPeriodEndDate;
@NotEmpty(message = "Payperiodid is required")
public int payPeriodId;
@NotEmpty(message = "Payperiodname is required")
public String payPeriodName;
@NotEmpty(message = "Payperiodperiodtype is required")
public String payPeriodPeriodType;
@NotEmpty(message = "Payperiodstartdate is required")
public String payPeriodStartDate;
@NotEmpty(message = "Payperiodstatus is required")
public String payPeriodStatus;
@NotEmpty(message = "Payperiodupdatedat is required")
public String payPeriodUpdatedAt;
}
