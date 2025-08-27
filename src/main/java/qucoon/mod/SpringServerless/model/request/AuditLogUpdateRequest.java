package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AuditLogUpdateRequest {
public String auditLogAction;
public String auditLogCreatedAt;
public int auditLogId;
public String auditLogModule;
public String auditLogRequest;
public String auditLogResponse;
public String auditLogResponseCode;
public String auditLogResponseMessage;
public String auditLogStatus;
public String auditLogUpdatedAt;
public int auditLogUserId;
}
