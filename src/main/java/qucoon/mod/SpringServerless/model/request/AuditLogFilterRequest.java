package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AuditLogFilterRequest {

private String auditLogAction;
private String auditLogCreatedAt;
private Integer auditLogId;
private String auditLogModule;
private String auditLogRequest;
private String auditLogResponse;
private String auditLogResponseCode;
private String auditLogResponseMessage;
private String auditLogStatus;
private String auditLogUpdatedAt;
private Integer auditLogUserId;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
