
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
public class EmployeeAccountRepositoryImpl implements EmployeeAccountRepository {

    private final Environment environment;

    @Autowired
    public EmployeeAccountRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(EmployeeAccount  employeeaccount) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int employeeAccountId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), EmployeeAccountQuery.INSERT, true)
                .bind (employeeaccount)
                .executeUpdate()
                .getKey(int.class);


        return employeeAccountId;
    }

    @Override
    public void bulkCreate(List<EmployeeAccount> employeeaccounts) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,EmployeeAccountQuery.INSERT, false);
            for (EmployeeAccount employeeaccount : employeeaccounts) {
                query.bind(employeeaccount).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(EmployeeAccount employeeaccount) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeAccountQuery.UPDATE, true)
                .bind (employeeaccount)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int employeeAccountId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeAccountQuery.DELETE, true)
                .addParameter("employeeAccountId", employeeAccountId)
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
                    .execute(EmployeeAccountQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<EmployeeAccount> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeAccountQuery.READ, true)
                .executeAndFetch(EmployeeAccount.class);
    }
    @Override
    public List<EmployeeAccount> readByEmployeeAccountBankName(String employeeAccountBankName) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeAccountQuery.READ_BY_EMPLOYEE_ACCOUNT_EMPLOYEEACCOUNTBANKNAME, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeAccountBankName)
                .executeAndFetch(EmployeeAccount.class);
    }
    @Override
    public List<EmployeeAccount> readByEmployeeAccountCreatedAt(String employeeAccountCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeAccountQuery.READ_BY_EMPLOYEE_ACCOUNT_EMPLOYEEACCOUNTCREATEDAT, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeAccountCreatedAt)
                .executeAndFetch(EmployeeAccount.class);
    }
    @Override
    public List<EmployeeAccount> readByEmployeeAccountEmployeeId(int employeeAccountEmployeeId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeAccountQuery.READ_BY_EMPLOYEE_ACCOUNT_EMPLOYEEACCOUNTEMPLOYEEID, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeAccountEmployeeId)
                .executeAndFetch(EmployeeAccount.class);
    }
    @Override
    public EmployeeAccount readByEmployeeAccountId(int employeeAccountId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeAccountQuery.READ_BY_EMPLOYEE_ACCOUNT_EMPLOYEEACCOUNTID, true)
                .addParameter("employeeAccountId", employeeAccountId)
                .executeAndFetch (EmployeeAccount.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<EmployeeAccount> readByEmployeeAccountName(String employeeAccountName) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeAccountQuery.READ_BY_EMPLOYEE_ACCOUNT_EMPLOYEEACCOUNTNAME, true)
                .addParameter("employeeAccountName", employeeAccountName)
                .executeAndFetch(EmployeeAccount.class);
    }
    @Override
    public List<EmployeeAccount> readByEmployeeAccountNumber(String employeeAccountNumber) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeAccountQuery.READ_BY_EMPLOYEE_ACCOUNT_EMPLOYEEACCOUNTNUMBER, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeAccountNumber)
                .executeAndFetch(EmployeeAccount.class);
    }
    @Override
    public List<EmployeeAccount> readByEmployeeAccountStatus(String employeeAccountStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeAccountQuery.READ_BY_EMPLOYEE_ACCOUNT_EMPLOYEEACCOUNTSTATUS, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeAccountStatus)
                .executeAndFetch(EmployeeAccount.class);
    }
    @Override
    public List<EmployeeAccount> readByEmployeeAccountUpdatedAt(String employeeAccountUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),EmployeeAccountQuery.READ_BY_EMPLOYEE_ACCOUNT_EMPLOYEEACCOUNTUPDATEDAT, true)
                .addParameter(System.getenv("API_KEY_EMPLOYEE"), employeeAccountUpdatedAt)
                .executeAndFetch(EmployeeAccount.class);
    }

@Override
public EmployeeAccountPage findEmployeeAccount(EmployeeAccountFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(EmployeeAccountQuery.READ);

    // Dynamic filters

    if (filter.getEmployeeAccountBankName() != null) {   baseSql.append(" AND employeeAccountBankName = :employeeAccountBankName"); }
    if (filter.getEmployeeAccountCreatedAt() != null) {   baseSql.append(" AND employeeAccountCreatedAt = :employeeAccountCreatedAt"); }
    if (filter.getEmployeeAccountEmployeeId() != null) {   baseSql.append(" AND employeeAccountEmployeeId = :employeeAccountEmployeeId"); }
    if (filter.getEmployeeAccountId() != null) {   baseSql.append(" AND employeeAccountId = :employeeAccountId"); }
    if (filter.getEmployeeAccountName() != null) {   baseSql.append(" AND employeeAccountName = :employeeAccountName"); }
    if (filter.getEmployeeAccountNumber() != null) {   baseSql.append(" AND employeeAccountNumber = :employeeAccountNumber"); }
    if (filter.getEmployeeAccountStatus() != null) {   baseSql.append(" AND employeeAccountStatus = :employeeAccountStatus"); }
    if (filter.getEmployeeAccountUpdatedAt() != null) {   baseSql.append(" AND employeeAccountUpdatedAt = :employeeAccountUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getEmployeeAccountBankName() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeAccountBankName());
     if (filter.getEmployeeAccountCreatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeAccountCreatedAt());
     if (filter.getEmployeeAccountEmployeeId() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeAccountEmployeeId());
     if (filter.getEmployeeAccountId() != null) countQuery.addParameter("employeeAccountId", filter.getEmployeeAccountId());
     if (filter.getEmployeeAccountName() != null) countQuery.addParameter("employeeAccountName", filter.getEmployeeAccountName());
     if (filter.getEmployeeAccountNumber() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeAccountNumber());
     if (filter.getEmployeeAccountStatus() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeAccountStatus());
     if (filter.getEmployeeAccountUpdatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeAccountUpdatedAt());
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

    if (filter.getEmployeeAccountBankName() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeAccountBankName());
    if (filter.getEmployeeAccountCreatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeAccountCreatedAt());
    if (filter.getEmployeeAccountEmployeeId() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeAccountEmployeeId());
    if (filter.getEmployeeAccountId() != null) pageQuery.addParameter("employeeAccountId", filter.getEmployeeAccountId());
    if (filter.getEmployeeAccountName() != null) pageQuery.addParameter("employeeAccountName", filter.getEmployeeAccountName());
    if (filter.getEmployeeAccountNumber() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeAccountNumber());
    if (filter.getEmployeeAccountStatus() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeAccountStatus());
    if (filter.getEmployeeAccountUpdatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_EMPLOYEE"), filter.getEmployeeAccountUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<EmployeeAccount> data = pageQuery.executeAndFetch(EmployeeAccount.class);

     return new EmployeeAccountPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          System.getenv("API_KEY_EMPLOYEE"),System.getenv("API_KEY_EMPLOYEE"),System.getenv("API_KEY_EMPLOYEE"),"employeeAccountId","employeeAccountName",System.getenv("API_KEY_EMPLOYEE"),System.getenv("API_KEY_EMPLOYEE"),System.getenv("API_KEY_EMPLOYEE")
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
