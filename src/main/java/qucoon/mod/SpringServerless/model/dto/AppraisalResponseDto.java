package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.AppraisalResponse;


@Data
public class AppraisalResponseDto  {

private Integer appraisalResponseAppraisalId;
private String appraisalResponseCreatedAt;
private Integer appraisalResponseId;
private Integer appraisalResponseQuestionId;
private Double appraisalResponseScore;
private String appraisalResponseStatus;
private String appraisalResponseUpdatedAt;
private String appraisalResponseValue;

public static AppraisalResponseDto from(AppraisalResponse p) {
    AppraisalResponseDto dto = new AppraisalResponseDto();

    dto.setAppraisalResponseAppraisalId(p.getAppraisalResponseAppraisalId());
    dto.setAppraisalResponseCreatedAt(p.getAppraisalResponseCreatedAt());
    dto.setAppraisalResponseId(p.getAppraisalResponseId());
    dto.setAppraisalResponseQuestionId(p.getAppraisalResponseQuestionId());
    dto.setAppraisalResponseScore(p.getAppraisalResponseScore());
    dto.setAppraisalResponseStatus(p.getAppraisalResponseStatus());
    dto.setAppraisalResponseUpdatedAt(p.getAppraisalResponseUpdatedAt());
    dto.setAppraisalResponseValue(p.getAppraisalResponseValue());
    return dto;
   }
}
