
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.AccountMappingPage;
import qucoon.mod.SpringServerless.model.request.AccountMappingFilterRequest;

import java.util.List;

@Repository
    public interface AccountMappingRepository {


    // Additional query methods can be defined here.
    int create(AccountMapping accountmapping);
    void bulkCreate(List<AccountMapping>  accountmapping);
    int update(AccountMapping  accountmapping);
    int delete(int accountMappingId);
    AccountMappingPage findAccountMapping(AccountMappingFilterRequest filter);
    boolean truncate();
    List<AccountMapping> read();
    List<AccountMapping> readByAccountMappingCrAccountId(int accountMappingCrAccountId);
    List<AccountMapping> readByAccountMappingCreatedAt(String accountMappingCreatedAt);
    List<AccountMapping> readByAccountMappingDescription(String accountMappingDescription);
    List<AccountMapping> readByAccountMappingDrAccountId(int accountMappingDrAccountId);
    AccountMapping readByAccountMappingId(int accountMappingId);
    List<AccountMapping> readByAccountMappingStatus(String accountMappingStatus);
    List<AccountMapping> readByAccountMappingTransactionCategoryId(int accountMappingTransactionCategoryId);
    List<AccountMapping> readByAccountMappingUpdatedAt(String accountMappingUpdatedAt);
}
