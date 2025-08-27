package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class OvertimeFilterRequest {

private String overtimeCreatedAt;
private String overtimeDate;
private Integer overtimeEmployeeId;
private Double overtimeHours;
private Integer overtimeId;
private String overtimeStatus;
private String overtimeUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
