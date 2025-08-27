package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class DepartmentFilterRequest {

private String departmentCreatedAt;
private String departmentDescription;
private Integer departmentId;
private String departmentName;
private String departmentStatus;
private String departmentUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
