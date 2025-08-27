package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class EmployeeDocumentFilterRequest {

private String employeeDocumentAccessLevel;
private String employeeDocumentCreatedAt;
private Integer employeeDocumentEmployeeId;
private String employeeDocumentExpiresAt;
private String employeeDocumentFileUrl;
private Integer employeeDocumentId;
private String employeeDocumentStatus;
private String employeeDocumentType;
private String employeeDocumentUpdatedAt;
private Integer employeeDocumentUploadedBy;
private String employeeDocumentVersion;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
