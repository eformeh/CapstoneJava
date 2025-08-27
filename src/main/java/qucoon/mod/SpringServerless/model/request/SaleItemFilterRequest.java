package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SaleItemFilterRequest {

private String saleItemCreatedAt;
private Integer saleItemId;
private Integer saleItemProductId;
private Integer saleItemQuantity;
private Integer saleItemSaleId;
private String saleItemStatus;
private Double saleItemTotal;
private Double saleItemUnitPrice;
private String saleItemUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
