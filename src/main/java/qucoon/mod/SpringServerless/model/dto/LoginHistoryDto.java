package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.LoginHistory;


@Data
public class LoginHistoryDto  {

private String loginHistoryCreatedAt;
private String loginHistoryDeviceId;
private Integer loginHistoryId;
private String loginHistoryIpAddress;
private String loginHistoryLatitude;
private String loginHistoryLongitude;
private String loginHistoryStatus;
private String loginHistoryUpdatedAt;
private String loginHistoryUsername;

public static LoginHistoryDto from(LoginHistory p) {
    LoginHistoryDto dto = new LoginHistoryDto();

    dto.setLoginHistoryCreatedAt(p.getLoginHistoryCreatedAt());
    dto.setLoginHistoryDeviceId(p.getLoginHistoryDeviceId());
    dto.setLoginHistoryId(p.getLoginHistoryId());
    dto.setLoginHistoryIpAddress(p.getLoginHistoryIpAddress());
    dto.setLoginHistoryLatitude(p.getLoginHistoryLatitude());
    dto.setLoginHistoryLongitude(p.getLoginHistoryLongitude());
    dto.setLoginHistoryStatus(p.getLoginHistoryStatus());
    dto.setLoginHistoryUpdatedAt(p.getLoginHistoryUpdatedAt());
    dto.setLoginHistoryUsername(p.getLoginHistoryUsername());
    return dto;
   }
}
