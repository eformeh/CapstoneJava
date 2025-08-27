package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.AppraisalForm;


@Data
public class AppraisalFormDto  {

private String appraisalFormCreatedAt;
private Integer appraisalFormCreatedBy;
private String appraisalFormDescription;
private Integer appraisalFormId;
private String appraisalFormName;
private String appraisalFormStatus;
private String appraisalFormUpdatedAt;

public static AppraisalFormDto from(AppraisalForm p) {
    AppraisalFormDto dto = new AppraisalFormDto();

    dto.setAppraisalFormCreatedAt(p.getAppraisalFormCreatedAt());
    dto.setAppraisalFormCreatedBy(p.getAppraisalFormCreatedBy());
    dto.setAppraisalFormDescription(p.getAppraisalFormDescription());
    dto.setAppraisalFormId(p.getAppraisalFormId());
    dto.setAppraisalFormName(p.getAppraisalFormName());
    dto.setAppraisalFormStatus(p.getAppraisalFormStatus());
    dto.setAppraisalFormUpdatedAt(p.getAppraisalFormUpdatedAt());
    return dto;
   }
}
