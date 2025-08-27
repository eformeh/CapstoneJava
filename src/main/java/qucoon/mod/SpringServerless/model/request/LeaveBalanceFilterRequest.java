package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class LeaveBalanceFilterRequest {

private String leaveBalanceCreatedAt;
private Integer leaveBalanceEmployeeId;
private Integer leaveBalanceId;
private Integer leaveBalanceRemainingDays;
private String leaveBalanceStatus;
private Integer leaveBalanceTotalDays;
private Integer leaveBalanceTypeId;
private String leaveBalanceUpdatedAt;
private Integer leaveBalanceUsedDays;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
