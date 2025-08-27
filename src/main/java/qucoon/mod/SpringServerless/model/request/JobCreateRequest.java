package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class JobCreateRequest {
@NotNull(message = "jobDepartmentId is required")
public int jobDepartmentId;
@NotNull(message = "jobRoleId is required")
public int jobRoleId;
}
