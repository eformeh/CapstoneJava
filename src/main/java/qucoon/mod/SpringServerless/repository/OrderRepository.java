
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.OrderPage;
import qucoon.mod.SpringServerless.model.request.OrderFilterRequest;

import java.util.List;

@Repository
    public interface OrderRepository {


    // Additional query methods can be defined here.
    int create(Order order);
    void bulkCreate(List<Order>  order);
    int update(Order  order);
    int delete(int orderId);
    OrderPage findOrder(OrderFilterRequest filter);
    boolean truncate();
    List<Order> read();
    List<Order> readByOrderActualDeliveryDate(String orderActualDeliveryDate);
    List<Order> readByOrderCreatedAt(String orderCreatedAt);
    List<Order> readByOrderCreatedByUserId(int orderCreatedByUserId);
    List<Order> readByOrderExpectedDeliveryDate(String orderExpectedDeliveryDate);
    Order readByOrderId(int orderId);
    List<Order> readByOrderOrderDate(String orderOrderDate);
    List<Order> readByOrderStatus(String orderStatus);
    List<Order> readByOrderSupplierId(int orderSupplierId);
    List<Order> readByOrderTotalCost(Double orderTotalCost);
    List<Order> readByOrderType(String orderType);
    List<Order> readByOrderUpdatedAt(String orderUpdatedAt);
}
