package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class LeaveRequestCreateRequest {
public String leaveRequestDecisionDate;
@NotNull(message = "leaveRequestEmployeeId is required")
public int leaveRequestEmployeeId;
public String leaveRequestEndDate;
public String leaveRequestReason;
@NotNull(message = "leaveRequestReviewerId is required")
public int leaveRequestReviewerId;
public String leaveRequestStartDate;
public String leaveRequestSubmittedAt;
@NotNull(message = "leaveRequestTypeId is required")
public int leaveRequestTypeId;
}
