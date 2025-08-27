
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
public class SaleRepositoryImpl implements SaleRepository {

    private final Environment environment;

    @Autowired
    public SaleRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(Sale  sale) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int saleId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), SaleQuery.INSERT, true)
                .bind (sale)
                .executeUpdate()
                .getKey(int.class);


        return saleId;
    }

    @Override
    public void bulkCreate(List<Sale> sales) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,SaleQuery.INSERT, false);
            for (Sale sale : sales) {
                query.bind(sale).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(Sale sale) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleQuery.UPDATE, true)
                .bind (sale)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int saleId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleQuery.DELETE, true)
                .addParameter("saleId", saleId)
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
                    .execute(SaleQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Sale> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleQuery.READ, true)
                .executeAndFetch(Sale.class);
    }
    @Override
    public List<Sale> readBySaleAmountPaid(Double saleAmountPaid) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleQuery.READ_BY_SALE_SALEAMOUNTPAID, true)
                .addParameter("saleAmountPaid", saleAmountPaid)
                .executeAndFetch(Sale.class);
    }
    @Override
    public List<Sale> readBySaleCreatedAt(String saleCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleQuery.READ_BY_SALE_SALECREATEDAT, true)
                .addParameter("saleCreatedAt", saleCreatedAt)
                .executeAndFetch(Sale.class);
    }
    @Override
    public List<Sale> readBySaleCreditDue(String saleCreditDue) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleQuery.READ_BY_SALE_SALECREDITDUE, true)
                .addParameter("saleCreditDue", saleCreditDue)
                .executeAndFetch(Sale.class);
    }
    @Override
    public List<Sale> readBySaleCustomerId(int saleCustomerId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleQuery.READ_BY_SALE_SALECUSTOMERID, true)
                .addParameter("saleCustomerId", saleCustomerId)
                .executeAndFetch(Sale.class);
    }
    @Override
    public List<Sale> readBySaleDeliveryType(String saleDeliveryType) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleQuery.READ_BY_SALE_SALEDELIVERYTYPE, true)
                .addParameter("saleDeliveryType", saleDeliveryType)
                .executeAndFetch(Sale.class);
    }
    @Override
    public List<Sale> readBySaleEmployeeId(int saleEmployeeId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleQuery.READ_BY_SALE_SALEEMPLOYEEID, true)
                .addParameter("saleEmployeeId", saleEmployeeId)
                .executeAndFetch(Sale.class);
    }
    @Override
    public Sale readBySaleId(int saleId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleQuery.READ_BY_SALE_SALEID, true)
                .addParameter("saleId", saleId)
                .executeAndFetch (Sale.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Sale> readBySaleStatus(String saleStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleQuery.READ_BY_SALE_SALESTATUS, true)
                .addParameter("saleStatus", saleStatus)
                .executeAndFetch(Sale.class);
    }
    @Override
    public List<Sale> readBySaleTotalAmount(Double saleTotalAmount) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleQuery.READ_BY_SALE_SALETOTALAMOUNT, true)
                .addParameter("saleTotalAmount", saleTotalAmount)
                .executeAndFetch(Sale.class);
    }
    @Override
    public List<Sale> readBySaleType(String saleType) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleQuery.READ_BY_SALE_SALETYPE, true)
                .addParameter("saleType", saleType)
                .executeAndFetch(Sale.class);
    }
    @Override
    public List<Sale> readBySaleUpdatedAt(String saleUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleQuery.READ_BY_SALE_SALEUPDATEDAT, true)
                .addParameter("saleUpdatedAt", saleUpdatedAt)
                .executeAndFetch(Sale.class);
    }

@Override
public SalePage findSale(SaleFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(SaleQuery.READ);

    // Dynamic filters

    if (filter.getSaleAmountPaid() != null) {   baseSql.append(" AND saleAmountPaid = :saleAmountPaid"); }
    if (filter.getSaleCreatedAt() != null) {   baseSql.append(" AND saleCreatedAt = :saleCreatedAt"); }
    if (filter.getSaleCreditDue() != null) {   baseSql.append(" AND saleCreditDue = :saleCreditDue"); }
    if (filter.getSaleCustomerId() != null) {   baseSql.append(" AND saleCustomerId = :saleCustomerId"); }
    if (filter.getSaleDeliveryType() != null) {   baseSql.append(" AND saleDeliveryType = :saleDeliveryType"); }
    if (filter.getSaleEmployeeId() != null) {   baseSql.append(" AND saleEmployeeId = :saleEmployeeId"); }
    if (filter.getSaleId() != null) {   baseSql.append(" AND saleId = :saleId"); }
    if (filter.getSaleStatus() != null) {   baseSql.append(" AND saleStatus = :saleStatus"); }
    if (filter.getSaleTotalAmount() != null) {   baseSql.append(" AND saleTotalAmount = :saleTotalAmount"); }
    if (filter.getSaleType() != null) {   baseSql.append(" AND saleType = :saleType"); }
    if (filter.getSaleUpdatedAt() != null) {   baseSql.append(" AND saleUpdatedAt = :saleUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getSaleAmountPaid() != null) countQuery.addParameter("saleAmountPaid", filter.getSaleAmountPaid());
     if (filter.getSaleCreatedAt() != null) countQuery.addParameter("saleCreatedAt", filter.getSaleCreatedAt());
     if (filter.getSaleCreditDue() != null) countQuery.addParameter("saleCreditDue", filter.getSaleCreditDue());
     if (filter.getSaleCustomerId() != null) countQuery.addParameter("saleCustomerId", filter.getSaleCustomerId());
     if (filter.getSaleDeliveryType() != null) countQuery.addParameter("saleDeliveryType", filter.getSaleDeliveryType());
     if (filter.getSaleEmployeeId() != null) countQuery.addParameter("saleEmployeeId", filter.getSaleEmployeeId());
     if (filter.getSaleId() != null) countQuery.addParameter("saleId", filter.getSaleId());
     if (filter.getSaleStatus() != null) countQuery.addParameter("saleStatus", filter.getSaleStatus());
     if (filter.getSaleTotalAmount() != null) countQuery.addParameter("saleTotalAmount", filter.getSaleTotalAmount());
     if (filter.getSaleType() != null) countQuery.addParameter("saleType", filter.getSaleType());
     if (filter.getSaleUpdatedAt() != null) countQuery.addParameter("saleUpdatedAt", filter.getSaleUpdatedAt());
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

    if (filter.getSaleAmountPaid() != null) pageQuery.addParameter("saleAmountPaid", filter.getSaleAmountPaid());
    if (filter.getSaleCreatedAt() != null) pageQuery.addParameter("saleCreatedAt", filter.getSaleCreatedAt());
    if (filter.getSaleCreditDue() != null) pageQuery.addParameter("saleCreditDue", filter.getSaleCreditDue());
    if (filter.getSaleCustomerId() != null) pageQuery.addParameter("saleCustomerId", filter.getSaleCustomerId());
    if (filter.getSaleDeliveryType() != null) pageQuery.addParameter("saleDeliveryType", filter.getSaleDeliveryType());
    if (filter.getSaleEmployeeId() != null) pageQuery.addParameter("saleEmployeeId", filter.getSaleEmployeeId());
    if (filter.getSaleId() != null) pageQuery.addParameter("saleId", filter.getSaleId());
    if (filter.getSaleStatus() != null) pageQuery.addParameter("saleStatus", filter.getSaleStatus());
    if (filter.getSaleTotalAmount() != null) pageQuery.addParameter("saleTotalAmount", filter.getSaleTotalAmount());
    if (filter.getSaleType() != null) pageQuery.addParameter("saleType", filter.getSaleType());
    if (filter.getSaleUpdatedAt() != null) pageQuery.addParameter("saleUpdatedAt", filter.getSaleUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<Sale> data = pageQuery.executeAndFetch(Sale.class);

     return new SalePage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "saleAmountPaid","saleCreatedAt","saleCreditDue","saleCustomerId","saleDeliveryType","saleEmployeeId","saleId","saleStatus","saleTotalAmount","saleType","saleUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
