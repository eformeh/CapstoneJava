package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.EmployeeDocument;


@Data
public class EmployeeDocumentDto  {

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

public static EmployeeDocumentDto from(EmployeeDocument p) {
    EmployeeDocumentDto dto = new EmployeeDocumentDto();

    dto.setEmployeeDocumentAccessLevel(p.getEmployeeDocumentAccessLevel());
    dto.setEmployeeDocumentCreatedAt(p.getEmployeeDocumentCreatedAt());
    dto.setEmployeeDocumentEmployeeId(p.getEmployeeDocumentEmployeeId());
    dto.setEmployeeDocumentExpiresAt(p.getEmployeeDocumentExpiresAt());
    dto.setEmployeeDocumentFileUrl(p.getEmployeeDocumentFileUrl());
    dto.setEmployeeDocumentId(p.getEmployeeDocumentId());
    dto.setEmployeeDocumentStatus(p.getEmployeeDocumentStatus());
    dto.setEmployeeDocumentType(p.getEmployeeDocumentType());
    dto.setEmployeeDocumentUpdatedAt(p.getEmployeeDocumentUpdatedAt());
    dto.setEmployeeDocumentUploadedBy(p.getEmployeeDocumentUploadedBy());
    dto.setEmployeeDocumentVersion(p.getEmployeeDocumentVersion());
    return dto;
   }
}
