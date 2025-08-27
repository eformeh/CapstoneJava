
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.AppraisalQuestionPage;
import qucoon.mod.SpringServerless.model.request.AppraisalQuestionFilterRequest;

import java.util.List;

@Repository
    public interface AppraisalQuestionRepository {


    // Additional query methods can be defined here.
    int create(AppraisalQuestion appraisalquestion);
    void bulkCreate(List<AppraisalQuestion>  appraisalquestion);
    int update(AppraisalQuestion  appraisalquestion);
    int delete(int appraisalQuestionId);
    AppraisalQuestionPage findAppraisalQuestion(AppraisalQuestionFilterRequest filter);
    boolean truncate();
    List<AppraisalQuestion> read();
    List<AppraisalQuestion> readByAppraisalFormId(int appraisalFormId);
    List<AppraisalQuestion> readByAppraisalQuestionCreatedAt(String appraisalQuestionCreatedAt);
    AppraisalQuestion readByAppraisalQuestionId(int appraisalQuestionId);
    List<AppraisalQuestion> readByAppraisalQuestionStatus(String appraisalQuestionStatus);
    List<AppraisalQuestion> readByAppraisalQuestionText(String appraisalQuestionText);
    List<AppraisalQuestion> readByAppraisalQuestionType(String appraisalQuestionType);
    List<AppraisalQuestion> readByAppraisalQuestionUpdatedAt(String appraisalQuestionUpdatedAt);
    List<AppraisalQuestion> readByAppraisalQuestionWeight(Double appraisalQuestionWeight);
}
