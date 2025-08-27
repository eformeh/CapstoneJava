package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AppraisalQuestionFilterRequest {

private Integer appraisalFormId;
private String appraisalQuestionCreatedAt;
private Integer appraisalQuestionId;
private String appraisalQuestionStatus;
private String appraisalQuestionText;
private String appraisalQuestionType;
private String appraisalQuestionUpdatedAt;
private Double appraisalQuestionWeight;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
