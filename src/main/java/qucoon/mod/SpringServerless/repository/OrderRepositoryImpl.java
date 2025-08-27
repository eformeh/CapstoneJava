
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
public class OrderRepositoryImpl implements OrderRepository {

    private final Environment environment;

    @Autowired
    public OrderRepositoryImpl( Environment environment) {
       this.environment = environment;
    }
    @Override
    public int create(Order  order) {
        assert environment.getDatabaseUtil().getSql2oConnection() != null;
        int orderId = createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(), OrderQuery.INSERT, true)
                .bind (order)
                .executeUpdate()
                .getKey(int.class);


        return orderId;
    }

    @Override
    public void bulkCreate(List<Order> orders) {
        try (var connection = environment.getDatabaseUtil().getSql2o().beginTransaction()) {
            var query = createQueryWithoutOnMappingFailure(connection,OrderQuery.INSERT, false);
            for (Order order : orders) {
                query.bind(order).addToBatch();
            }
            query.executeBatch();
            connection.commit();
        }
    }

    @Override
    public int update(Order order) {
       return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderQuery.UPDATE, true)
                .bind (order)
                .executeUpdate()
                .getResult();
    }

    @Override
    public int delete(int orderId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderQuery.DELETE, true)
                .addParameter("orderId", orderId)
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
                    .execute(OrderQuery.TRUNCATE);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Order> read() {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderQuery.READ, true)
                .executeAndFetch(Order.class);
    }
    @Override
    public List<Order> readByOrderActualDeliveryDate(String orderActualDeliveryDate) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderQuery.READ_BY_ORDER_ORDERACTUALDELIVERYDATE, true)
                .addParameter(System.getenv("API_KEY_ORDERACT"), orderActualDeliveryDate)
                .executeAndFetch(Order.class);
    }
    @Override
    public List<Order> readByOrderCreatedAt(String orderCreatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderQuery.READ_BY_ORDER_ORDERCREATEDAT, true)
                .addParameter("orderCreatedAt", orderCreatedAt)
                .executeAndFetch(Order.class);
    }
    @Override
    public List<Order> readByOrderCreatedByUserId(int orderCreatedByUserId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderQuery.READ_BY_ORDER_ORDERCREATEDBYUSERID, true)
                .addParameter(System.getenv("API_KEY_ORDERCRE"), orderCreatedByUserId)
                .executeAndFetch(Order.class);
    }
    @Override
    public List<Order> readByOrderExpectedDeliveryDate(String orderExpectedDeliveryDate) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderQuery.READ_BY_ORDER_ORDEREXPECTEDDELIVERYDATE, true)
                .addParameter(System.getenv("API_KEY_ORDEREXP"), orderExpectedDeliveryDate)
                .executeAndFetch(Order.class);
    }
    @Override
    public Order readByOrderId(int orderId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderQuery.READ_BY_ORDER_ORDERID, true)
                .addParameter("orderId", orderId)
                .executeAndFetch (Order.class)
                .stream()
                .findFirst()
                .orElse(null);
    }
    @Override
    public List<Order> readByOrderOrderDate(String orderOrderDate) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderQuery.READ_BY_ORDER_ORDERORDERDATE, true)
                .addParameter("orderOrderDate", orderOrderDate)
                .executeAndFetch(Order.class);
    }
    @Override
    public List<Order> readByOrderStatus(String orderStatus) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderQuery.READ_BY_ORDER_ORDERSTATUS, true)
                .addParameter("orderStatus", orderStatus)
                .executeAndFetch(Order.class);
    }
    @Override
    public List<Order> readByOrderSupplierId(int orderSupplierId) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderQuery.READ_BY_ORDER_ORDERSUPPLIERID, true)
                .addParameter("orderSupplierId", orderSupplierId)
                .executeAndFetch(Order.class);
    }
    @Override
    public List<Order> readByOrderTotalCost(Double orderTotalCost) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderQuery.READ_BY_ORDER_ORDERTOTALCOST, true)
                .addParameter("orderTotalCost", orderTotalCost)
                .executeAndFetch(Order.class);
    }
    @Override
    public List<Order> readByOrderType(String orderType) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderQuery.READ_BY_ORDER_ORDERTYPE, true)
                .addParameter("orderType", orderType)
                .executeAndFetch(Order.class);
    }
    @Override
    public List<Order> readByOrderUpdatedAt(String orderUpdatedAt) {
        return createQueryWithoutOnMappingFailure(environment.getDatabaseUtil().getSql2oConnection(),OrderQuery.READ_BY_ORDER_ORDERUPDATEDAT, true)
                .addParameter("orderUpdatedAt", orderUpdatedAt)
                .executeAndFetch(Order.class);
    }

@Override
public OrderPage findOrder(OrderFilterRequest filter) {
    // Build base SQL with non-deleted check
    StringBuilder baseSql = new StringBuilder(OrderQuery.READ);

    // Dynamic filters

    if (filter.getOrderActualDeliveryDate() != null) {   baseSql.append(" AND orderActualDeliveryDate = :orderActualDeliveryDate"); }
    if (filter.getOrderCreatedAt() != null) {   baseSql.append(" AND orderCreatedAt = :orderCreatedAt"); }
    if (filter.getOrderCreatedByUserId() != null) {   baseSql.append(" AND orderCreatedByUserId = :orderCreatedByUserId"); }
    if (filter.getOrderExpectedDeliveryDate() != null) {   baseSql.append(" AND orderExpectedDeliveryDate = :orderExpectedDeliveryDate"); }
    if (filter.getOrderId() != null) {   baseSql.append(" AND orderId = :orderId"); }
    if (filter.getOrderOrderDate() != null) {   baseSql.append(" AND orderOrderDate = :orderOrderDate"); }
    if (filter.getOrderStatus() != null) {   baseSql.append(" AND orderStatus = :orderStatus"); }
    if (filter.getOrderSupplierId() != null) {   baseSql.append(" AND orderSupplierId = :orderSupplierId"); }
    if (filter.getOrderTotalCost() != null) {   baseSql.append(" AND orderTotalCost = :orderTotalCost"); }
    if (filter.getOrderType() != null) {   baseSql.append(" AND orderType = :orderType"); }
    if (filter.getOrderUpdatedAt() != null) {   baseSql.append(" AND orderUpdatedAt = :orderUpdatedAt"); }
if (filter.getSearch() != null) {
   baseSql.append(" & searchKeyParam & ");
    }

     // Count total records
     String countSql = "SELECT COUNT(*) FROM (" + baseSql + ") t";
     var countQuery = createQueryWithoutOnMappingFailure(
             environment.getDatabaseUtil().getSql2oConnection(),
             countSql,
             true);

     if (filter.getOrderActualDeliveryDate() != null) countQuery.addParameter(System.getenv("API_KEY_ORDERACT"), filter.getOrderActualDeliveryDate());
     if (filter.getOrderCreatedAt() != null) countQuery.addParameter("orderCreatedAt", filter.getOrderCreatedAt());
     if (filter.getOrderCreatedByUserId() != null) countQuery.addParameter(System.getenv("API_KEY_ORDERCRE"), filter.getOrderCreatedByUserId());
     if (filter.getOrderExpectedDeliveryDate() != null) countQuery.addParameter(System.getenv("API_KEY_ORDEREXP"), filter.getOrderExpectedDeliveryDate());
     if (filter.getOrderId() != null) countQuery.addParameter("orderId", filter.getOrderId());
     if (filter.getOrderOrderDate() != null) countQuery.addParameter("orderOrderDate", filter.getOrderOrderDate());
     if (filter.getOrderStatus() != null) countQuery.addParameter("orderStatus", filter.getOrderStatus());
     if (filter.getOrderSupplierId() != null) countQuery.addParameter("orderSupplierId", filter.getOrderSupplierId());
     if (filter.getOrderTotalCost() != null) countQuery.addParameter("orderTotalCost", filter.getOrderTotalCost());
     if (filter.getOrderType() != null) countQuery.addParameter("orderType", filter.getOrderType());
     if (filter.getOrderUpdatedAt() != null) countQuery.addParameter("orderUpdatedAt", filter.getOrderUpdatedAt());
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

    if (filter.getOrderActualDeliveryDate() != null) pageQuery.addParameter(System.getenv("API_KEY_ORDERACT"), filter.getOrderActualDeliveryDate());
    if (filter.getOrderCreatedAt() != null) pageQuery.addParameter("orderCreatedAt", filter.getOrderCreatedAt());
    if (filter.getOrderCreatedByUserId() != null) pageQuery.addParameter(System.getenv("API_KEY_ORDERCRE"), filter.getOrderCreatedByUserId());
    if (filter.getOrderExpectedDeliveryDate() != null) pageQuery.addParameter(System.getenv("API_KEY_ORDEREXP"), filter.getOrderExpectedDeliveryDate());
    if (filter.getOrderId() != null) pageQuery.addParameter("orderId", filter.getOrderId());
    if (filter.getOrderOrderDate() != null) pageQuery.addParameter("orderOrderDate", filter.getOrderOrderDate());
    if (filter.getOrderStatus() != null) pageQuery.addParameter("orderStatus", filter.getOrderStatus());
    if (filter.getOrderSupplierId() != null) pageQuery.addParameter("orderSupplierId", filter.getOrderSupplierId());
    if (filter.getOrderTotalCost() != null) pageQuery.addParameter("orderTotalCost", filter.getOrderTotalCost());
    if (filter.getOrderType() != null) pageQuery.addParameter("orderType", filter.getOrderType());
    if (filter.getOrderUpdatedAt() != null) pageQuery.addParameter("orderUpdatedAt", filter.getOrderUpdatedAt());
     if (filter.getSearch() != null) pageQuery.addParameter("search", "%" + filter.getSearch() + "%");
     pageQuery.addParameter("limit", filter.getPageSize());
     pageQuery.addParameter("offset", filter.getPageNumber() * filter.getPageSize());
     List<Order> data = pageQuery.executeAndFetch(Order.class);

     return new OrderPage(data, total);
 }
       private String sanitizeSortBy(String sortBy) {
       // Whitelist allowed sort columns to prevent SQL injection
       Set<String> allowedColumns = new HashSet<>(Arrays.asList(
          System.getenv("API_KEY_ORDERACT"),"orderCreatedAt",System.getenv("API_KEY_ORDERCRE"),System.getenv("API_KEY_ORDEREXP"),"orderId","orderOrderDate","orderStatus","orderSupplierId","orderTotalCost","orderType","orderUpdatedAt"
       ));
       
       return allowedColumns.contains(sortBy) ? sortBy : "1";
   }
}
