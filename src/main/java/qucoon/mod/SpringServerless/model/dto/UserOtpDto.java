package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.UserOtp;


@Data
public class UserOtpDto  {

private String userOtpCreatedAt;
private Integer userOtpId;
private String userOtpOtp;
private String userOtpStatus;
private String userOtpUpdatedAt;
private String userOtpUsername;

public static UserOtpDto from(UserOtp p) {
    UserOtpDto dto = new UserOtpDto();

    dto.setUserOtpCreatedAt(p.getUserOtpCreatedAt());
    dto.setUserOtpId(p.getUserOtpId());
    dto.setUserOtpOtp(p.getUserOtpOtp());
    dto.setUserOtpStatus(p.getUserOtpStatus());
    dto.setUserOtpUpdatedAt(p.getUserOtpUpdatedAt());
    dto.setUserOtpUsername(p.getUserOtpUsername());
    return dto;
   }
}
