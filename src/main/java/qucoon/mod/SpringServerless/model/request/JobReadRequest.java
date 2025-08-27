package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class JobReadRequest {
@NotEmpty(message = "Jobcreatedat is required")
public String jobCreatedAt;
@NotEmpty(message = "Jobdepartmentid is required")
public int jobDepartmentId;
@NotEmpty(message = "Jobid is required")
public int jobId;
@NotEmpty(message = "Jobroleid is required")
public int jobRoleId;
@NotEmpty(message = "Jobstatus is required")
public String jobStatus;
@NotEmpty(message = "Jobupdatedat is required")
public String jobUpdatedAt;
}
