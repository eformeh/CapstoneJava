
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.DeductionPage;
import qucoon.mod.SpringServerless.model.request.DeductionFilterRequest;

import java.util.List;

@Repository
    public interface DeductionRepository {


    // Additional query methods can be defined here.
    int create(Deduction deduction);
    void bulkCreate(List<Deduction>  deduction);
    int update(Deduction  deduction);
    int delete(int deductionId);
    DeductionPage findDeduction(DeductionFilterRequest filter);
    boolean truncate();
    List<Deduction> read();
    List<Deduction> readByDeductionAmount(Double deductionAmount);
    List<Deduction> readByDeductionCreatedAt(String deductionCreatedAt);
    Deduction readByDeductionId(int deductionId);
    List<Deduction> readByDeductionSalaryId(int deductionSalaryId);
    List<Deduction> readByDeductionStatus(String deductionStatus);
    List<Deduction> readByDeductionType(String deductionType);
    List<Deduction> readByDeductionUpdatedAt(String deductionUpdatedAt);
}
