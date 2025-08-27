package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserFilterRequest {

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
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
