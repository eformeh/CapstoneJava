package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class RoleUpdateRequest {
public String roleCreatedAt;
public String roleDescription;
public int roleId;
public String roleIsPublic;
public String roleName;
public String rolePrivilegeCreatedAt;
public int rolePrivilegeId;
public String rolePrivilegePrivilegeCode;
public int rolePrivilegeRoleId;
public String rolePrivilegeStatus;
public String rolePrivilegeUpdatedAt;
public String roleStatus;
public String roleUpdatedAt;
}
