package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OvertimeUpdateRequest {
public String overtimeCreatedAt;
public String overtimeDate;
public int overtimeEmployeeId;
public Double overtimeHours;
public int overtimeId;
public String overtimeStatus;
public String overtimeUpdatedAt;
}
