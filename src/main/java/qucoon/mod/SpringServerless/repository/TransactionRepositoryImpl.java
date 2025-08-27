
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
public class TransactionRepositoryImpl implements TransactionRepository {

    private final Environment environment;

    @Autowired
    public TransactionRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(Transaction  transaction) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int transactionId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), TransactionQuery.INSERT, true)
                .bind (transaction)
                .executeUpdate()
                .getKey(int.class);


        return transactionId;
    }

    @Override
    public void bulkCreate(List<Transaction> transactions) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,TransactionQuery.INSERT, false);
            for (Transaction transaction : transactions) {
                query.bind(transaction).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(Transaction transaction) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),TransactionQuery.UPDATE, true)
                .bind (transaction)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int transactionId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),TransactionQuery.DELETE, true)
                .addParameter("transactionId", transactionId)
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
                    .execute(TransactionQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Transaction> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),TransactionQuery.READ, true)
                .executeAndFetch(Transaction.class);
    }
    @Override
    public List<Transaction> readByTransactionAmount(Double transactionAmount) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),TransactionQuery.READ_BY_TRANSACTION_TRANSACTIONAMOUNT, true)
                .addParameter("transactionAmount", transactionAmount)
                .executeAndFetch(Transaction.class);
    }
    @Override
    public List<Transaction> readByTransactionCreatedAt(String transactionCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),TransactionQuery.READ_BY_TRANSACTION_TRANSACTIONCREATEDAT, true)
                .addParameter(System.getenv("API_KEY_TRANSACT"), transactionCreatedAt)
                .executeAndFetch(Transaction.class);
    }
    @Override
    public List<Transaction> readByTransactionDescription(String transactionDescription) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),TransactionQuery.READ_BY_TRANSACTION_TRANSACTIONDESCRIPTION, true)
                .addParameter(System.getenv("API_KEY_TRANSACT"), transactionDescription)
                .executeAndFetch(Transaction.class);
    }
    @Override
    public Transaction readByTransactionId(int transactionId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),TransactionQuery.READ_BY_TRANSACTION_TRANSACTIONID, true)
                .addParameter("transactionId", transactionId)
                .executeAndFetch (Transaction.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Transaction> readByTransactionNarration(String transactionNarration) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),TransactionQuery.READ_BY_TRANSACTION_TRANSACTIONNARRATION, true)
                .addParameter(System.getenv("API_KEY_TRANSACT"), transactionNarration)
                .executeAndFetch(Transaction.class);
    }
    @Override
    public List<Transaction> readByTransactionReferenceNumber(String transactionReferenceNumber) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),TransactionQuery.READ_BY_TRANSACTION_TRANSACTIONREFERENCENUMBER, true)
                .addParameter(System.getenv("API_KEY_TRANSACT"), transactionReferenceNumber)
                .executeAndFetch(Transaction.class);
    }
    @Override
    public List<Transaction> readByTransactionSourceModule(String transactionSourceModule) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),TransactionQuery.READ_BY_TRANSACTION_TRANSACTIONSOURCEMODULE, true)
                .addParameter(System.getenv("API_KEY_TRANSACT"), transactionSourceModule)
                .executeAndFetch(Transaction.class);
    }
    @Override
    public List<Transaction> readByTransactionSourceReferenceId(int transactionSourceReferenceId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),TransactionQuery.READ_BY_TRANSACTION_TRANSACTIONSOURCEREFERENCEID, true)
                .addParameter(System.getenv("API_KEY_TRANSACT"), transactionSourceReferenceId)
                .executeAndFetch(Transaction.class);
    }
    @Override
    public List<Transaction> readByTransactionStatus(String transactionStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),TransactionQuery.READ_BY_TRANSACTION_TRANSACTIONSTATUS, true)
                .addParameter("transactionStatus", transactionStatus)
                .executeAndFetch(Transaction.class);
    }
    @Override
    public List<Transaction> readByTransactionTransactionCategoryId(int transactionTransactionCategoryId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),TransactionQuery.READ_BY_TRANSACTION_TRANSACTIONTRANSACTIONCATEGORYID, true)
                .addParameter(System.getenv("API_KEY_TRANSACT"), transactionTransactionCategoryId)
                .executeAndFetch(Transaction.class);
    }
    @Override
    public List<Transaction> readByTransactionTransactionDate(String transactionTransactionDate) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),TransactionQuery.READ_BY_TRANSACTION_TRANSACTIONTRANSACTIONDATE, true)
                .addParameter(System.getenv("API_KEY_TRANSACT"), transactionTransactionDate)
                .executeAndFetch(Transaction.class);
    }
    @Override
    public List<Transaction> readByTransactionUpdatedAt(String transactionUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),TransactionQuery.READ_BY_TRANSACTION_TRANSACTIONUPDATEDAT, true)
                .addParameter(System.getenv("API_KEY_TRANSACT"), transactionUpdatedAt)
                .executeAndFetch(Transaction.class);
    }

@Override
public TransactionPage findTransaction(TransactionFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(TransactionQuery.READ);

    // Dynamic filters

    if (filter.getTransactionAmount() != null) {   baseSql.append(" AND transactionAmount = :transactionAmount"); }
    if (filter.getTransactionCreatedAt() != null) {   baseSql.append(" AND transactionCreatedAt = :transactionCreatedAt"); }
    if (filter.getTransactionDescription() != null) {   baseSql.append(" AND transactionDescription = :transactionDescription"); }
    if (filter.getTransactionId() != null) {   baseSql.append(" AND transactionId = :transactionId"); }
    if (filter.getTransactionNarration() != null) {   baseSql.append(" AND transactionNarration = :transactionNarration"); }
    if (filter.getTransactionReferenceNumber() != null) {   baseSql.append(" AND transactionReferenceNumber = :transactionReferenceNumber"); }
    if (filter.getTransactionSourceModule() != null) {   baseSql.append(" AND transactionSourceModule = :transactionSourceModule"); }
    if (filter.getTransactionSourceReferenceId() != null) {   baseSql.append(" AND transactionSourceReferenceId = :transactionSourceReferenceId"); }
    if (filter.getTransactionStatus() != null) {   baseSql.append(" AND transactionStatus = :transactionStatus"); }
    if (filter.getTransactionTransactionCategoryId() != null) {   baseSql.append(" AND transactionTransactionCategoryId = :transactionTransactionCategoryId"); }
    if (filter.getTransactionTransactionDate() != null) {   baseSql.append(" AND transactionTransactionDate = :transactionTransactionDate"); }
    if (filter.getTransactionUpdatedAt() != null) {   baseSql.append(" AND transactionUpdatedAt = :transactionUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getTransactionAmount() != null) countQuery.addParameter("transactionAmount", filter.getTransactionAmount());
     if (filter.getTransactionCreatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_TRANSACT"), filter.getTransactionCreatedAt());
     if (filter.getTransactionDescription() != null) countQuery.addParameter(System.getenv("API_KEY_TRANSACT"), filter.getTransactionDescription());
     if (filter.getTransactionId() != null) countQuery.addParameter("transactionId", filter.getTransactionId());
     if (filter.getTransactionNarration() != null) countQuery.addParameter(System.getenv("API_KEY_TRANSACT"), filter.getTransactionNarration());
     if (filter.getTransactionReferenceNumber() != null) countQuery.addParameter(System.getenv("API_KEY_TRANSACT"), filter.getTransactionReferenceNumber());
     if (filter.getTransactionSourceModule() != null) countQuery.addParameter(System.getenv("API_KEY_TRANSACT"), filter.getTransactionSourceModule());
     if (filter.getTransactionSourceReferenceId() != null) countQuery.addParameter(System.getenv("API_KEY_TRANSACT"), filter.getTransactionSourceReferenceId());
     if (filter.getTransactionStatus() != null) countQuery.addParameter("transactionStatus", filter.getTransactionStatus());
     if (filter.getTransactionTransactionCategoryId() != null) countQuery.addParameter(System.getenv("API_KEY_TRANSACT"), filter.getTransactionTransactionCategoryId());
     if (filter.getTransactionTransactionDate() != null) countQuery.addParameter(System.getenv("API_KEY_TRANSACT"), filter.getTransactionTransactionDate());
     if (filter.getTransactionUpdatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_TRANSACT"), filter.getTransactionUpdatedAt());
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

    if (filter.getTransactionAmount() != null) pageQuery.addParameter("transactionAmount", filter.getTransactionAmount());
    if (filter.getTransactionCreatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_TRANSACT"), filter.getTransactionCreatedAt());
    if (filter.getTransactionDescription() != null) pageQuery.addParameter(System.getenv("API_KEY_TRANSACT"), filter.getTransactionDescription());
    if (filter.getTransactionId() != null) pageQuery.addParameter("transactionId", filter.getTransactionId());
    if (filter.getTransactionNarration() != null) pageQuery.addParameter(System.getenv("API_KEY_TRANSACT"), filter.getTransactionNarration());
    if (filter.getTransactionReferenceNumber() != null) pageQuery.addParameter(System.getenv("API_KEY_TRANSACT"), filter.getTransactionReferenceNumber());
    if (filter.getTransactionSourceModule() != null) pageQuery.addParameter(System.getenv("API_KEY_TRANSACT"), filter.getTransactionSourceModule());
    if (filter.getTransactionSourceReferenceId() != null) pageQuery.addParameter(System.getenv("API_KEY_TRANSACT"), filter.getTransactionSourceReferenceId());
    if (filter.getTransactionStatus() != null) pageQuery.addParameter("transactionStatus", filter.getTransactionStatus());
    if (filter.getTransactionTransactionCategoryId() != null) pageQuery.addParameter(System.getenv("API_KEY_TRANSACT"), filter.getTransactionTransactionCategoryId());
    if (filter.getTransactionTransactionDate() != null) pageQuery.addParameter(System.getenv("API_KEY_TRANSACT"), filter.getTransactionTransactionDate());
    if (filter.getTransactionUpdatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_TRANSACT"), filter.getTransactionUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<Transaction> data = pageQuery.executeAndFetch(Transaction.class);

     return new TransactionPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "transactionAmount",System.getenv("API_KEY_TRANSACT"),System.getenv("API_KEY_TRANSACT"),"transactionId",System.getenv("API_KEY_TRANSACT"),System.getenv("API_KEY_TRANSACT"),System.getenv("API_KEY_TRANSACT"),System.getenv("API_KEY_TRANSACT"),"transactionStatus",System.getenv("API_KEY_TRANSACT"),System.getenv("API_KEY_TRANSACT"),System.getenv("API_KEY_TRANSACT")
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
