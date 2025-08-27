package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderUpdateRequest {
public String orderActualDeliveryDate;
public String orderCreatedAt;
public int orderCreatedByUserId;
public String orderExpectedDeliveryDate;
public int orderId;
public String orderOrderDate;
public String orderStatus;
public int orderSupplierId;
public Double orderTotalCost;
public String orderType;
public String orderUpdatedAt;
}
