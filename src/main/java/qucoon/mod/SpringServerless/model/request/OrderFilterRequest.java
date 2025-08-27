package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class OrderFilterRequest {

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
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
