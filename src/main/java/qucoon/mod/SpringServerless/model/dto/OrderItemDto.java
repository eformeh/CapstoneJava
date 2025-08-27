package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.OrderItem;


@Data
public class OrderItemDto  {

private String orderItemCreatedAt;
private Integer orderItemId;
private Integer orderItemInventoryItemId;
private Integer orderItemOrderId;
private Integer orderItemQuantityOrdered;
private String orderItemStatus;
private Double orderItemTotalCost;
private Double orderItemUnitCost;
private String orderItemUpdatedAt;

public static OrderItemDto from(OrderItem p) {
    OrderItemDto dto = new OrderItemDto();

    dto.setOrderItemCreatedAt(p.getOrderItemCreatedAt());
    dto.setOrderItemId(p.getOrderItemId());
    dto.setOrderItemInventoryItemId(p.getOrderItemInventoryItemId());
    dto.setOrderItemOrderId(p.getOrderItemOrderId());
    dto.setOrderItemQuantityOrdered(p.getOrderItemQuantityOrdered());
    dto.setOrderItemStatus(p.getOrderItemStatus());
    dto.setOrderItemTotalCost(p.getOrderItemTotalCost());
    dto.setOrderItemUnitCost(p.getOrderItemUnitCost());
    dto.setOrderItemUpdatedAt(p.getOrderItemUpdatedAt());
    return dto;
   }
}
