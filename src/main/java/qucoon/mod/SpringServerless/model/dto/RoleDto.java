package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Role;


@Data
public class RoleDto  {

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

public static RoleDto from(Role p) {
    RoleDto dto = new RoleDto();

    dto.setRoleCreatedAt(p.getRoleCreatedAt());
    dto.setRoleDescription(p.getRoleDescription());
    dto.setRoleId(p.getRoleId());
    dto.setRoleIsPublic(p.getRoleIsPublic());
    dto.setRoleName(p.getRoleName());
    dto.setRolePrivilegeCreatedAt(p.getRolePrivilegeCreatedAt());
    dto.setRolePrivilegeId(p.getRolePrivilegeId());
    dto.setRolePrivilegePrivilegeCode(p.getRolePrivilegePrivilegeCode());
    dto.setRolePrivilegeRoleId(p.getRolePrivilegeRoleId());
    dto.setRolePrivilegeStatus(p.getRolePrivilegeStatus());
    dto.setRolePrivilegeUpdatedAt(p.getRolePrivilegeUpdatedAt());
    dto.setRoleStatus(p.getRoleStatus());
    dto.setRoleUpdatedAt(p.getRoleUpdatedAt());
    return dto;
   }
}
