package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Job;


@Data
public class JobDto  {

private String jobCreatedAt;
private Integer jobDepartmentId;
private Integer jobId;
private Integer jobRoleId;
private String jobStatus;
private String jobUpdatedAt;

public static JobDto from(Job p) {
    JobDto dto = new JobDto();

    dto.setJobCreatedAt(p.getJobCreatedAt());
    dto.setJobDepartmentId(p.getJobDepartmentId());
    dto.setJobId(p.getJobId());
    dto.setJobRoleId(p.getJobRoleId());
    dto.setJobStatus(p.getJobStatus());
    dto.setJobUpdatedAt(p.getJobUpdatedAt());
    return dto;
   }
}
