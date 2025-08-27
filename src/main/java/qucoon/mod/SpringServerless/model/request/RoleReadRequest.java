package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class RoleReadRequest {
@NotEmpty(message = "Rolecreatedat is required")
public String roleCreatedAt;
@NotEmpty(message = "Roledescription is required")
public String roleDescription;
@NotEmpty(message = "Roleid is required")
public int roleId;
@NotEmpty(message = "Roleispublic is required")
public String roleIsPublic;
@NotEmpty(message = "Rolename is required")
public String roleName;
@NotEmpty(message = "Roleprivilegecreatedat is required")
public String rolePrivilegeCreatedAt;
@NotEmpty(message = "Roleprivilegeid is required")
public int rolePrivilegeId;
@NotEmpty(message = "Roleprivilegeprivilegecode is required")
public String rolePrivilegePrivilegeCode;
@NotEmpty(message = "Roleprivilegeroleid is required")
public int rolePrivilegeRoleId;
@NotEmpty(message = "Roleprivilegestatus is required")
public String rolePrivilegeStatus;
@NotEmpty(message = "Roleprivilegeupdatedat is required")
public String rolePrivilegeUpdatedAt;
@NotEmpty(message = "Rolestatus is required")
public String roleStatus;
@NotEmpty(message = "Roleupdatedat is required")
public String roleUpdatedAt;
}
