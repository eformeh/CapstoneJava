package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Appraisal;


@Data
public class AppraisalDto  {

private String appraisalCreatedAt;
private String appraisalDate;
private Integer appraisalEmployeeIdRoleId;
private Integer appraisalFormId;
private String appraisalGeneralFeedback;
private Integer appraisalId;
private Double appraisalOverallScore;
private Integer appraisalReviewerId;
private String appraisalStatus;
private String appraisalUpdatedAt;

public static AppraisalDto from(Appraisal p) {
    AppraisalDto dto = new AppraisalDto();

    dto.setAppraisalCreatedAt(p.getAppraisalCreatedAt());
    dto.setAppraisalDate(p.getAppraisalDate());
    dto.setAppraisalEmployeeIdRoleId(p.getAppraisalEmployeeIdRoleId());
    dto.setAppraisalFormId(p.getAppraisalFormId());
    dto.setAppraisalGeneralFeedback(p.getAppraisalGeneralFeedback());
    dto.setAppraisalId(p.getAppraisalId());
    dto.setAppraisalOverallScore(p.getAppraisalOverallScore());
    dto.setAppraisalReviewerId(p.getAppraisalReviewerId());
    dto.setAppraisalStatus(p.getAppraisalStatus());
    dto.setAppraisalUpdatedAt(p.getAppraisalUpdatedAt());
    return dto;
   }
}
