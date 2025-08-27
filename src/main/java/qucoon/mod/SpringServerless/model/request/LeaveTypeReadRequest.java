package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class LeaveTypeReadRequest {
@NotEmpty(message = "Leavetypeaccrualratepermonth is required")
public Double leaveTypeAccrualRatePerMonth;
@NotEmpty(message = "Leavetypecreatedat is required")
public String leaveTypeCreatedAt;
@NotEmpty(message = "Leavetypedescription is required")
public String leaveTypeDescription;
@NotEmpty(message = "Leavetypeid is required")
public int leaveTypeId;
@NotEmpty(message = "Leavetypename is required")
public String leaveTypeName;
@NotEmpty(message = "Leavetyperesetpolicy is required")
public String leaveTypeResetPolicy;
@NotEmpty(message = "Leavetypestatus is required")
public String leaveTypeStatus;
@NotEmpty(message = "Leavetypeupdatedat is required")
public String leaveTypeUpdatedAt;
}
