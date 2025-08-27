
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.ExpenseItemPage;
import qucoon.mod.SpringServerless.model.request.ExpenseItemFilterRequest;

import java.util.List;

@Repository
    public interface ExpenseItemRepository {


    // Additional query methods can be defined here.
    int create(ExpenseItem expenseitem);
    void bulkCreate(List<ExpenseItem>  expenseitem);
    int update(ExpenseItem  expenseitem);
    int delete(int expenseItemId);
    ExpenseItemPage findExpenseItem(ExpenseItemFilterRequest filter);
    boolean truncate();
    List<ExpenseItem> read();
    List<ExpenseItem> readByExpenseItemAmount(Double expenseItemAmount);
    List<ExpenseItem> readByExpenseItemCategory(String expenseItemCategory);
    List<ExpenseItem> readByExpenseItemClaimId(int expenseItemClaimId);
    List<ExpenseItem> readByExpenseItemCreatedAt(String expenseItemCreatedAt);
    List<ExpenseItem> readByExpenseItemDescription(String expenseItemDescription);
    ExpenseItem readByExpenseItemId(int expenseItemId);
    List<ExpenseItem> readByExpenseItemReceiptUrl(String expenseItemReceiptUrl);
    List<ExpenseItem> readByExpenseItemStatus(String expenseItemStatus);
    List<ExpenseItem> readByExpenseItemUpdatedAt(String expenseItemUpdatedAt);
}
