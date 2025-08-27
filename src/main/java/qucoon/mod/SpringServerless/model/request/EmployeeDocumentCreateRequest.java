package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class EmployeeDocumentCreateRequest {
public String employeeDocumentAccessLevel;
@NotNull(message = "employeeDocumentEmployeeId is required")
public int employeeDocumentEmployeeId;
public String employeeDocumentExpiresAt;
public String employeeDocumentFileUrl;
public String employeeDocumentType;
@NotNull(message = "employeeDocumentUploadedBy is required")
public int employeeDocumentUploadedBy;
public String employeeDocumentVersion;
}
