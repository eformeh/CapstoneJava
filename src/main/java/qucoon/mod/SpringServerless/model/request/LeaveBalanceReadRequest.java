package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class LeaveBalanceReadRequest {
@NotEmpty(message = "Leavebalancecreatedat is required")
public String leaveBalanceCreatedAt;
@NotEmpty(message = "Leavebalanceemployeeid is required")
public int leaveBalanceEmployeeId;
@NotEmpty(message = "Leavebalanceid is required")
public int leaveBalanceId;
@NotEmpty(message = "Leavebalanceremainingdays is required")
public int leaveBalanceRemainingDays;
@NotEmpty(message = "Leavebalancestatus is required")
public String leaveBalanceStatus;
@NotEmpty(message = "Leavebalancetotaldays is required")
public int leaveBalanceTotalDays;
@NotEmpty(message = "Leavebalancetypeid is required")
public int leaveBalanceTypeId;
@NotEmpty(message = "Leavebalanceupdatedat is required")
public String leaveBalanceUpdatedAt;
@NotEmpty(message = "Leavebalanceuseddays is required")
public int leaveBalanceUsedDays;
}
