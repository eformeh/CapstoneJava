package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class LeaveRequestReadRequest {
@NotEmpty(message = "Leaverequestcreatedat is required")
public String leaveRequestCreatedAt;
@NotEmpty(message = "Leaverequestdecisiondate is required")
public String leaveRequestDecisionDate;
@NotEmpty(message = "Leaverequestemployeeid is required")
public int leaveRequestEmployeeId;
@NotEmpty(message = "Leaverequestenddate is required")
public String leaveRequestEndDate;
@NotEmpty(message = "Leaverequestid is required")
public int leaveRequestId;
@NotEmpty(message = "Leaverequestreason is required")
public String leaveRequestReason;
@NotEmpty(message = "Leaverequestreviewerid is required")
public int leaveRequestReviewerId;
@NotEmpty(message = "Leaverequeststartdate is required")
public String leaveRequestStartDate;
@NotEmpty(message = "Leaverequeststatus is required")
public String leaveRequestStatus;
@NotEmpty(message = "Leaverequestsubmittedat is required")
public String leaveRequestSubmittedAt;
@NotEmpty(message = "Leaverequesttypeid is required")
public int leaveRequestTypeId;
@NotEmpty(message = "Leaverequestupdatedat is required")
public String leaveRequestUpdatedAt;
}
