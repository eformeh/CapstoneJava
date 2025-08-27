package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class RolePrivilegeFilterRequest {

private String rolePrivilegeCreatedAt;
private Integer rolePrivilegeId;
private String rolePrivilegePrivilegeCode;
private Integer rolePrivilegeRoleId;
private String rolePrivilegeStatus;
private String rolePrivilegeUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
