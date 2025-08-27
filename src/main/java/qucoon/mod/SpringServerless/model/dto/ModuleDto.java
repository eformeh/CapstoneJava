package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Module;


@Data
public class ModuleDto  {

private String moduleCreatedAt;
private String moduleDescription;
private Integer moduleId;
private String moduleName;
private String moduleStatus;
private String moduleUpdatedAt;

public static ModuleDto from(Module p) {
    ModuleDto dto = new ModuleDto();

    dto.setModuleCreatedAt(p.getModuleCreatedAt());
    dto.setModuleDescription(p.getModuleDescription());
    dto.setModuleId(p.getModuleId());
    dto.setModuleName(p.getModuleName());
    dto.setModuleStatus(p.getModuleStatus());
    dto.setModuleUpdatedAt(p.getModuleUpdatedAt());
    return dto;
   }
}
