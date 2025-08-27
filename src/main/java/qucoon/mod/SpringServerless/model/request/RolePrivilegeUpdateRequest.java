package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class RolePrivilegeUpdateRequest {
public String rolePrivilegeCreatedAt;
public int rolePrivilegeId;
public String rolePrivilegePrivilegeCode;
public int rolePrivilegeRoleId;
public String rolePrivilegeStatus;
public String rolePrivilegeUpdatedAt;
}
