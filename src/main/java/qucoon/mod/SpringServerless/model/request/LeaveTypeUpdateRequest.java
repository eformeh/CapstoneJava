package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class LeaveTypeUpdateRequest {
public Double leaveTypeAccrualRatePerMonth;
public String leaveTypeCreatedAt;
public String leaveTypeDescription;
public int leaveTypeId;
public String leaveTypeName;
public String leaveTypeResetPolicy;
public String leaveTypeStatus;
public String leaveTypeUpdatedAt;
}
