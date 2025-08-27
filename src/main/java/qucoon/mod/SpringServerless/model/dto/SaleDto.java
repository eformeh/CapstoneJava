package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Sale;


@Data
public class SaleDto  {

private Double saleAmountPaid;
private String saleCreatedAt;
private String saleCreditDue;
private Integer saleCustomerId;
private String saleDeliveryType;
private Integer saleEmployeeId;
private Integer saleId;
private String saleStatus;
private Double saleTotalAmount;
private String saleType;
private String saleUpdatedAt;

public static SaleDto from(Sale p) {
    SaleDto dto = new SaleDto();

    dto.setSaleAmountPaid(p.getSaleAmountPaid());
    dto.setSaleCreatedAt(p.getSaleCreatedAt());
    dto.setSaleCreditDue(p.getSaleCreditDue());
    dto.setSaleCustomerId(p.getSaleCustomerId());
    dto.setSaleDeliveryType(p.getSaleDeliveryType());
    dto.setSaleEmployeeId(p.getSaleEmployeeId());
    dto.setSaleId(p.getSaleId());
    dto.setSaleStatus(p.getSaleStatus());
    dto.setSaleTotalAmount(p.getSaleTotalAmount());
    dto.setSaleType(p.getSaleType());
    dto.setSaleUpdatedAt(p.getSaleUpdatedAt());
    return dto;
   }
}
