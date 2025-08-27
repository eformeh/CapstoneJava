package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class LeaveRequestFilterRequest {

private String leaveRequestCreatedAt;
private String leaveRequestDecisionDate;
private Integer leaveRequestEmployeeId;
private String leaveRequestEndDate;
private Integer leaveRequestId;
private String leaveRequestReason;
private Integer leaveRequestReviewerId;
private String leaveRequestStartDate;
private String leaveRequestStatus;
private String leaveRequestSubmittedAt;
private Integer leaveRequestTypeId;
private String leaveRequestUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
