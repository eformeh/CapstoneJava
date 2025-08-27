package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class LeaveBalanceCreateRequest {
@NotNull(message = "leaveBalanceEmployeeId is required")
public int leaveBalanceEmployeeId;
@NotNull(message = "leaveBalanceRemainingDays is required")
public int leaveBalanceRemainingDays;
@NotNull(message = "leaveBalanceTotalDays is required")
public int leaveBalanceTotalDays;
@NotNull(message = "leaveBalanceTypeId is required")
public int leaveBalanceTypeId;
@NotNull(message = "leaveBalanceUsedDays is required")
public int leaveBalanceUsedDays;
}
