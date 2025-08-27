package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class LoginHistoryUpdateRequest {
public String loginHistoryCreatedAt;
public String loginHistoryDeviceId;
public int loginHistoryId;
public String loginHistoryIpAddress;
public String loginHistoryLatitude;
public String loginHistoryLongitude;
public String loginHistoryStatus;
public String loginHistoryUpdatedAt;
public String loginHistoryUsername;
}
