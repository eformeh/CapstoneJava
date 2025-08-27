package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class LoginHistoryFilterRequest {

private String loginHistoryCreatedAt;
private String loginHistoryDeviceId;
private Integer loginHistoryId;
private String loginHistoryIpAddress;
private String loginHistoryLatitude;
private String loginHistoryLongitude;
private String loginHistoryStatus;
private String loginHistoryUpdatedAt;
private String loginHistoryUsername;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
