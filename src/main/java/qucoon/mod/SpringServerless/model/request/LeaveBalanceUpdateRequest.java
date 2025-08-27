package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class LeaveBalanceUpdateRequest {
public String leaveBalanceCreatedAt;
public int leaveBalanceEmployeeId;
public int leaveBalanceId;
public int leaveBalanceRemainingDays;
public String leaveBalanceStatus;
public int leaveBalanceTotalDays;
public int leaveBalanceTypeId;
public String leaveBalanceUpdatedAt;
public int leaveBalanceUsedDays;
}
