package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AppraisalFormFilterRequest {

private String appraisalFormCreatedAt;
private Integer appraisalFormCreatedBy;
private String appraisalFormDescription;
private Integer appraisalFormId;
private String appraisalFormName;
private String appraisalFormStatus;
private String appraisalFormUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
