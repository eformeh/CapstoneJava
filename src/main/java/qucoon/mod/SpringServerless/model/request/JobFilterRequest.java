package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class JobFilterRequest {

private String jobCreatedAt;
private Integer jobDepartmentId;
private Integer jobId;
private Integer jobRoleId;
private String jobStatus;
private String jobUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
