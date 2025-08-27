package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class UserReadRequest {
@NotEmpty(message = "Usercreatedat is required")
public String userCreatedAt;
@NotEmpty(message = "Useremail is required")
public String userEmail;
@NotEmpty(message = "Useremployeeid is required")
public int userEmployeeId;
@NotEmpty(message = "Userfirstname is required")
public String userFirstName;
@NotEmpty(message = "Userid is required")
public int userId;
@NotEmpty(message = "Userlastlogindate is required")
public String userLastLoginDate;
@NotEmpty(message = "Userlastloginipaddress is required")
public String userLastLoginIpAddress;
@NotEmpty(message = "Userlastname is required")
public String userLastName;
@NotEmpty(message = "Userlogincount is required")
public int userLoginCount;
@NotEmpty(message = "Userpassword is required")
public String userPassword;
@NotEmpty(message = "Userroleid is required")
public int userRoleId;
@NotEmpty(message = "Userstatus is required")
public String userStatus;
@NotEmpty(message = "Userupdatedat is required")
public String userUpdatedAt;
}
