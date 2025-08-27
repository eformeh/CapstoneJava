package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.AuditLog;


@Data
public class AuditLogDto  {

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

public static AuditLogDto from(AuditLog p) {
    AuditLogDto dto = new AuditLogDto();

    dto.setAuditLogAction(p.getAuditLogAction());
    dto.setAuditLogCreatedAt(p.getAuditLogCreatedAt());
    dto.setAuditLogId(p.getAuditLogId());
    dto.setAuditLogModule(p.getAuditLogModule());
    dto.setAuditLogRequest(p.getAuditLogRequest());
    dto.setAuditLogResponse(p.getAuditLogResponse());
    dto.setAuditLogResponseCode(p.getAuditLogResponseCode());
    dto.setAuditLogResponseMessage(p.getAuditLogResponseMessage());
    dto.setAuditLogStatus(p.getAuditLogStatus());
    dto.setAuditLogUpdatedAt(p.getAuditLogUpdatedAt());
    dto.setAuditLogUserId(p.getAuditLogUserId());
    return dto;
   }
}
