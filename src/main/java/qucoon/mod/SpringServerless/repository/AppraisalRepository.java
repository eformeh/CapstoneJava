
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.AppraisalPage;
import qucoon.mod.SpringServerless.model.request.AppraisalFilterRequest;

import java.util.List;

@Repository
    public interface AppraisalRepository {


    // Additional query methods can be defined here.
    int create(Appraisal appraisal);
    void bulkCreate(List<Appraisal>  appraisal);
    int update(Appraisal  appraisal);
    int delete(int appraisalId);
    AppraisalPage findAppraisal(AppraisalFilterRequest filter);
    boolean truncate();
    List<Appraisal> read();
    List<Appraisal> readByAppraisalCreatedAt(String appraisalCreatedAt);
    List<Appraisal> readByAppraisalDate(String appraisalDate);
    List<Appraisal> readByAppraisalEmployeeIdRoleId(int appraisalEmployeeIdRoleId);
    List<Appraisal> readByAppraisalFormId(int appraisalFormId);
    List<Appraisal> readByAppraisalGeneralFeedback(String appraisalGeneralFeedback);
    Appraisal readByAppraisalId(int appraisalId);
    List<Appraisal> readByAppraisalOverallScore(Double appraisalOverallScore);
    List<Appraisal> readByAppraisalReviewerId(int appraisalReviewerId);
    List<Appraisal> readByAppraisalStatus(String appraisalStatus);
    List<Appraisal> readByAppraisalUpdatedAt(String appraisalUpdatedAt);
}
