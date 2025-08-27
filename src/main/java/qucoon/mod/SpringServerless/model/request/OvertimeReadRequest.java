package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OvertimeReadRequest {
@NotEmpty(message = "Overtimecreatedat is required")
public String overtimeCreatedAt;
@NotEmpty(message = "Overtimedate is required")
public String overtimeDate;
@NotEmpty(message = "Overtimeemployeeid is required")
public int overtimeEmployeeId;
@NotEmpty(message = "Overtimehours is required")
public Double overtimeHours;
@NotEmpty(message = "Overtimeid is required")
public int overtimeId;
@NotEmpty(message = "Overtimestatus is required")
public String overtimeStatus;
@NotEmpty(message = "Overtimeupdatedat is required")
public String overtimeUpdatedAt;
}
