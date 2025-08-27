package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class OvertimeCreateRequest {
public String overtimeDate;
@NotNull(message = "overtimeEmployeeId is required")
public int overtimeEmployeeId;
public Double overtimeHours;
}
