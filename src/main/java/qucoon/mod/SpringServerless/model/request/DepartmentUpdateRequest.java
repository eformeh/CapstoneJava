package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class DepartmentUpdateRequest {
public String departmentCreatedAt;
public String departmentDescription;
public int departmentId;
public String departmentName;
public String departmentStatus;
public String departmentUpdatedAt;
}
