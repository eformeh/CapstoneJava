package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.SaleItem;


@Data
public class SaleItemDto  {

private String saleItemCreatedAt;
private Integer saleItemId;
private Integer saleItemProductId;
private Integer saleItemQuantity;
private Integer saleItemSaleId;
private String saleItemStatus;
private Double saleItemTotal;
private Double saleItemUnitPrice;
private String saleItemUpdatedAt;

public static SaleItemDto from(SaleItem p) {
    SaleItemDto dto = new SaleItemDto();

    dto.setSaleItemCreatedAt(p.getSaleItemCreatedAt());
    dto.setSaleItemId(p.getSaleItemId());
    dto.setSaleItemProductId(p.getSaleItemProductId());
    dto.setSaleItemQuantity(p.getSaleItemQuantity());
    dto.setSaleItemSaleId(p.getSaleItemSaleId());
    dto.setSaleItemStatus(p.getSaleItemStatus());
    dto.setSaleItemTotal(p.getSaleItemTotal());
    dto.setSaleItemUnitPrice(p.getSaleItemUnitPrice());
    dto.setSaleItemUpdatedAt(p.getSaleItemUpdatedAt());
    return dto;
   }
}
