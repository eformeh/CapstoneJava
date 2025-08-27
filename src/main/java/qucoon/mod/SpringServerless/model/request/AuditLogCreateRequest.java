package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class AuditLogCreateRequest {
public String auditLogAction;
public String auditLogModule;
@NotEmpty(message = "auditLogRequest is required")
public String auditLogRequest;
public String auditLogResponse;
public String auditLogResponseCode;
public String auditLogResponseMessage;
@NotNull(message = "auditLogUserId is required")
public int auditLogUserId;
}
