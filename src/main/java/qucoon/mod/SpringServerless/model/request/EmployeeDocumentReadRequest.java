package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class EmployeeDocumentReadRequest {
@NotEmpty(message = "Employeedocumentaccesslevel is required")
public String employeeDocumentAccessLevel;
@NotEmpty(message = "Employeedocumentcreatedat is required")
public String employeeDocumentCreatedAt;
@NotEmpty(message = "Employeedocumentemployeeid is required")
public int employeeDocumentEmployeeId;
@NotEmpty(message = "Employeedocumentexpiresat is required")
public String employeeDocumentExpiresAt;
@NotEmpty(message = "Employeedocumentfileurl is required")
public String employeeDocumentFileUrl;
@NotEmpty(message = "Employeedocumentid is required")
public int employeeDocumentId;
@NotEmpty(message = "Employeedocumentstatus is required")
public String employeeDocumentStatus;
@NotEmpty(message = "Employeedocumenttype is required")
public String employeeDocumentType;
@NotEmpty(message = "Employeedocumentupdatedat is required")
public String employeeDocumentUpdatedAt;
@NotEmpty(message = "Employeedocumentuploadedby is required")
public int employeeDocumentUploadedBy;
@NotEmpty(message = "Employeedocumentversion is required")
public String employeeDocumentVersion;
}
