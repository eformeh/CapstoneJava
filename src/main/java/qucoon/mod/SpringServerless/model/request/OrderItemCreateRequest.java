package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class OrderItemCreateRequest {
@NotNull(message = "orderItemInventoryItemId is required")
public int orderItemInventoryItemId;
@NotNull(message = "orderItemOrderId is required")
public int orderItemOrderId;
@NotNull(message = "orderItemQuantityOrdered is required")
public int orderItemQuantityOrdered;
public Double orderItemTotalCost;
public Double orderItemUnitCost;
}
