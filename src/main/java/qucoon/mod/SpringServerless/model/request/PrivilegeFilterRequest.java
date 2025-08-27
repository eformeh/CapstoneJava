package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PrivilegeFilterRequest {

private String privilegeCode;
private String privilegeCreatedAt;
private String privilegeDescription;
private Integer privilegeId;
private String privilegeModuleName;
private String privilegeName;
private String privilegeStatus;
private String privilegeUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
