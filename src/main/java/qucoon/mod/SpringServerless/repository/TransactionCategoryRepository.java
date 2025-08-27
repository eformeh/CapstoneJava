
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.TransactionCategoryPage;
import qucoon.mod.SpringServerless.model.request.TransactionCategoryFilterRequest;

import java.util.List;

@Repository
    public interface TransactionCategoryRepository {


    // Additional query methods can be defined here.
    int create(TransactionCategory transactioncategory);
    void bulkCreate(List<TransactionCategory>  transactioncategory);
    int update(TransactionCategory  transactioncategory);
    int delete(int transactionCategoryId);
    TransactionCategoryPage findTransactionCategory(TransactionCategoryFilterRequest filter);
    boolean truncate();
    List<TransactionCategory> read();
    List<TransactionCategory> readByTransactionCategoryCreatedAt(String transactionCategoryCreatedAt);
    List<TransactionCategory> readByTransactionCategoryDescription(String transactionCategoryDescription);
    TransactionCategory readByTransactionCategoryId(int transactionCategoryId);
    List<TransactionCategory> readByTransactionCategoryName(String transactionCategoryName);
    List<TransactionCategory> readByTransactionCategoryStatus(String transactionCategoryStatus);
    List<TransactionCategory> readByTransactionCategoryTransactionNature(String transactionCategoryTransactionNature);
    List<TransactionCategory> readByTransactionCategoryUpdatedAt(String transactionCategoryUpdatedAt);
}
