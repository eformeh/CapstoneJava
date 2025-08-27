package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class LeaveTypeFilterRequest {

private Double leaveTypeAccrualRatePerMonth;
private String leaveTypeCreatedAt;
private String leaveTypeDescription;
private Integer leaveTypeId;
private String leaveTypeName;
private String leaveTypeResetPolicy;
private String leaveTypeStatus;
private String leaveTypeUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
