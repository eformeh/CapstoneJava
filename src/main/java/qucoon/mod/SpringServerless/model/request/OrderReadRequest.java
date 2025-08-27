package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderReadRequest {
@NotEmpty(message = "Orderactualdeliverydate is required")
public String orderActualDeliveryDate;
@NotEmpty(message = "Ordercreatedat is required")
public String orderCreatedAt;
@NotEmpty(message = "Ordercreatedbyuserid is required")
public int orderCreatedByUserId;
@NotEmpty(message = "Orderexpecteddeliverydate is required")
public String orderExpectedDeliveryDate;
@NotEmpty(message = "Orderid is required")
public int orderId;
@NotEmpty(message = "Orderorderdate is required")
public String orderOrderDate;
@NotEmpty(message = "Orderstatus is required")
public String orderStatus;
@NotEmpty(message = "Ordersupplierid is required")
public int orderSupplierId;
@NotEmpty(message = "Ordertotalcost is required")
public Double orderTotalCost;
@NotEmpty(message = "Ordertype is required")
public String orderType;
@NotEmpty(message = "Orderupdatedat is required")
public String orderUpdatedAt;
}
