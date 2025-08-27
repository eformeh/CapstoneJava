package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class UserOtpUpdateRequest {
public String userOtpCreatedAt;
public int userOtpId;
public String userOtpOtp;
public String userOtpStatus;
public String userOtpUpdatedAt;
public String userOtpUsername;
}
