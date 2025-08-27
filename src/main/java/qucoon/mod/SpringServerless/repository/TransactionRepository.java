
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.TransactionPage;
import qucoon.mod.SpringServerless.model.request.TransactionFilterRequest;

import java.util.List;

@Repository
    public interface TransactionRepository {


    // Additional query methods can be defined here.
    int create(Transaction transaction);
    void bulkCreate(List<Transaction>  transaction);
    int update(Transaction  transaction);
    int delete(int transactionId);
    TransactionPage findTransaction(TransactionFilterRequest filter);
    boolean truncate();
    List<Transaction> read();
    List<Transaction> readByTransactionAmount(Double transactionAmount);
    List<Transaction> readByTransactionCreatedAt(String transactionCreatedAt);
    List<Transaction> readByTransactionDescription(String transactionDescription);
    Transaction readByTransactionId(int transactionId);
    List<Transaction> readByTransactionNarration(String transactionNarration);
    List<Transaction> readByTransactionReferenceNumber(String transactionReferenceNumber);
    List<Transaction> readByTransactionSourceModule(String transactionSourceModule);
    List<Transaction> readByTransactionSourceReferenceId(int transactionSourceReferenceId);
    List<Transaction> readByTransactionStatus(String transactionStatus);
    List<Transaction> readByTransactionTransactionCategoryId(int transactionTransactionCategoryId);
    List<Transaction> readByTransactionTransactionDate(String transactionTransactionDate);
    List<Transaction> readByTransactionUpdatedAt(String transactionUpdatedAt);
}
