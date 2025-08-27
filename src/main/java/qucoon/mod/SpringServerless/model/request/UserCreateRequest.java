package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class UserCreateRequest {
public String userEmail;
@NotNull(message = "userEmployeeId is required")
public int userEmployeeId;
public String userFirstName;
public String userLastLoginDate;
public String userLastLoginIpAddress;
public String userLastName;
@NotNull(message = "userLoginCount is required")
public int userLoginCount;
public String userPassword;
@NotNull(message = "userRoleId is required")
public int userRoleId;
}
