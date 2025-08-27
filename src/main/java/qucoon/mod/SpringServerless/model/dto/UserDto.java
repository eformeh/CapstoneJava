package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.User;


@Data
public class UserDto  {

private String userCreatedAt;
private String userEmail;
private Integer userEmployeeId;
private String userFirstName;
private Integer userId;
private String userLastLoginDate;
private String userLastLoginIpAddress;
private String userLastName;
private Integer userLoginCount;
private String userPassword;
private Integer userRoleId;
private String userStatus;
private String userUpdatedAt;

public static UserDto from(User p) {
    UserDto dto = new UserDto();

    dto.setUserCreatedAt(p.getUserCreatedAt());
    dto.setUserEmail(p.getUserEmail());
    dto.setUserEmployeeId(p.getUserEmployeeId());
    dto.setUserFirstName(p.getUserFirstName());
    dto.setUserId(p.getUserId());
    dto.setUserLastLoginDate(p.getUserLastLoginDate());
    dto.setUserLastLoginIpAddress(p.getUserLastLoginIpAddress());
    dto.setUserLastName(p.getUserLastName());
    dto.setUserLoginCount(p.getUserLoginCount());
    dto.setUserPassword(p.getUserPassword());
    dto.setUserRoleId(p.getUserRoleId());
    dto.setUserStatus(p.getUserStatus());
    dto.setUserUpdatedAt(p.getUserUpdatedAt());
    return dto;
   }
}
