package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Order;


@Data
public class OrderDto  {

private String orderActualDeliveryDate;
private String orderCreatedAt;
private Integer orderCreatedByUserId;
private String orderExpectedDeliveryDate;
private Integer orderId;
private String orderOrderDate;
private String orderStatus;
private Integer orderSupplierId;
private Double orderTotalCost;
private String orderType;
private String orderUpdatedAt;

public static OrderDto from(Order p) {
    OrderDto dto = new OrderDto();

    dto.setOrderActualDeliveryDate(p.getOrderActualDeliveryDate());
    dto.setOrderCreatedAt(p.getOrderCreatedAt());
    dto.setOrderCreatedByUserId(p.getOrderCreatedByUserId());
    dto.setOrderExpectedDeliveryDate(p.getOrderExpectedDeliveryDate());
    dto.setOrderId(p.getOrderId());
    dto.setOrderOrderDate(p.getOrderOrderDate());
    dto.setOrderStatus(p.getOrderStatus());
    dto.setOrderSupplierId(p.getOrderSupplierId());
    dto.setOrderTotalCost(p.getOrderTotalCost());
    dto.setOrderType(p.getOrderType());
    dto.setOrderUpdatedAt(p.getOrderUpdatedAt());
    return dto;
   }
}
