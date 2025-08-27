package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class OrderCreateRequest {
public String orderActualDeliveryDate;
@NotNull(message = "orderCreatedByUserId is required")
public int orderCreatedByUserId;
public String orderExpectedDeliveryDate;
public String orderOrderDate;
@NotNull(message = "orderSupplierId is required")
public int orderSupplierId;
public Double orderTotalCost;
public String orderType;
}
