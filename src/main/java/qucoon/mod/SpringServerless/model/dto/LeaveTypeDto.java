package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.LeaveType;


@Data
public class LeaveTypeDto  {

private Double leaveTypeAccrualRatePerMonth;
private String leaveTypeCreatedAt;
private String leaveTypeDescription;
private Integer leaveTypeId;
private String leaveTypeName;
private String leaveTypeResetPolicy;
private String leaveTypeStatus;
private String leaveTypeUpdatedAt;

public static LeaveTypeDto from(LeaveType p) {
    LeaveTypeDto dto = new LeaveTypeDto();

    dto.setLeaveTypeAccrualRatePerMonth(p.getLeaveTypeAccrualRatePerMonth());
    dto.setLeaveTypeCreatedAt(p.getLeaveTypeCreatedAt());
    dto.setLeaveTypeDescription(p.getLeaveTypeDescription());
    dto.setLeaveTypeId(p.getLeaveTypeId());
    dto.setLeaveTypeName(p.getLeaveTypeName());
    dto.setLeaveTypeResetPolicy(p.getLeaveTypeResetPolicy());
    dto.setLeaveTypeStatus(p.getLeaveTypeStatus());
    dto.setLeaveTypeUpdatedAt(p.getLeaveTypeUpdatedAt());
    return dto;
   }
}
