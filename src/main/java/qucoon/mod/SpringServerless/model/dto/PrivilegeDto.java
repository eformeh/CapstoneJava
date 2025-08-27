package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Privilege;


@Data
public class PrivilegeDto  {

private String privilegeCode;
private String privilegeCreatedAt;
private String privilegeDescription;
private Integer privilegeId;
private String privilegeModuleName;
private String privilegeName;
private String privilegeStatus;
private String privilegeUpdatedAt;

public static PrivilegeDto from(Privilege p) {
    PrivilegeDto dto = new PrivilegeDto();

    dto.setPrivilegeCode(p.getPrivilegeCode());
    dto.setPrivilegeCreatedAt(p.getPrivilegeCreatedAt());
    dto.setPrivilegeDescription(p.getPrivilegeDescription());
    dto.setPrivilegeId(p.getPrivilegeId());
    dto.setPrivilegeModuleName(p.getPrivilegeModuleName());
    dto.setPrivilegeName(p.getPrivilegeName());
    dto.setPrivilegeStatus(p.getPrivilegeStatus());
    dto.setPrivilegeUpdatedAt(p.getPrivilegeUpdatedAt());
    return dto;
   }
}
