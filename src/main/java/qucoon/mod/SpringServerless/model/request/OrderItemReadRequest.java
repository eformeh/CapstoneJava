package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderItemReadRequest {
@NotEmpty(message = "Orderitemcreatedat is required")
public String orderItemCreatedAt;
@NotEmpty(message = "Orderitemid is required")
public int orderItemId;
@NotEmpty(message = "Orderiteminventoryitemid is required")
public int orderItemInventoryItemId;
@NotEmpty(message = "Orderitemorderid is required")
public int orderItemOrderId;
@NotEmpty(message = "Orderitemquantityordered is required")
public int orderItemQuantityOrdered;
@NotEmpty(message = "Orderitemstatus is required")
public String orderItemStatus;
@NotEmpty(message = "Orderitemtotalcost is required")
public Double orderItemTotalCost;
@NotEmpty(message = "Orderitemunitcost is required")
public Double orderItemUnitCost;
@NotEmpty(message = "Orderitemupdatedat is required")
public String orderItemUpdatedAt;
}
