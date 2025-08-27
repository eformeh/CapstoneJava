
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.OrderItemPage;
import qucoon.mod.SpringServerless.model.request.OrderItemFilterRequest;

import java.util.List;

@Repository
    public interface OrderItemRepository {


    // Additional query methods can be defined here.
    int create(OrderItem orderitem);
    void bulkCreate(List<OrderItem>  orderitem);
    int update(OrderItem  orderitem);
    int delete(int orderItemId);
    OrderItemPage findOrderItem(OrderItemFilterRequest filter);
    boolean truncate();
    List<OrderItem> read();
    List<OrderItem> readByOrderItemCreatedAt(String orderItemCreatedAt);
    OrderItem readByOrderItemId(int orderItemId);
    List<OrderItem> readByOrderItemInventoryItemId(int orderItemInventoryItemId);
    List<OrderItem> readByOrderItemOrderId(int orderItemOrderId);
    List<OrderItem> readByOrderItemQuantityOrdered(int orderItemQuantityOrdered);
    List<OrderItem> readByOrderItemStatus(String orderItemStatus);
    List<OrderItem> readByOrderItemTotalCost(Double orderItemTotalCost);
    List<OrderItem> readByOrderItemUnitCost(Double orderItemUnitCost);
    List<OrderItem> readByOrderItemUpdatedAt(String orderItemUpdatedAt);
}
