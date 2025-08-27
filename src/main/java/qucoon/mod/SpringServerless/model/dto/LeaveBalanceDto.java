package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.LeaveBalance;


@Data
public class LeaveBalanceDto  {

private String leaveBalanceCreatedAt;
private Integer leaveBalanceEmployeeId;
private Integer leaveBalanceId;
private Integer leaveBalanceRemainingDays;
private String leaveBalanceStatus;
private Integer leaveBalanceTotalDays;
private Integer leaveBalanceTypeId;
private String leaveBalanceUpdatedAt;
private Integer leaveBalanceUsedDays;

public static LeaveBalanceDto from(LeaveBalance p) {
    LeaveBalanceDto dto = new LeaveBalanceDto();

    dto.setLeaveBalanceCreatedAt(p.getLeaveBalanceCreatedAt());
    dto.setLeaveBalanceEmployeeId(p.getLeaveBalanceEmployeeId());
    dto.setLeaveBalanceId(p.getLeaveBalanceId());
    dto.setLeaveBalanceRemainingDays(p.getLeaveBalanceRemainingDays());
    dto.setLeaveBalanceStatus(p.getLeaveBalanceStatus());
    dto.setLeaveBalanceTotalDays(p.getLeaveBalanceTotalDays());
    dto.setLeaveBalanceTypeId(p.getLeaveBalanceTypeId());
    dto.setLeaveBalanceUpdatedAt(p.getLeaveBalanceUpdatedAt());
    dto.setLeaveBalanceUsedDays(p.getLeaveBalanceUsedDays());
    return dto;
   }
}
