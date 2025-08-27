package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderItemUpdateRequest {
public String orderItemCreatedAt;
public int orderItemId;
public int orderItemInventoryItemId;
public int orderItemOrderId;
public int orderItemQuantityOrdered;
public String orderItemStatus;
public Double orderItemTotalCost;
public Double orderItemUnitCost;
public String orderItemUpdatedAt;
}
