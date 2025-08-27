package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.AppraisalQuestion;


@Data
public class AppraisalQuestionDto  {

private Integer appraisalFormId;
private String appraisalQuestionCreatedAt;
private Integer appraisalQuestionId;
private String appraisalQuestionStatus;
private String appraisalQuestionText;
private String appraisalQuestionType;
private String appraisalQuestionUpdatedAt;
private Double appraisalQuestionWeight;

public static AppraisalQuestionDto from(AppraisalQuestion p) {
    AppraisalQuestionDto dto = new AppraisalQuestionDto();

    dto.setAppraisalFormId(p.getAppraisalFormId());
    dto.setAppraisalQuestionCreatedAt(p.getAppraisalQuestionCreatedAt());
    dto.setAppraisalQuestionId(p.getAppraisalQuestionId());
    dto.setAppraisalQuestionStatus(p.getAppraisalQuestionStatus());
    dto.setAppraisalQuestionText(p.getAppraisalQuestionText());
    dto.setAppraisalQuestionType(p.getAppraisalQuestionType());
    dto.setAppraisalQuestionUpdatedAt(p.getAppraisalQuestionUpdatedAt());
    dto.setAppraisalQuestionWeight(p.getAppraisalQuestionWeight());
    return dto;
   }
}
