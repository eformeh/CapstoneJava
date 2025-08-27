package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ModuleReadRequest {
@NotEmpty(message = "Modulecreatedat is required")
public String moduleCreatedAt;
@NotEmpty(message = "Moduledescription is required")
public String moduleDescription;
@NotEmpty(message = "Moduleid is required")
public int moduleId;
@NotEmpty(message = "Modulename is required")
public String moduleName;
@NotEmpty(message = "Modulestatus is required")
public String moduleStatus;
@NotEmpty(message = "Moduleupdatedat is required")
public String moduleUpdatedAt;
}
