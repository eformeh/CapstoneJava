
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.AppraisalResponsePage;
import qucoon.mod.SpringServerless.model.request.AppraisalResponseFilterRequest;

import java.util.List;

@Repository
    public interface AppraisalResponseRepository {


    // Additional query methods can be defined here.
    int create(AppraisalResponse appraisalresponse);
    void bulkCreate(List<AppraisalResponse>  appraisalresponse);
    int update(AppraisalResponse  appraisalresponse);
    int delete(int appraisalResponseId);
    AppraisalResponsePage findAppraisalResponse(AppraisalResponseFilterRequest filter);
    boolean truncate();
    List<AppraisalResponse> read();
    List<AppraisalResponse> readByAppraisalResponseAppraisalId(int appraisalResponseAppraisalId);
    List<AppraisalResponse> readByAppraisalResponseCreatedAt(String appraisalResponseCreatedAt);
    AppraisalResponse readByAppraisalResponseId(int appraisalResponseId);
    List<AppraisalResponse> readByAppraisalResponseQuestionId(int appraisalResponseQuestionId);
    List<AppraisalResponse> readByAppraisalResponseScore(Double appraisalResponseScore);
    List<AppraisalResponse> readByAppraisalResponseStatus(String appraisalResponseStatus);
    List<AppraisalResponse> readByAppraisalResponseUpdatedAt(String appraisalResponseUpdatedAt);
    List<AppraisalResponse> readByAppraisalResponseValue(String appraisalResponseValue);
}
