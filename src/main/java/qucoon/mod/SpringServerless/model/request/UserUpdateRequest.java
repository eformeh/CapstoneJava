package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class UserUpdateRequest {
public String userCreatedAt;
public String userEmail;
public int userEmployeeId;
public String userFirstName;
public int userId;
public String userLastLoginDate;
public String userLastLoginIpAddress;
public String userLastName;
public int userLoginCount;
public String userPassword;
public int userRoleId;
public String userStatus;
public String userUpdatedAt;
}
