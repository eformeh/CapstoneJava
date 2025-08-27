package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.RolePrivilege;


@Data
public class RolePrivilegeDto  {

private String rolePrivilegeCreatedAt;
private Integer rolePrivilegeId;
private String rolePrivilegePrivilegeCode;
private Integer rolePrivilegeRoleId;
private String rolePrivilegeStatus;
private String rolePrivilegeUpdatedAt;

public static RolePrivilegeDto from(RolePrivilege p) {
    RolePrivilegeDto dto = new RolePrivilegeDto();

    dto.setRolePrivilegeCreatedAt(p.getRolePrivilegeCreatedAt());
    dto.setRolePrivilegeId(p.getRolePrivilegeId());
    dto.setRolePrivilegePrivilegeCode(p.getRolePrivilegePrivilegeCode());
    dto.setRolePrivilegeRoleId(p.getRolePrivilegeRoleId());
    dto.setRolePrivilegeStatus(p.getRolePrivilegeStatus());
    dto.setRolePrivilegeUpdatedAt(p.getRolePrivilegeUpdatedAt());
    return dto;
   }
}
