
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
public class InventoryItemRepositoryImpl implements InventoryItemRepository {

    private final Environment environment;

    @Autowired
    public InventoryItemRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(InventoryItem  inventoryitem) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int inventoryItemId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), InventoryItemQuery.INSERT, true)
                .bind (inventoryitem)
                .executeUpdate()
                .getKey(int.class);


        return inventoryItemId;
    }

    @Override
    public void bulkCreate(List<InventoryItem> inventoryitems) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,InventoryItemQuery.INSERT, false);
            for (InventoryItem inventoryitem : inventoryitems) {
                query.bind(inventoryitem).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(InventoryItem inventoryitem) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),InventoryItemQuery.UPDATE, true)
                .bind (inventoryitem)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int inventoryItemId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),InventoryItemQuery.DELETE, true)
                .addParameter("inventoryItemId", inventoryItemId)
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
                    .execute(InventoryItemQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<InventoryItem> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),InventoryItemQuery.READ, true)
                .executeAndFetch(InventoryItem.class);
    }
    @Override
    public List<InventoryItem> readByInventoryItemAvailableStock(int inventoryItemAvailableStock) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),InventoryItemQuery.READ_BY_INVENTORY_ITEM_INVENTORYITEMAVAILABLESTOCK, true)
                .addParameter(System.getenv("API_KEY_INVENTOR"), inventoryItemAvailableStock)
                .executeAndFetch(InventoryItem.class);
    }
    @Override
    public List<InventoryItem> readByInventoryItemCategory(String inventoryItemCategory) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),InventoryItemQuery.READ_BY_INVENTORY_ITEM_INVENTORYITEMCATEGORY, true)
                .addParameter(System.getenv("API_KEY_INVENTOR"), inventoryItemCategory)
                .executeAndFetch(InventoryItem.class);
    }
    @Override
    public List<InventoryItem> readByInventoryItemCreatedAt(String inventoryItemCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),InventoryItemQuery.READ_BY_INVENTORY_ITEM_INVENTORYITEMCREATEDAT, true)
                .addParameter(System.getenv("API_KEY_INVENTOR"), inventoryItemCreatedAt)
                .executeAndFetch(InventoryItem.class);
    }
    @Override
    public List<InventoryItem> readByInventoryItemCurrentStock(int inventoryItemCurrentStock) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),InventoryItemQuery.READ_BY_INVENTORY_ITEM_INVENTORYITEMCURRENTSTOCK, true)
                .addParameter(System.getenv("API_KEY_INVENTOR"), inventoryItemCurrentStock)
                .executeAndFetch(InventoryItem.class);
    }
    @Override
    public List<InventoryItem> readByInventoryItemDescription(String inventoryItemDescription) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),InventoryItemQuery.READ_BY_INVENTORY_ITEM_INVENTORYITEMDESCRIPTION, true)
                .addParameter(System.getenv("API_KEY_INVENTOR"), inventoryItemDescription)
                .executeAndFetch(InventoryItem.class);
    }
    @Override
    public InventoryItem readByInventoryItemId(int inventoryItemId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),InventoryItemQuery.READ_BY_INVENTORY_ITEM_INVENTORYITEMID, true)
                .addParameter("inventoryItemId", inventoryItemId)
                .executeAndFetch (InventoryItem.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<InventoryItem> readByInventoryItemMinimumStockLevel(int inventoryItemMinimumStockLevel) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),InventoryItemQuery.READ_BY_INVENTORY_ITEM_INVENTORYITEMMINIMUMSTOCKLEVEL, true)
                .addParameter(System.getenv("API_KEY_INVENTOR"), inventoryItemMinimumStockLevel)
                .executeAndFetch(InventoryItem.class);
    }
    @Override
    public List<InventoryItem> readByInventoryItemName(String inventoryItemName) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),InventoryItemQuery.READ_BY_INVENTORY_ITEM_INVENTORYITEMNAME, true)
                .addParameter("inventoryItemName", inventoryItemName)
                .executeAndFetch(InventoryItem.class);
    }
    @Override
    public List<InventoryItem> readByInventoryItemReservedStock(int inventoryItemReservedStock) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),InventoryItemQuery.READ_BY_INVENTORY_ITEM_INVENTORYITEMRESERVEDSTOCK, true)
                .addParameter(System.getenv("API_KEY_INVENTOR"), inventoryItemReservedStock)
                .executeAndFetch(InventoryItem.class);
    }
    @Override
    public List<InventoryItem> readByInventoryItemStatus(String inventoryItemStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),InventoryItemQuery.READ_BY_INVENTORY_ITEM_INVENTORYITEMSTATUS, true)
                .addParameter("inventoryItemStatus", inventoryItemStatus)
                .executeAndFetch(InventoryItem.class);
    }
    @Override
    public List<InventoryItem> readByInventoryItemUnitCost(Double inventoryItemUnitCost) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),InventoryItemQuery.READ_BY_INVENTORY_ITEM_INVENTORYITEMUNITCOST, true)
                .addParameter(System.getenv("API_KEY_INVENTOR"), inventoryItemUnitCost)
                .executeAndFetch(InventoryItem.class);
    }
    @Override
    public List<InventoryItem> readByInventoryItemUnitOfMeasure(String inventoryItemUnitOfMeasure) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),InventoryItemQuery.READ_BY_INVENTORY_ITEM_INVENTORYITEMUNITOFMEASURE, true)
                .addParameter(System.getenv("API_KEY_INVENTOR"), inventoryItemUnitOfMeasure)
                .executeAndFetch(InventoryItem.class);
    }
    @Override
    public List<InventoryItem> readByInventoryItemUpdatedAt(String inventoryItemUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),InventoryItemQuery.READ_BY_INVENTORY_ITEM_INVENTORYITEMUPDATEDAT, true)
                .addParameter(System.getenv("API_KEY_INVENTOR"), inventoryItemUpdatedAt)
                .executeAndFetch(InventoryItem.class);
    }

@Override
public InventoryItemPage findInventoryItem(InventoryItemFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(InventoryItemQuery.READ);

    // Dynamic filters

    if (filter.getInventoryItemAvailableStock() != null) {   baseSql.append(" AND inventoryItemAvailableStock = :inventoryItemAvailableStock"); }
    if (filter.getInventoryItemCategory() != null) {   baseSql.append(" AND inventoryItemCategory = :inventoryItemCategory"); }
    if (filter.getInventoryItemCreatedAt() != null) {   baseSql.append(" AND inventoryItemCreatedAt = :inventoryItemCreatedAt"); }
    if (filter.getInventoryItemCurrentStock() != null) {   baseSql.append(" AND inventoryItemCurrentStock = :inventoryItemCurrentStock"); }
    if (filter.getInventoryItemDescription() != null) {   baseSql.append(" AND inventoryItemDescription = :inventoryItemDescription"); }
    if (filter.getInventoryItemId() != null) {   baseSql.append(" AND inventoryItemId = :inventoryItemId"); }
    if (filter.getInventoryItemMinimumStockLevel() != null) {   baseSql.append(" AND inventoryItemMinimumStockLevel = :inventoryItemMinimumStockLevel"); }
    if (filter.getInventoryItemName() != null) {   baseSql.append(" AND inventoryItemName = :inventoryItemName"); }
    if (filter.getInventoryItemReservedStock() != null) {   baseSql.append(" AND inventoryItemReservedStock = :inventoryItemReservedStock"); }
    if (filter.getInventoryItemStatus() != null) {   baseSql.append(" AND inventoryItemStatus = :inventoryItemStatus"); }
    if (filter.getInventoryItemUnitCost() != null) {   baseSql.append(" AND inventoryItemUnitCost = :inventoryItemUnitCost"); }
    if (filter.getInventoryItemUnitOfMeasure() != null) {   baseSql.append(" AND inventoryItemUnitOfMeasure = :inventoryItemUnitOfMeasure"); }
    if (filter.getInventoryItemUpdatedAt() != null) {   baseSql.append(" AND inventoryItemUpdatedAt = :inventoryItemUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getInventoryItemAvailableStock() != null) countQuery.addParameter(System.getenv("API_KEY_INVENTOR"), filter.getInventoryItemAvailableStock());
     if (filter.getInventoryItemCategory() != null) countQuery.addParameter(System.getenv("API_KEY_INVENTOR"), filter.getInventoryItemCategory());
     if (filter.getInventoryItemCreatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_INVENTOR"), filter.getInventoryItemCreatedAt());
     if (filter.getInventoryItemCurrentStock() != null) countQuery.addParameter(System.getenv("API_KEY_INVENTOR"), filter.getInventoryItemCurrentStock());
     if (filter.getInventoryItemDescription() != null) countQuery.addParameter(System.getenv("API_KEY_INVENTOR"), filter.getInventoryItemDescription());
     if (filter.getInventoryItemId() != null) countQuery.addParameter("inventoryItemId", filter.getInventoryItemId());
     if (filter.getInventoryItemMinimumStockLevel() != null) countQuery.addParameter(System.getenv("API_KEY_INVENTOR"), filter.getInventoryItemMinimumStockLevel());
     if (filter.getInventoryItemName() != null) countQuery.addParameter("inventoryItemName", filter.getInventoryItemName());
     if (filter.getInventoryItemReservedStock() != null) countQuery.addParameter(System.getenv("API_KEY_INVENTOR"), filter.getInventoryItemReservedStock());
     if (filter.getInventoryItemStatus() != null) countQuery.addParameter("inventoryItemStatus", filter.getInventoryItemStatus());
     if (filter.getInventoryItemUnitCost() != null) countQuery.addParameter(System.getenv("API_KEY_INVENTOR"), filter.getInventoryItemUnitCost());
     if (filter.getInventoryItemUnitOfMeasure() != null) countQuery.addParameter(System.getenv("API_KEY_INVENTOR"), filter.getInventoryItemUnitOfMeasure());
     if (filter.getInventoryItemUpdatedAt() != null) countQuery.addParameter(System.getenv("API_KEY_INVENTOR"), filter.getInventoryItemUpdatedAt());
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

    if (filter.getInventoryItemAvailableStock() != null) pageQuery.addParameter(System.getenv("API_KEY_INVENTOR"), filter.getInventoryItemAvailableStock());
    if (filter.getInventoryItemCategory() != null) pageQuery.addParameter(System.getenv("API_KEY_INVENTOR"), filter.getInventoryItemCategory());
    if (filter.getInventoryItemCreatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_INVENTOR"), filter.getInventoryItemCreatedAt());
    if (filter.getInventoryItemCurrentStock() != null) pageQuery.addParameter(System.getenv("API_KEY_INVENTOR"), filter.getInventoryItemCurrentStock());
    if (filter.getInventoryItemDescription() != null) pageQuery.addParameter(System.getenv("API_KEY_INVENTOR"), filter.getInventoryItemDescription());
    if (filter.getInventoryItemId() != null) pageQuery.addParameter("inventoryItemId", filter.getInventoryItemId());
    if (filter.getInventoryItemMinimumStockLevel() != null) pageQuery.addParameter(System.getenv("API_KEY_INVENTOR"), filter.getInventoryItemMinimumStockLevel());
    if (filter.getInventoryItemName() != null) pageQuery.addParameter("inventoryItemName", filter.getInventoryItemName());
    if (filter.getInventoryItemReservedStock() != null) pageQuery.addParameter(System.getenv("API_KEY_INVENTOR"), filter.getInventoryItemReservedStock());
    if (filter.getInventoryItemStatus() != null) pageQuery.addParameter("inventoryItemStatus", filter.getInventoryItemStatus());
    if (filter.getInventoryItemUnitCost() != null) pageQuery.addParameter(System.getenv("API_KEY_INVENTOR"), filter.getInventoryItemUnitCost());
    if (filter.getInventoryItemUnitOfMeasure() != null) pageQuery.addParameter(System.getenv("API_KEY_INVENTOR"), filter.getInventoryItemUnitOfMeasure());
    if (filter.getInventoryItemUpdatedAt() != null) pageQuery.addParameter(System.getenv("API_KEY_INVENTOR"), filter.getInventoryItemUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<InventoryItem> data = pageQuery.executeAndFetch(InventoryItem.class);

     return new InventoryItemPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          System.getenv("API_KEY_INVENTOR"),System.getenv("API_KEY_INVENTOR"),System.getenv("API_KEY_INVENTOR"),System.getenv("API_KEY_INVENTOR"),System.getenv("API_KEY_INVENTOR"),"inventoryItemId",System.getenv("API_KEY_INVENTOR"),"inventoryItemName",System.getenv("API_KEY_INVENTOR"),"inventoryItemStatus",System.getenv("API_KEY_INVENTOR"),System.getenv("API_KEY_INVENTOR"),System.getenv("API_KEY_INVENTOR")
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
