
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.AppraisalFormPage;
import qucoon.mod.SpringServerless.model.request.AppraisalFormFilterRequest;

import java.util.List;

@Repository
    public interface AppraisalFormRepository {


    // Additional query methods can be defined here.
    int create(AppraisalForm appraisalform);
    void bulkCreate(List<AppraisalForm>  appraisalform);
    int update(AppraisalForm  appraisalform);
    int delete(int appraisalFormId);
    AppraisalFormPage findAppraisalForm(AppraisalFormFilterRequest filter);
    boolean truncate();
    List<AppraisalForm> read();
    List<AppraisalForm> readByAppraisalFormCreatedAt(String appraisalFormCreatedAt);
    List<AppraisalForm> readByAppraisalFormCreatedBy(int appraisalFormCreatedBy);
    List<AppraisalForm> readByAppraisalFormDescription(String appraisalFormDescription);
    AppraisalForm readByAppraisalFormId(int appraisalFormId);
    List<AppraisalForm> readByAppraisalFormName(String appraisalFormName);
    List<AppraisalForm> readByAppraisalFormStatus(String appraisalFormStatus);
    List<AppraisalForm> readByAppraisalFormUpdatedAt(String appraisalFormUpdatedAt);
}
