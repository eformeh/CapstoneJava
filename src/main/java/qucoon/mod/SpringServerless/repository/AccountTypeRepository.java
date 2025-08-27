
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.AccountTypePage;
import qucoon.mod.SpringServerless.model.request.AccountTypeFilterRequest;

import java.util.List;

@Repository
    public interface AccountTypeRepository {


    // Additional query methods can be defined here.
    int create(AccountType accounttype);
    void bulkCreate(List<AccountType>  accounttype);
    int update(AccountType  accounttype);
    int delete(int accountTypeId);
    AccountTypePage findAccountType(AccountTypeFilterRequest filter);
    boolean truncate();
    List<AccountType> read();
    List<AccountType> readByAccountTypeAccountTypeName(String accountTypeAccountTypeName);
    List<AccountType> readByAccountTypeCreatedAt(String accountTypeCreatedAt);
    List<AccountType> readByAccountTypeDescription(String accountTypeDescription);
    AccountType readByAccountTypeId(int accountTypeId);
    List<AccountType> readByAccountTypeNormalBalance(String accountTypeNormalBalance);
    List<AccountType> readByAccountTypeStatus(String accountTypeStatus);
    List<AccountType> readByAccountTypeUpdatedAt(String accountTypeUpdatedAt);
}
