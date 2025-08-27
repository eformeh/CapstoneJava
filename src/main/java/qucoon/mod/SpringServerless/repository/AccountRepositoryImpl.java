
package   qucoon.mod.SpringServerless.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.repository.query.*;
import qucoon.mod.SpringServerless.utility.Environment;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.model.request.*;
import qucoon.mod.SpringServerless.repository.page.*;
import qucoon.mod.SpringServerless.model.entity.Module;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import java.util.List;

import static qucoon.mod.SpringServerless.repository.query.QueryUtils.createQueryWithoutOnMappingFailure;


@Repository
public class AccountRepositoryImpl implements AccountRepository {

    private final Environment environment;

    @Autowired
    public AccountRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(Account  account) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int accountId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), AccountQuery.INSERT, true)
                .bind (account)
                .executeUpdate()
                .getKey(int.class);


        return accountId;
    }

    @Override
    public void bulkCreate(List<Account> accounts) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,AccountQuery.INSERT, false);
            for (Account account : accounts) {
                query.bind(account).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(Account account) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AccountQuery.UPDATE, true)
                .bind (account)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int accountId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AccountQuery.DELETE, true)
                .addParameter("accountId", accountId)
                .executeUpdate()
                .getResult();
    }

    @Override
    public boolean truncate() {
        try {
            assert environment.getDatabaseUtil().getSql2oConnection() != null;
            return environment.getDatabaseUtil().getSql2oConnection()
                    .getJdbcConnection()
                    .createStatement()
                    .execute(AccountQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Account> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AccountQuery.READ, true)
                .executeAndFetch(Account.class);
    }
    @Override
    public List<Account> readByAccountAccountName(String accountAccountName) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AccountQuery.READ_BY_ACCOUNT_ACCOUNTACCOUNTNAME, true)
                .addParameter("accountAccountName", accountAccountName)
                .executeAndFetch(Account.class);
    }
    @Override
    public List<Account> readByAccountAccountTypeId(int accountAccountTypeId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AccountQuery.READ_BY_ACCOUNT_ACCOUNTACCOUNTTYPEID, true)
                .addParameter(System.getenv("API_KEY_ACCOUNTA"), accountAccountTypeId)
                .executeAndFetch(Account.class);
    }
    @Override
    public List<Account> readByAccountCreatedAt(String accountCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AccountQuery.READ_BY_ACCOUNT_ACCOUNTCREATEDAT, true)
                .addParameter("accountCreatedAt", accountCreatedAt)
                .executeAndFetch(Account.class);
    }
    @Override
    public List<Account> readByAccountDescription(String accountDescription) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AccountQuery.READ_BY_ACCOUNT_ACCOUNTDESCRIPTION, true)
                .addParameter("accountDescription", accountDescription)
                .executeAndFetch(Account.class);
    }
    @Override
    public Account readByAccountId(int accountId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AccountQuery.READ_BY_ACCOUNT_ACCOUNTID, true)
                .addParameter("accountId", accountId)
                .executeAndFetch (Account.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Account> readByAccountStatus(String accountStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AccountQuery.READ_BY_ACCOUNT_ACCOUNTSTATUS, true)
                .addParameter("accountStatus", accountStatus)
                .executeAndFetch(Account.class);
    }
    @Override
    public List<Account> readByAccountUpdatedAt(String accountUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AccountQuery.READ_BY_ACCOUNT_ACCOUNTUPDATEDAT, true)
                .addParameter("accountUpdatedAt", accountUpdatedAt)
                .executeAndFetch(Account.class);
    }

@Override
public AccountPage findAccount(AccountFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(AccountQuery.READ);

    // Dynamic filters

    if (filter.getAccountAccountName() != null) {   baseSql.append(" AND accountAccountName = :accountAccountName"); }
    if (filter.getAccountAccountTypeId() != null) {   baseSql.append(" AND accountAccountTypeId = :accountAccountTypeId"); }
    if (filter.getAccountCreatedAt() != null) {   baseSql.append(" AND accountCreatedAt = :accountCreatedAt"); }
    if (filter.getAccountDescription() != null) {   baseSql.append(" AND accountDescription = :accountDescription"); }
    if (filter.getAccountId() != null) {   baseSql.append(" AND accountId = :accountId"); }
    if (filter.getAccountStatus() != null) {   baseSql.append(" AND accountStatus = :accountStatus"); }
    if (filter.getAccountUpdatedAt() != null) {   baseSql.append(" AND accountUpdatedAt = :accountUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getAccountAccountName() != null) countQuery.addParameter("accountAccountName", filter.getAccountAccountName());
     if (filter.getAccountAccountTypeId() != null) countQuery.addParameter(System.getenv("API_KEY_ACCOUNTA"), filter.getAccountAccountTypeId());
     if (filter.getAccountCreatedAt() != null) countQuery.addParameter("accountCreatedAt", filter.getAccountCreatedAt());
     if (filter.getAccountDescription() != null) countQuery.addParameter("accountDescription", filter.getAccountDescription());
     if (filter.getAccountId() != null) countQuery.addParameter("accountId", filter.getAccountId());
     if (filter.getAccountStatus() != null) countQuery.addParameter("accountStatus", filter.getAccountStatus());
     if (filter.getAccountUpdatedAt() != null) countQuery.addParameter("accountUpdatedAt", filter.getAccountUpdatedAt());
     if (filter.getSearch() != null) countQuery.addParameter("search", "%" + filter.getSearch() + "%");
     Long total = countQuery.executeScalar(Long.class);

   // MSSQL pagination requires ORDER BY for OFFSET/FETCH
    String validSortDir = filter.getSortDir().equalsIgnoreCase("ASC") ? "ASC" : "DESC";
    String orderBy = " ORDER BY " + sanitizeSortBy(filter.getSortBy()) + " " + validSortDir;
     // Append order and pagination
     StringBuilder pageSql_old = new StringBuilder(baseSql)
             .append(" ORDER BY ").append (filter.getSortBy())
             .append(" ").append (filter.getSortDir())
             .append("  OFFSET :offset ROWS FETCH NEXT :limit ROWS ONLY");
    // Build pagination SQL
    String pageSql = baseSql.toString() + orderBy +
" OFFSET :offset ROWS FETCH NEXT :limit ROWS ONLY";

     // Fetch page data
     var pageQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             pageSql.toString(),
             true);

    if (filter.getAccountAccountName() != null) pageQuery.addParameter("accountAccountName", filter.getAccountAccountName());
    if (filter.getAccountAccountTypeId() != null) pageQuery.addParameter(System.getenv("API_KEY_ACCOUNTA"), filter.getAccountAccountTypeId());
    if (filter.getAccountCreatedAt() != null) pageQuery.addParameter("accountCreatedAt", filter.getAccountCreatedAt());
    if (filter.getAccountDescription() != null) pageQuery.addParameter("accountDescription", filter.getAccountDescription());
    if (filter.getAccountId() != null) pageQuery.addParameter("accountId", filter.getAccountId());
    if (filter.getAccountStatus() != null) pageQuery.addParameter("accountStatus", filter.getAccountStatus());
    if (filter.getAccountUpdatedAt() != null) pageQuery.addParameter("accountUpdatedAt", filter.getAccountUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<Account> data = pageQuery.executeAndFetch(Account.class);

     return new AccountPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "accountAccountName",System.getenv("API_KEY_ACCOUNTA"),"accountCreatedAt","accountDescription","accountId","accountStatus","accountUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
