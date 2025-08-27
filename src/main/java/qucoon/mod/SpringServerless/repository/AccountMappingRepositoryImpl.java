
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
public class AccountMappingRepositoryImpl implements AccountMappingRepository {

    private final Environment environment;

    @Autowired
    public AccountMappingRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(AccountMapping  accountmapping) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int accountMappingId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), AccountMappingQuery.INSERT, true)
                .bind (accountmapping)
                .executeUpdate()
                .getKey(int.class);


        return accountMappingId;
    }

    @Override
    public void bulkCreate(List<AccountMapping> accountmappings) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,AccountMappingQuery.INSERT, false);
            for (AccountMapping accountmapping : accountmappings) {
                query.bind(accountmapping).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(AccountMapping accountmapping) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AccountMappingQuery.UPDATE, true)
                .bind (accountmapping)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int accountMappingId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AccountMappingQuery.DELETE, true)
                .addParameter("accountMappingId", accountMappingId)
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
                    .execute(AccountMappingQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<AccountMapping> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AccountMappingQuery.READ, true)
                .executeAndFetch(AccountMapping.class);
    }
    @Override
    public List<AccountMapping> readByAccountMappingCrAccountId(int accountMappingCrAccountId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AccountMappingQuery.READ_BY_ACCOUNT_MAPPING_ACCOUNTMAPPINGCRACCOUNTID, true)
                .addParameter(System.getenv("API_KEY_ACCOUNTM"), accountMappingCrAccountId)
                .executeAndFetch(AccountMapping.class);
    }
    @Override
    public List<AccountMapping> readByAccountMappingCreatedAt(String accountMappingCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AccountMappingQuery.READ_BY_ACCOUNT_MAPPING_ACCOUNTMAPPINGCREATEDAT, true)
                .addParameter(System.getenv("API_KEY_ACCOUNTM"), accountMappingCreatedAt)
                .executeAndFetch(AccountMapping.class);
    }
    @Override
    public List<AccountMapping> readByAccountMappingDescription(String accountMappingDescription) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AccountMappingQuery.READ_BY_ACCOUNT_MAPPING_ACCOUNTMAPPINGDESCRIPTION, true)
                .addParameter(System.getenv("API_KEY_ACCOUNTM"), accountMappingDescription)
                .executeAndFetch(AccountMapping.class);
    }
    @Override
    public List<AccountMapping> readByAccountMappingDrAccountId(int accountMappingDrAccountId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AccountMappingQuery.READ_BY_ACCOUNT_MAPPING_ACCOUNTMAPPINGDRACCOUNTID, true)
                .addParameter(System.getenv("API_KEY_ACCOUNTM"), accountMappingDrAccountId)
                .executeAndFetch(AccountMapping.class);
    }
    @Override
    public AccountMapping readByAccountMappingId(int accountMappingId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AccountMappingQuery.READ_BY_ACCOUNT_MAPPING_ACCOUNTMAPPINGID, true)
                .addParameter("accountMappingId", accountMappingId)
                .executeAndFetch (AccountMapping.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<AccountMapping> readByAccountMappingStatus(String accountMappingStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AccountMappingQuery.READ_BY_ACCOUNT_MAPPING_ACCOUNTMAPPINGSTATUS, true)
                .addParameter(System.getenv("API_KEY_ACCOUNTM"), accountMappingStatus)
                .executeAndFetch(AccountMapping.class);
    }
    @Override
    public List<AccountMapping> readByAccountMappingTransactionCategoryId(int accountMappingTransactionCategoryId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AccountMappingQuery.READ_BY_ACCOUNT_MAPPING_ACCOUNTMAPPINGTRANSACTIONCATEGORYID, true)
                .addParameter(System.getenv("API_KEY_ACCOUNTM"), accountMappingTransactionCategoryId)
                .executeAndFetch(AccountMapping.class);
    }
    @Override
    public List<AccountMapping> readByAccountMappingUpdatedAt(String accountMappingUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),AccountMappingQuery.READ_BY_ACCOUNT_MAPPING_ACCOUNTMAPPINGUPDATEDAT, true)
                .addParameter(System.getenv("API_KEY_ACCOUNTM"), accountMappingUpdatedAt)
                .executeAndFetch(AccountMapping.class);
    }

@Override
public AccountMappingPage findAccountMapping(AccountMappingFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(AccountMappingQuery.READ);

    // Dynamic filters

    if (filter.getAccountMappingCrAccountId() != null) {   baseSql.append(" AND accountMappingCrAccountId = :accountMappingCrAccountId"); }
    if (filter.getAccountMappingCreatedAt() != null) {   baseSql.append(" AND accountMappingCreatedAt = :accountMappingCreatedAt"); }
    if (filter.getAccountMappingDescription() != null) {   baseSql.append(" AND accountMappingDescription = :accountMappingDescription"); }
    if (filter.getAccountMappingDrAccountId() != null) {   baseSql.append(" AND accountMappingDrAccountId = :accountMappingDrAccountId"); }
    if (filter.getAccountMappingId() != null) {   baseSql.append(" AND accountMappingId = :accountMappingId"); }
    if (filter.getAccountMappingStatus() != null) {   baseSql.append(" AND accountMappingStatus = :accountMappingStatus"); }
    if (filter.getAccountMappingTransactionCategoryId() != null) {   baseSql.append(" AND accountMappingTransactionCategoryId = :accountMappingTransactionCategoryId"); }
    if (filter.getAccountMappingUpdatedAt() != null) {   baseSql.append(" AND accountMappingUpdatedAt = :accountMappingUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getAccountMappingCrAccountId() != null) countQuery.addParameter(System.getenv("API_KEY_ACCOUNTM"), filter.getAccountMappingCrAccountId());
     if (filter.getAccountMappingCreatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_ACCOUNTM"), filter.getAccountMappingCreatedAt());
     if (filter.getAccountMappingDescription() != null) countQuery.addParameter(System.getenv("API_KEY_ACCOUNTM"), filter.getAccountMappingDescription());
     if (filter.getAccountMappingDrAccountId() != null) countQuery.addParameter(System.getenv("API_KEY_ACCOUNTM"), filter.getAccountMappingDrAccountId());
     if (filter.getAccountMappingId() != null) countQuery.addParameter("accountMappingId", filter.getAccountMappingId());
     if (filter.getAccountMappingStatus() != null) countQuery.addParameter(System.getenv("API_KEY_ACCOUNTM"), filter.getAccountMappingStatus());
     if (filter.getAccountMappingTransactionCategoryId() != null) countQuery.addParameter(System.getenv("API_KEY_ACCOUNTM"), filter.getAccountMappingTransactionCategoryId());
     if (filter.getAccountMappingUpdatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_ACCOUNTM"), filter.getAccountMappingUpdatedAt());
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

    if (filter.getAccountMappingCrAccountId() != null) pageQuery.addParameter(System.getenv("API_KEY_ACCOUNTM"), filter.getAccountMappingCrAccountId());
    if (filter.getAccountMappingCreatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_ACCOUNTM"), filter.getAccountMappingCreatedAt());
    if (filter.getAccountMappingDescription() != null) pageQuery.addParameter(System.getenv("API_KEY_ACCOUNTM"), filter.getAccountMappingDescription());
    if (filter.getAccountMappingDrAccountId() != null) pageQuery.addParameter(System.getenv("API_KEY_ACCOUNTM"), filter.getAccountMappingDrAccountId());
    if (filter.getAccountMappingId() != null) pageQuery.addParameter("accountMappingId", filter.getAccountMappingId());
    if (filter.getAccountMappingStatus() != null) pageQuery.addParameter(System.getenv("API_KEY_ACCOUNTM"), filter.getAccountMappingStatus());
    if (filter.getAccountMappingTransactionCategoryId() != null) pageQuery.addParameter(System.getenv("API_KEY_ACCOUNTM"), filter.getAccountMappingTransactionCategoryId());
    if (filter.getAccountMappingUpdatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_ACCOUNTM"), filter.getAccountMappingUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<AccountMapping> data = pageQuery.executeAndFetch(AccountMapping.class);

     return new AccountMappingPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          System.getenv("API_KEY_ACCOUNTM"),System.getenv("API_KEY_ACCOUNTM"),System.getenv("API_KEY_ACCOUNTM"),System.getenv("API_KEY_ACCOUNTM"),"accountMappingId",System.getenv("API_KEY_ACCOUNTM"),System.getenv("API_KEY_ACCOUNTM"),System.getenv("API_KEY_ACCOUNTM")
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
