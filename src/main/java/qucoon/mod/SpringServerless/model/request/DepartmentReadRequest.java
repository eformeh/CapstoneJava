package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class DepartmentReadRequest {
@NotEmpty(message = "Departmentcreatedat is required")
public String departmentCreatedAt;
@NotEmpty(message = "Departmentdescription is required")
public String departmentDescription;
@NotEmpty(message = "Departmentid is required")
public int departmentId;
@NotEmpty(message = "Departmentname is required")
public String departmentName;
@NotEmpty(message = "Departmentstatus is required")
public String departmentStatus;
@NotEmpty(message = "Departmentupdatedat is required")
public String departmentUpdatedAt;
}
