package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class OrderItemFilterRequest {

private String orderItemCreatedAt;
private Integer orderItemId;
private Integer orderItemInventoryItemId;
private Integer orderItemOrderId;
private Integer orderItemQuantityOrdered;
private String orderItemStatus;
private Double orderItemTotalCost;
private Double orderItemUnitCost;
private String orderItemUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
