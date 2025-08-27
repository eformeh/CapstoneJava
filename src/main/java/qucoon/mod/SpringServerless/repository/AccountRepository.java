
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.AccountPage;
import qucoon.mod.SpringServerless.model.request.AccountFilterRequest;

import java.util.List;

@Repository
    public interface AccountRepository {


    // Additional query methods can be defined here.
    int create(Account account);
    void bulkCreate(List<Account>  account);
    int update(Account  account);
    int delete(int accountId);
    AccountPage findAccount(AccountFilterRequest filter);
    boolean truncate();
    List<Account> read();
    List<Account> readByAccountAccountName(String accountAccountName);
    List<Account> readByAccountAccountTypeId(int accountAccountTypeId);
    List<Account> readByAccountCreatedAt(String accountCreatedAt);
    List<Account> readByAccountDescription(String accountDescription);
    Account readByAccountId(int accountId);
    List<Account> readByAccountStatus(String accountStatus);
    List<Account> readByAccountUpdatedAt(String accountUpdatedAt);
}
