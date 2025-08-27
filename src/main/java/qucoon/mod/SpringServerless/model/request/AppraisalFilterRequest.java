package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AppraisalFilterRequest {

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
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
