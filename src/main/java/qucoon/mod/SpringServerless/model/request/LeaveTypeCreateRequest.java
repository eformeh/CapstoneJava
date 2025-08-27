package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class LeaveTypeCreateRequest {
public Double leaveTypeAccrualRatePerMonth;
public String leaveTypeDescription;
public String leaveTypeName;
public String leaveTypeResetPolicy;
}
