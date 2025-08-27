package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PayPeriodUpdateRequest {
public String payPeriodCreatedAt;
public String payPeriodEndDate;
public int payPeriodId;
public String payPeriodName;
public String payPeriodPeriodType;
public String payPeriodStartDate;
public String payPeriodStatus;
public String payPeriodUpdatedAt;
}
