package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class EmployeeDocumentUpdateRequest {
public String employeeDocumentAccessLevel;
public String employeeDocumentCreatedAt;
public int employeeDocumentEmployeeId;
public String employeeDocumentExpiresAt;
public String employeeDocumentFileUrl;
public int employeeDocumentId;
public String employeeDocumentStatus;
public String employeeDocumentType;
public String employeeDocumentUpdatedAt;
public int employeeDocumentUploadedBy;
public String employeeDocumentVersion;
}
