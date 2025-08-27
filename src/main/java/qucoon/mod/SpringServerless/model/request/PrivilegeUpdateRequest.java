package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PrivilegeUpdateRequest {
public String privilegeCode;
public String privilegeCreatedAt;
public String privilegeDescription;
public int privilegeId;
public String privilegeModuleName;
public String privilegeName;
public String privilegeStatus;
public String privilegeUpdatedAt;
}
