package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class JobUpdateRequest {
public String jobCreatedAt;
public int jobDepartmentId;
public int jobId;
public int jobRoleId;
public String jobStatus;
public String jobUpdatedAt;
}
