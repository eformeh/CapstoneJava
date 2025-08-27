
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
public class ExpenseClaimRepositoryImpl implements ExpenseClaimRepository {

    private final Environment environment;

    @Autowired
    public ExpenseClaimRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(ExpenseClaim  expenseclaim) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int expenseClaimId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), ExpenseClaimQuery.INSERT, true)
                .bind (expenseclaim)
                .executeUpdate()
                .getKey(int.class);


        return expenseClaimId;
    }

    @Override
    public void bulkCreate(List<ExpenseClaim> expenseclaims) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,ExpenseClaimQuery.INSERT, false);
            for (ExpenseClaim expenseclaim : expenseclaims) {
                query.bind(expenseclaim).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(ExpenseClaim expenseclaim) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ExpenseClaimQuery.UPDATE, true)
                .bind (expenseclaim)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int expenseClaimId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ExpenseClaimQuery.DELETE, true)
                .addParameter("expenseClaimId", expenseClaimId)
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
                    .execute(ExpenseClaimQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ExpenseClaim> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ExpenseClaimQuery.READ, true)
                .executeAndFetch(ExpenseClaim.class);
    }
    @Override
    public List<ExpenseClaim> readByExpenseClaimCreatedAt(String expenseClaimCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ExpenseClaimQuery.READ_BY_EXPENSE_CLAIM_EXPENSECLAIMCREATEDAT, true)
                .addParameter(System.getenv("API_KEY_EXPENSEC"), expenseClaimCreatedAt)
                .executeAndFetch(ExpenseClaim.class);
    }
    @Override
    public List<ExpenseClaim> readByExpenseClaimDecisionDate(String expenseClaimDecisionDate) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ExpenseClaimQuery.READ_BY_EXPENSE_CLAIM_EXPENSECLAIMDECISIONDATE, true)
                .addParameter(System.getenv("API_KEY_EXPENSEC"), expenseClaimDecisionDate)
                .executeAndFetch(ExpenseClaim.class);
    }
    @Override
    public List<ExpenseClaim> readByExpenseClaimEmployeeId(int expenseClaimEmployeeId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ExpenseClaimQuery.READ_BY_EXPENSE_CLAIM_EXPENSECLAIMEMPLOYEEID, true)
                .addParameter(System.getenv("API_KEY_EXPENSEC"), expenseClaimEmployeeId)
                .executeAndFetch(ExpenseClaim.class);
    }
    @Override
    public ExpenseClaim readByExpenseClaimId(int expenseClaimId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ExpenseClaimQuery.READ_BY_EXPENSE_CLAIM_EXPENSECLAIMID, true)
                .addParameter("expenseClaimId", expenseClaimId)
                .executeAndFetch (ExpenseClaim.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<ExpenseClaim> readByExpenseClaimReimbursementDate(String expenseClaimReimbursementDate) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ExpenseClaimQuery.READ_BY_EXPENSE_CLAIM_EXPENSECLAIMREIMBURSEMENTDATE, true)
                .addParameter(System.getenv("API_KEY_EXPENSEC"), expenseClaimReimbursementDate)
                .executeAndFetch(ExpenseClaim.class);
    }
    @Override
    public List<ExpenseClaim> readByExpenseClaimReviewerId(int expenseClaimReviewerId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ExpenseClaimQuery.READ_BY_EXPENSE_CLAIM_EXPENSECLAIMREVIEWERID, true)
                .addParameter(System.getenv("API_KEY_EXPENSEC"), expenseClaimReviewerId)
                .executeAndFetch(ExpenseClaim.class);
    }
    @Override
    public List<ExpenseClaim> readByExpenseClaimStatus(String expenseClaimStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ExpenseClaimQuery.READ_BY_EXPENSE_CLAIM_EXPENSECLAIMSTATUS, true)
                .addParameter("expenseClaimStatus", expenseClaimStatus)
                .executeAndFetch(ExpenseClaim.class);
    }
    @Override
    public List<ExpenseClaim> readByExpenseClaimTotalAmount(Double expenseClaimTotalAmount) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ExpenseClaimQuery.READ_BY_EXPENSE_CLAIM_EXPENSECLAIMTOTALAMOUNT, true)
                .addParameter(System.getenv("API_KEY_EXPENSEC"), expenseClaimTotalAmount)
                .executeAndFetch(ExpenseClaim.class);
    }
    @Override
    public List<ExpenseClaim> readByExpenseClaimUpdatedAt(String expenseClaimUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ExpenseClaimQuery.READ_BY_EXPENSE_CLAIM_EXPENSECLAIMUPDATEDAT, true)
                .addParameter(System.getenv("API_KEY_EXPENSEC"), expenseClaimUpdatedAt)
                .executeAndFetch(ExpenseClaim.class);
    }

@Override
public ExpenseClaimPage findExpenseClaim(ExpenseClaimFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(ExpenseClaimQuery.READ);

    // Dynamic filters

    if (filter.getExpenseClaimCreatedAt() != null) {   baseSql.append(" AND expenseClaimCreatedAt = :expenseClaimCreatedAt"); }
    if (filter.getExpenseClaimDecisionDate() != null) {   baseSql.append(" AND expenseClaimDecisionDate = :expenseClaimDecisionDate"); }
    if (filter.getExpenseClaimEmployeeId() != null) {   baseSql.append(" AND expenseClaimEmployeeId = :expenseClaimEmployeeId"); }
    if (filter.getExpenseClaimId() != null) {   baseSql.append(" AND expenseClaimId = :expenseClaimId"); }
    if (filter.getExpenseClaimReimbursementDate() != null) {   baseSql.append(" AND expenseClaimReimbursementDate = :expenseClaimReimbursementDate"); }
    if (filter.getExpenseClaimReviewerId() != null) {   baseSql.append(" AND expenseClaimReviewerId = :expenseClaimReviewerId"); }
    if (filter.getExpenseClaimStatus() != null) {   baseSql.append(" AND expenseClaimStatus = :expenseClaimStatus"); }
    if (filter.getExpenseClaimTotalAmount() != null) {   baseSql.append(" AND expenseClaimTotalAmount = :expenseClaimTotalAmount"); }
    if (filter.getExpenseClaimUpdatedAt() != null) {   baseSql.append(" AND expenseClaimUpdatedAt = :expenseClaimUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getExpenseClaimCreatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_EXPENSEC"), filter.getExpenseClaimCreatedAt());
     if (filter.getExpenseClaimDecisionDate() != null) countQuery.addParameter(System.getenv("API_KEY_EXPENSEC"), filter.getExpenseClaimDecisionDate());
     if (filter.getExpenseClaimEmployeeId() != null) countQuery.addParameter(System.getenv("API_KEY_EXPENSEC"), filter.getExpenseClaimEmployeeId());
     if (filter.getExpenseClaimId() != null) countQuery.addParameter("expenseClaimId", filter.getExpenseClaimId());
     if (filter.getExpenseClaimReimbursementDate() != null) countQuery.addParameter(System.getenv("API_KEY_EXPENSEC"), filter.getExpenseClaimReimbursementDate());
     if (filter.getExpenseClaimReviewerId() != null) countQuery.addParameter(System.getenv("API_KEY_EXPENSEC"), filter.getExpenseClaimReviewerId());
     if (filter.getExpenseClaimStatus() != null) countQuery.addParameter("expenseClaimStatus", filter.getExpenseClaimStatus());
     if (filter.getExpenseClaimTotalAmount() != null) countQuery.addParameter(System.getenv("API_KEY_EXPENSEC"), filter.getExpenseClaimTotalAmount());
     if (filter.getExpenseClaimUpdatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_EXPENSEC"), filter.getExpenseClaimUpdatedAt());
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

    if (filter.getExpenseClaimCreatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_EXPENSEC"), filter.getExpenseClaimCreatedAt());
    if (filter.getExpenseClaimDecisionDate() != null) pageQuery.addParameter(System.getenv("API_KEY_EXPENSEC"), filter.getExpenseClaimDecisionDate());
    if (filter.getExpenseClaimEmployeeId() != null) pageQuery.addParameter(System.getenv("API_KEY_EXPENSEC"), filter.getExpenseClaimEmployeeId());
    if (filter.getExpenseClaimId() != null) pageQuery.addParameter("expenseClaimId", filter.getExpenseClaimId());
    if (filter.getExpenseClaimReimbursementDate() != null) pageQuery.addParameter(System.getenv("API_KEY_EXPENSEC"), filter.getExpenseClaimReimbursementDate());
    if (filter.getExpenseClaimReviewerId() != null) pageQuery.addParameter(System.getenv("API_KEY_EXPENSEC"), filter.getExpenseClaimReviewerId());
    if (filter.getExpenseClaimStatus() != null) pageQuery.addParameter("expenseClaimStatus", filter.getExpenseClaimStatus());
    if (filter.getExpenseClaimTotalAmount() != null) pageQuery.addParameter(System.getenv("API_KEY_EXPENSEC"), filter.getExpenseClaimTotalAmount());
    if (filter.getExpenseClaimUpdatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_EXPENSEC"), filter.getExpenseClaimUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<ExpenseClaim> data = pageQuery.executeAndFetch(ExpenseClaim.class);

     return new ExpenseClaimPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          System.getenv("API_KEY_EXPENSEC"),System.getenv("API_KEY_EXPENSEC"),System.getenv("API_KEY_EXPENSEC"),"expenseClaimId",System.getenv("API_KEY_EXPENSEC"),System.getenv("API_KEY_EXPENSEC"),"expenseClaimStatus",System.getenv("API_KEY_EXPENSEC"),System.getenv("API_KEY_EXPENSEC")
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
