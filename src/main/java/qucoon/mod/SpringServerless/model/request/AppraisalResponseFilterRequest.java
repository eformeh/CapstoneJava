package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AppraisalResponseFilterRequest {

private Integer appraisalResponseAppraisalId;
private String appraisalResponseCreatedAt;
private Integer appraisalResponseId;
private Integer appraisalResponseQuestionId;
private Double appraisalResponseScore;
private String appraisalResponseStatus;
private String appraisalResponseUpdatedAt;
private String appraisalResponseValue;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
