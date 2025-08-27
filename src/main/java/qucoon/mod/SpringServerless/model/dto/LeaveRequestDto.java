package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.LeaveRequest;


@Data
public class LeaveRequestDto  {

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

public static LeaveRequestDto from(LeaveRequest p) {
    LeaveRequestDto dto = new LeaveRequestDto();

    dto.setLeaveRequestCreatedAt(p.getLeaveRequestCreatedAt());
    dto.setLeaveRequestDecisionDate(p.getLeaveRequestDecisionDate());
    dto.setLeaveRequestEmployeeId(p.getLeaveRequestEmployeeId());
    dto.setLeaveRequestEndDate(p.getLeaveRequestEndDate());
    dto.setLeaveRequestId(p.getLeaveRequestId());
    dto.setLeaveRequestReason(p.getLeaveRequestReason());
    dto.setLeaveRequestReviewerId(p.getLeaveRequestReviewerId());
    dto.setLeaveRequestStartDate(p.getLeaveRequestStartDate());
    dto.setLeaveRequestStatus(p.getLeaveRequestStatus());
    dto.setLeaveRequestSubmittedAt(p.getLeaveRequestSubmittedAt());
    dto.setLeaveRequestTypeId(p.getLeaveRequestTypeId());
    dto.setLeaveRequestUpdatedAt(p.getLeaveRequestUpdatedAt());
    return dto;
   }
}
