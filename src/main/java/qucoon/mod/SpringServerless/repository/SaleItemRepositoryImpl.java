
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
public class SaleItemRepositoryImpl implements SaleItemRepository {

    private final Environment environment;

    @Autowired
    public SaleItemRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(SaleItem  saleitem) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int saleItemId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), SaleItemQuery.INSERT, true)
                .bind (saleitem)
                .executeUpdate()
                .getKey(int.class);


        return saleItemId;
    }

    @Override
    public void bulkCreate(List<SaleItem> saleitems) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,SaleItemQuery.INSERT, false);
            for (SaleItem saleitem : saleitems) {
                query.bind(saleitem).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(SaleItem saleitem) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleItemQuery.UPDATE, true)
                .bind (saleitem)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int saleItemId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleItemQuery.DELETE, true)
                .addParameter("saleItemId", saleItemId)
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
                    .execute(SaleItemQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<SaleItem> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleItemQuery.READ, true)
                .executeAndFetch(SaleItem.class);
    }
    @Override
    public List<SaleItem> readBySaleItemCreatedAt(String saleItemCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleItemQuery.READ_BY_SALE_ITEM_SALEITEMCREATEDAT, true)
                .addParameter("saleItemCreatedAt", saleItemCreatedAt)
                .executeAndFetch(SaleItem.class);
    }
    @Override
    public SaleItem readBySaleItemId(int saleItemId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleItemQuery.READ_BY_SALE_ITEM_SALEITEMID, true)
                .addParameter("saleItemId", saleItemId)
                .executeAndFetch (SaleItem.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<SaleItem> readBySaleItemProductId(int saleItemProductId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleItemQuery.READ_BY_SALE_ITEM_SALEITEMPRODUCTID, true)
                .addParameter("saleItemProductId", saleItemProductId)
                .executeAndFetch(SaleItem.class);
    }
    @Override
    public List<SaleItem> readBySaleItemQuantity(int saleItemQuantity) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleItemQuery.READ_BY_SALE_ITEM_SALEITEMQUANTITY, true)
                .addParameter("saleItemQuantity", saleItemQuantity)
                .executeAndFetch(SaleItem.class);
    }
    @Override
    public List<SaleItem> readBySaleItemSaleId(int saleItemSaleId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleItemQuery.READ_BY_SALE_ITEM_SALEITEMSALEID, true)
                .addParameter("saleItemSaleId", saleItemSaleId)
                .executeAndFetch(SaleItem.class);
    }
    @Override
    public List<SaleItem> readBySaleItemStatus(String saleItemStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleItemQuery.READ_BY_SALE_ITEM_SALEITEMSTATUS, true)
                .addParameter("saleItemStatus", saleItemStatus)
                .executeAndFetch(SaleItem.class);
    }
    @Override
    public List<SaleItem> readBySaleItemTotal(Double saleItemTotal) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleItemQuery.READ_BY_SALE_ITEM_SALEITEMTOTAL, true)
                .addParameter("saleItemTotal", saleItemTotal)
                .executeAndFetch(SaleItem.class);
    }
    @Override
    public List<SaleItem> readBySaleItemUnitPrice(Double saleItemUnitPrice) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleItemQuery.READ_BY_SALE_ITEM_SALEITEMUNITPRICE, true)
                .addParameter("saleItemUnitPrice", saleItemUnitPrice)
                .executeAndFetch(SaleItem.class);
    }
    @Override
    public List<SaleItem> readBySaleItemUpdatedAt(String saleItemUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),SaleItemQuery.READ_BY_SALE_ITEM_SALEITEMUPDATEDAT, true)
                .addParameter("saleItemUpdatedAt", saleItemUpdatedAt)
                .executeAndFetch(SaleItem.class);
    }

@Override
public SaleItemPage findSaleItem(SaleItemFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(SaleItemQuery.READ);

    // Dynamic filters

    if (filter.getSaleItemCreatedAt() != null) {   baseSql.append(" AND saleItemCreatedAt = :saleItemCreatedAt"); }
    if (filter.getSaleItemId() != null) {   baseSql.append(" AND saleItemId = :saleItemId"); }
    if (filter.getSaleItemProductId() != null) {   baseSql.append(" AND saleItemProductId = :saleItemProductId"); }
    if (filter.getSaleItemQuantity() != null) {   baseSql.append(" AND saleItemQuantity = :saleItemQuantity"); }
    if (filter.getSaleItemSaleId() != null) {   baseSql.append(" AND saleItemSaleId = :saleItemSaleId"); }
    if (filter.getSaleItemStatus() != null) {   baseSql.append(" AND saleItemStatus = :saleItemStatus"); }
    if (filter.getSaleItemTotal() != null) {   baseSql.append(" AND saleItemTotal = :saleItemTotal"); }
    if (filter.getSaleItemUnitPrice() != null) {   baseSql.append(" AND saleItemUnitPrice = :saleItemUnitPrice"); }
    if (filter.getSaleItemUpdatedAt() != null) {   baseSql.append(" AND saleItemUpdatedAt = :saleItemUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getSaleItemCreatedAt() != null) countQuery.addParameter("saleItemCreatedAt", filter.getSaleItemCreatedAt());
     if (filter.getSaleItemId() != null) countQuery.addParameter("saleItemId", filter.getSaleItemId());
     if (filter.getSaleItemProductId() != null) countQuery.addParameter("saleItemProductId", filter.getSaleItemProductId());
     if (filter.getSaleItemQuantity() != null) countQuery.addParameter("saleItemQuantity", filter.getSaleItemQuantity());
     if (filter.getSaleItemSaleId() != null) countQuery.addParameter("saleItemSaleId", filter.getSaleItemSaleId());
     if (filter.getSaleItemStatus() != null) countQuery.addParameter("saleItemStatus", filter.getSaleItemStatus());
     if (filter.getSaleItemTotal() != null) countQuery.addParameter("saleItemTotal", filter.getSaleItemTotal());
     if (filter.getSaleItemUnitPrice() != null) countQuery.addParameter("saleItemUnitPrice", filter.getSaleItemUnitPrice());
     if (filter.getSaleItemUpdatedAt() != null) countQuery.addParameter("saleItemUpdatedAt", filter.getSaleItemUpdatedAt());
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

    if (filter.getSaleItemCreatedAt() != null) pageQuery.addParameter("saleItemCreatedAt", filter.getSaleItemCreatedAt());
    if (filter.getSaleItemId() != null) pageQuery.addParameter("saleItemId", filter.getSaleItemId());
    if (filter.getSaleItemProductId() != null) pageQuery.addParameter("saleItemProductId", filter.getSaleItemProductId());
    if (filter.getSaleItemQuantity() != null) pageQuery.addParameter("saleItemQuantity", filter.getSaleItemQuantity());
    if (filter.getSaleItemSaleId() != null) pageQuery.addParameter("saleItemSaleId", filter.getSaleItemSaleId());
    if (filter.getSaleItemStatus() != null) pageQuery.addParameter("saleItemStatus", filter.getSaleItemStatus());
    if (filter.getSaleItemTotal() != null) pageQuery.addParameter("saleItemTotal", filter.getSaleItemTotal());
    if (filter.getSaleItemUnitPrice() != null) pageQuery.addParameter("saleItemUnitPrice", filter.getSaleItemUnitPrice());
    if (filter.getSaleItemUpdatedAt() != null) pageQuery.addParameter("saleItemUpdatedAt", filter.getSaleItemUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<SaleItem> data = pageQuery.executeAndFetch(SaleItem.class);

     return new SaleItemPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "saleItemCreatedAt","saleItemId","saleItemProductId","saleItemQuantity","saleItemSaleId","saleItemStatus","saleItemTotal","saleItemUnitPrice","saleItemUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
