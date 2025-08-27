package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class LeaveRequestUpdateRequest {
public String leaveRequestCreatedAt;
public String leaveRequestDecisionDate;
public int leaveRequestEmployeeId;
public String leaveRequestEndDate;
public int leaveRequestId;
public String leaveRequestReason;
public int leaveRequestReviewerId;
public String leaveRequestStartDate;
public String leaveRequestStatus;
public String leaveRequestSubmittedAt;
public int leaveRequestTypeId;
public String leaveRequestUpdatedAt;
}
