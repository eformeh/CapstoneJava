
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.ExpenseClaimPage;
import qucoon.mod.SpringServerless.model.request.ExpenseClaimFilterRequest;

import java.util.List;

@Repository
    public interface ExpenseClaimRepository {


    // Additional query methods can be defined here.
    int create(ExpenseClaim expenseclaim);
    void bulkCreate(List<ExpenseClaim>  expenseclaim);
    int update(ExpenseClaim  expenseclaim);
    int delete(int expenseClaimId);
    ExpenseClaimPage findExpenseClaim(ExpenseClaimFilterRequest filter);
    boolean truncate();
    List<ExpenseClaim> read();
    List<ExpenseClaim> readByExpenseClaimCreatedAt(String expenseClaimCreatedAt);
    List<ExpenseClaim> readByExpenseClaimDecisionDate(String expenseClaimDecisionDate);
    List<ExpenseClaim> readByExpenseClaimEmployeeId(int expenseClaimEmployeeId);
    ExpenseClaim readByExpenseClaimId(int expenseClaimId);
    List<ExpenseClaim> readByExpenseClaimReimbursementDate(String expenseClaimReimbursementDate);
    List<ExpenseClaim> readByExpenseClaimReviewerId(int expenseClaimReviewerId);
    List<ExpenseClaim> readByExpenseClaimStatus(String expenseClaimStatus);
    List<ExpenseClaim> readByExpenseClaimTotalAmount(Double expenseClaimTotalAmount);
    List<ExpenseClaim> readByExpenseClaimUpdatedAt(String expenseClaimUpdatedAt);
}
