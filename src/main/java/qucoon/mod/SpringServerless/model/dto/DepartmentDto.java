package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Department;


@Data
public class DepartmentDto  {

private String departmentCreatedAt;
private String departmentDescription;
private Integer departmentId;
private String departmentName;
private String departmentStatus;
private String departmentUpdatedAt;

public static DepartmentDto from(Department p) {
    DepartmentDto dto = new DepartmentDto();

    dto.setDepartmentCreatedAt(p.getDepartmentCreatedAt());
    dto.setDepartmentDescription(p.getDepartmentDescription());
    dto.setDepartmentId(p.getDepartmentId());
    dto.setDepartmentName(p.getDepartmentName());
    dto.setDepartmentStatus(p.getDepartmentStatus());
    dto.setDepartmentUpdatedAt(p.getDepartmentUpdatedAt());
    return dto;
   }
}
