
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
public class ExpenseItemRepositoryImpl implements ExpenseItemRepository {

    private final Environment environment;

    @Autowired
    public ExpenseItemRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(ExpenseItem  expenseitem) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int expenseItemId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), ExpenseItemQuery.INSERT, true)
                .bind (expenseitem)
                .executeUpdate()
                .getKey(int.class);


        return expenseItemId;
    }

    @Override
    public void bulkCreate(List<ExpenseItem> expenseitems) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,ExpenseItemQuery.INSERT, false);
            for (ExpenseItem expenseitem : expenseitems) {
                query.bind(expenseitem).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(ExpenseItem expenseitem) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ExpenseItemQuery.UPDATE, true)
                .bind (expenseitem)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int expenseItemId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ExpenseItemQuery.DELETE, true)
                .addParameter("expenseItemId", expenseItemId)
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
                    .execute(ExpenseItemQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ExpenseItem> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ExpenseItemQuery.READ, true)
                .executeAndFetch(ExpenseItem.class);
    }
    @Override
    public List<ExpenseItem> readByExpenseItemAmount(Double expenseItemAmount) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ExpenseItemQuery.READ_BY_EXPENSE_ITEM_EXPENSEITEMAMOUNT, true)
                .addParameter("expenseItemAmount", expenseItemAmount)
                .executeAndFetch(ExpenseItem.class);
    }
    @Override
    public List<ExpenseItem> readByExpenseItemCategory(String expenseItemCategory) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ExpenseItemQuery.READ_BY_EXPENSE_ITEM_EXPENSEITEMCATEGORY, true)
                .addParameter("expenseItemCategory", expenseItemCategory)
                .executeAndFetch(ExpenseItem.class);
    }
    @Override
    public List<ExpenseItem> readByExpenseItemClaimId(int expenseItemClaimId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ExpenseItemQuery.READ_BY_EXPENSE_ITEM_EXPENSEITEMCLAIMID, true)
                .addParameter("expenseItemClaimId", expenseItemClaimId)
                .executeAndFetch(ExpenseItem.class);
    }
    @Override
    public List<ExpenseItem> readByExpenseItemCreatedAt(String expenseItemCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ExpenseItemQuery.READ_BY_EXPENSE_ITEM_EXPENSEITEMCREATEDAT, true)
                .addParameter(System.getenv("API_KEY_EXPENSEI"), expenseItemCreatedAt)
                .executeAndFetch(ExpenseItem.class);
    }
    @Override
    public List<ExpenseItem> readByExpenseItemDescription(String expenseItemDescription) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ExpenseItemQuery.READ_BY_EXPENSE_ITEM_EXPENSEITEMDESCRIPTION, true)
                .addParameter(System.getenv("API_KEY_EXPENSEI"), expenseItemDescription)
                .executeAndFetch(ExpenseItem.class);
    }
    @Override
    public ExpenseItem readByExpenseItemId(int expenseItemId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ExpenseItemQuery.READ_BY_EXPENSE_ITEM_EXPENSEITEMID, true)
                .addParameter("expenseItemId", expenseItemId)
                .executeAndFetch (ExpenseItem.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<ExpenseItem> readByExpenseItemReceiptUrl(String expenseItemReceiptUrl) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ExpenseItemQuery.READ_BY_EXPENSE_ITEM_EXPENSEITEMRECEIPTURL, true)
                .addParameter(System.getenv("API_KEY_EXPENSEI"), expenseItemReceiptUrl)
                .executeAndFetch(ExpenseItem.class);
    }
    @Override
    public List<ExpenseItem> readByExpenseItemStatus(String expenseItemStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ExpenseItemQuery.READ_BY_EXPENSE_ITEM_EXPENSEITEMSTATUS, true)
                .addParameter("expenseItemStatus", expenseItemStatus)
                .executeAndFetch(ExpenseItem.class);
    }
    @Override
    public List<ExpenseItem> readByExpenseItemUpdatedAt(String expenseItemUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),ExpenseItemQuery.READ_BY_EXPENSE_ITEM_EXPENSEITEMUPDATEDAT, true)
                .addParameter(System.getenv("API_KEY_EXPENSEI"), expenseItemUpdatedAt)
                .executeAndFetch(ExpenseItem.class);
    }

@Override
public ExpenseItemPage findExpenseItem(ExpenseItemFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(ExpenseItemQuery.READ);

    // Dynamic filters

    if (filter.getExpenseItemAmount() != null) {   baseSql.append(" AND expenseItemAmount = :expenseItemAmount"); }
    if (filter.getExpenseItemCategory() != null) {   baseSql.append(" AND expenseItemCategory = :expenseItemCategory"); }
    if (filter.getExpenseItemClaimId() != null) {   baseSql.append(" AND expenseItemClaimId = :expenseItemClaimId"); }
    if (filter.getExpenseItemCreatedAt() != null) {   baseSql.append(" AND expenseItemCreatedAt = :expenseItemCreatedAt"); }
    if (filter.getExpenseItemDescription() != null) {   baseSql.append(" AND expenseItemDescription = :expenseItemDescription"); }
    if (filter.getExpenseItemId() != null) {   baseSql.append(" AND expenseItemId = :expenseItemId"); }
    if (filter.getExpenseItemReceiptUrl() != null) {   baseSql.append(" AND expenseItemReceiptUrl = :expenseItemReceiptUrl"); }
    if (filter.getExpenseItemStatus() != null) {   baseSql.append(" AND expenseItemStatus = :expenseItemStatus"); }
    if (filter.getExpenseItemUpdatedAt() != null) {   baseSql.append(" AND expenseItemUpdatedAt = :expenseItemUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getExpenseItemAmount() != null) countQuery.addParameter("expenseItemAmount", filter.getExpenseItemAmount());
     if (filter.getExpenseItemCategory() != null) countQuery.addParameter("expenseItemCategory", filter.getExpenseItemCategory());
     if (filter.getExpenseItemClaimId() != null) countQuery.addParameter("expenseItemClaimId", filter.getExpenseItemClaimId());
     if (filter.getExpenseItemCreatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_EXPENSEI"), filter.getExpenseItemCreatedAt());
     if (filter.getExpenseItemDescription() != null) countQuery.addParameter(System.getenv("API_KEY_EXPENSEI"), filter.getExpenseItemDescription());
     if (filter.getExpenseItemId() != null) countQuery.addParameter("expenseItemId", filter.getExpenseItemId());
     if (filter.getExpenseItemReceiptUrl() != null) countQuery.addParameter(System.getenv("API_KEY_EXPENSEI"), filter.getExpenseItemReceiptUrl());
     if (filter.getExpenseItemStatus() != null) countQuery.addParameter("expenseItemStatus", filter.getExpenseItemStatus());
     if (filter.getExpenseItemUpdatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_EXPENSEI"), filter.getExpenseItemUpdatedAt());
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

    if (filter.getExpenseItemAmount() != null) pageQuery.addParameter("expenseItemAmount", filter.getExpenseItemAmount());
    if (filter.getExpenseItemCategory() != null) pageQuery.addParameter("expenseItemCategory", filter.getExpenseItemCategory());
    if (filter.getExpenseItemClaimId() != null) pageQuery.addParameter("expenseItemClaimId", filter.getExpenseItemClaimId());
    if (filter.getExpenseItemCreatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_EXPENSEI"), filter.getExpenseItemCreatedAt());
    if (filter.getExpenseItemDescription() != null) pageQuery.addParameter(System.getenv("API_KEY_EXPENSEI"), filter.getExpenseItemDescription());
    if (filter.getExpenseItemId() != null) pageQuery.addParameter("expenseItemId", filter.getExpenseItemId());
    if (filter.getExpenseItemReceiptUrl() != null) pageQuery.addParameter(System.getenv("API_KEY_EXPENSEI"), filter.getExpenseItemReceiptUrl());
    if (filter.getExpenseItemStatus() != null) pageQuery.addParameter("expenseItemStatus", filter.getExpenseItemStatus());
    if (filter.getExpenseItemUpdatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_EXPENSEI"), filter.getExpenseItemUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<ExpenseItem> data = pageQuery.executeAndFetch(ExpenseItem.class);

     return new ExpenseItemPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "expenseItemAmount","expenseItemCategory","expenseItemClaimId",System.getenv("API_KEY_EXPENSEI"),System.getenv("API_KEY_EXPENSEI"),"expenseItemId",System.getenv("API_KEY_EXPENSEI"),"expenseItemStatus",System.getenv("API_KEY_EXPENSEI")
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
