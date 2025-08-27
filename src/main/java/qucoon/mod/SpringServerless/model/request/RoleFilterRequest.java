package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class RoleFilterRequest {

private String roleCreatedAt;
private String roleDescription;
private Integer roleId;
private String roleIsPublic;
private String roleName;
private String rolePrivilegeCreatedAt;
private Integer rolePrivilegeId;
private String rolePrivilegePrivilegeCode;
private Integer rolePrivilegeRoleId;
private String rolePrivilegeStatus;
private String rolePrivilegeUpdatedAt;
private String roleStatus;
private String roleUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
