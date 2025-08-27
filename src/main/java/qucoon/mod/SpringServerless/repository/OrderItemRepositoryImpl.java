
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
public class OrderItemRepositoryImpl implements OrderItemRepository {

    private final Environment environment;

    @Autowired
    public OrderItemRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(OrderItem  orderitem) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int orderItemId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), OrderItemQuery.INSERT, true)
                .bind (orderitem)
                .executeUpdate()
                .getKey(int.class);


        return orderItemId;
    }

    @Override
    public void bulkCreate(List<OrderItem> orderitems) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,OrderItemQuery.INSERT, false);
            for (OrderItem orderitem : orderitems) {
                query.bind(orderitem).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(OrderItem orderitem) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderItemQuery.UPDATE, true)
                .bind (orderitem)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int orderItemId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderItemQuery.DELETE, true)
                .addParameter("orderItemId", orderItemId)
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
                    .execute(OrderItemQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<OrderItem> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderItemQuery.READ, true)
                .executeAndFetch(OrderItem.class);
    }
    @Override
    public List<OrderItem> readByOrderItemCreatedAt(String orderItemCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderItemQuery.READ_BY_ORDER_ITEM_ORDERITEMCREATEDAT, true)
                .addParameter("orderItemCreatedAt", orderItemCreatedAt)
                .executeAndFetch(OrderItem.class);
    }
    @Override
    public OrderItem readByOrderItemId(int orderItemId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderItemQuery.READ_BY_ORDER_ITEM_ORDERITEMID, true)
                .addParameter("orderItemId", orderItemId)
                .executeAndFetch (OrderItem.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<OrderItem> readByOrderItemInventoryItemId(int orderItemInventoryItemId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderItemQuery.READ_BY_ORDER_ITEM_ORDERITEMINVENTORYITEMID, true)
                .addParameter(System.getenv("API_KEY_ORDERITE"), orderItemInventoryItemId)
                .executeAndFetch(OrderItem.class);
    }
    @Override
    public List<OrderItem> readByOrderItemOrderId(int orderItemOrderId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderItemQuery.READ_BY_ORDER_ITEM_ORDERITEMORDERID, true)
                .addParameter("orderItemOrderId", orderItemOrderId)
                .executeAndFetch(OrderItem.class);
    }
    @Override
    public List<OrderItem> readByOrderItemQuantityOrdered(int orderItemQuantityOrdered) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderItemQuery.READ_BY_ORDER_ITEM_ORDERITEMQUANTITYORDERED, true)
                .addParameter(System.getenv("API_KEY_ORDERITE"), orderItemQuantityOrdered)
                .executeAndFetch(OrderItem.class);
    }
    @Override
    public List<OrderItem> readByOrderItemStatus(String orderItemStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderItemQuery.READ_BY_ORDER_ITEM_ORDERITEMSTATUS, true)
                .addParameter("orderItemStatus", orderItemStatus)
                .executeAndFetch(OrderItem.class);
    }
    @Override
    public List<OrderItem> readByOrderItemTotalCost(Double orderItemTotalCost) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderItemQuery.READ_BY_ORDER_ITEM_ORDERITEMTOTALCOST, true)
                .addParameter("orderItemTotalCost", orderItemTotalCost)
                .executeAndFetch(OrderItem.class);
    }
    @Override
    public List<OrderItem> readByOrderItemUnitCost(Double orderItemUnitCost) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderItemQuery.READ_BY_ORDER_ITEM_ORDERITEMUNITCOST, true)
                .addParameter("orderItemUnitCost", orderItemUnitCost)
                .executeAndFetch(OrderItem.class);
    }
    @Override
    public List<OrderItem> readByOrderItemUpdatedAt(String orderItemUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderItemQuery.READ_BY_ORDER_ITEM_ORDERITEMUPDATEDAT, true)
                .addParameter("orderItemUpdatedAt", orderItemUpdatedAt)
                .executeAndFetch(OrderItem.class);
    }

@Override
public OrderItemPage findOrderItem(OrderItemFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(OrderItemQuery.READ);

    // Dynamic filters

    if (filter.getOrderItemCreatedAt() != null) {   baseSql.append(" AND orderItemCreatedAt = :orderItemCreatedAt"); }
    if (filter.getOrderItemId() != null) {   baseSql.append(" AND orderItemId = :orderItemId"); }
    if (filter.getOrderItemInventoryItemId() != null) {   baseSql.append(" AND orderItemInventoryItemId = :orderItemInventoryItemId"); }
    if (filter.getOrderItemOrderId() != null) {   baseSql.append(" AND orderItemOrderId = :orderItemOrderId"); }
    if (filter.getOrderItemQuantityOrdered() != null) {   baseSql.append(" AND orderItemQuantityOrdered = :orderItemQuantityOrdered"); }
    if (filter.getOrderItemStatus() != null) {   baseSql.append(" AND orderItemStatus = :orderItemStatus"); }
    if (filter.getOrderItemTotalCost() != null) {   baseSql.append(" AND orderItemTotalCost = :orderItemTotalCost"); }
    if (filter.getOrderItemUnitCost() != null) {   baseSql.append(" AND orderItemUnitCost = :orderItemUnitCost"); }
    if (filter.getOrderItemUpdatedAt() != null) {   baseSql.append(" AND orderItemUpdatedAt = :orderItemUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getOrderItemCreatedAt() != null) countQuery.addParameter("orderItemCreatedAt", filter.getOrderItemCreatedAt());
     if (filter.getOrderItemId() != null) countQuery.addParameter("orderItemId", filter.getOrderItemId());
     if (filter.getOrderItemInventoryItemId() != null) countQuery.addParameter(System.getenv("API_KEY_ORDERITE"), filter.getOrderItemInventoryItemId());
     if (filter.getOrderItemOrderId() != null) countQuery.addParameter("orderItemOrderId", filter.getOrderItemOrderId());
     if (filter.getOrderItemQuantityOrdered() != null) countQuery.addParameter(System.getenv("API_KEY_ORDERITE"), filter.getOrderItemQuantityOrdered());
     if (filter.getOrderItemStatus() != null) countQuery.addParameter("orderItemStatus", filter.getOrderItemStatus());
     if (filter.getOrderItemTotalCost() != null) countQuery.addParameter("orderItemTotalCost", filter.getOrderItemTotalCost());
     if (filter.getOrderItemUnitCost() != null) countQuery.addParameter("orderItemUnitCost", filter.getOrderItemUnitCost());
     if (filter.getOrderItemUpdatedAt() != null) countQuery.addParameter("orderItemUpdatedAt", filter.getOrderItemUpdatedAt());
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

    if (filter.getOrderItemCreatedAt() != null) pageQuery.addParameter("orderItemCreatedAt", filter.getOrderItemCreatedAt());
    if (filter.getOrderItemId() != null) pageQuery.addParameter("orderItemId", filter.getOrderItemId());
    if (filter.getOrderItemInventoryItemId() != null) pageQuery.addParameter(System.getenv("API_KEY_ORDERITE"), filter.getOrderItemInventoryItemId());
    if (filter.getOrderItemOrderId() != null) pageQuery.addParameter("orderItemOrderId", filter.getOrderItemOrderId());
    if (filter.getOrderItemQuantityOrdered() != null) pageQuery.addParameter(System.getenv("API_KEY_ORDERITE"), filter.getOrderItemQuantityOrdered());
    if (filter.getOrderItemStatus() != null) pageQuery.addParameter("orderItemStatus", filter.getOrderItemStatus());
    if (filter.getOrderItemTotalCost() != null) pageQuery.addParameter("orderItemTotalCost", filter.getOrderItemTotalCost());
    if (filter.getOrderItemUnitCost() != null) pageQuery.addParameter("orderItemUnitCost", filter.getOrderItemUnitCost());
    if (filter.getOrderItemUpdatedAt() != null) pageQuery.addParameter("orderItemUpdatedAt", filter.getOrderItemUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<OrderItem> data = pageQuery.executeAndFetch(OrderItem.class);

     return new OrderItemPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          "orderItemCreatedAt","orderItemId",System.getenv("API_KEY_ORDERITE"),"orderItemOrderId",System.getenv("API_KEY_ORDERITE"),"orderItemStatus","orderItemTotalCost","orderItemUnitCost","orderItemUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
