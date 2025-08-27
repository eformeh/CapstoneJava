package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.SaleDelivery;


@Data
public class SaleDeliveryDto  {

private String saleDeliveryAddress;
private String saleDeliveryConfirmedAt;
private String saleDeliveryContactName;
private String saleDeliveryContactPhone;
private String saleDeliveryCreatedAt;
private String saleDeliveryExpectedDeliveryDate;
private Integer saleDeliveryId;
private String saleDeliveryNotes;
private String saleDeliveryProvider;
private Integer saleDeliverySaleId;
private String saleDeliveryStatus;
private String saleDeliveryTrackingNumber;
private String saleDeliveryUpdatedAt;

public static SaleDeliveryDto from(SaleDelivery p) {
    SaleDeliveryDto dto = new SaleDeliveryDto();

    dto.setSaleDeliveryAddress(p.getSaleDeliveryAddress());
    dto.setSaleDeliveryConfirmedAt(p.getSaleDeliveryConfirmedAt());
    dto.setSaleDeliveryContactName(p.getSaleDeliveryContactName());
    dto.setSaleDeliveryContactPhone(p.getSaleDeliveryContactPhone());
    dto.setSaleDeliveryCreatedAt(p.getSaleDeliveryCreatedAt());
    dto.setSaleDeliveryExpectedDeliveryDate(p.getSaleDeliveryExpectedDeliveryDate());
    dto.setSaleDeliveryId(p.getSaleDeliveryId());
    dto.setSaleDeliveryNotes(p.getSaleDeliveryNotes());
    dto.setSaleDeliveryProvider(p.getSaleDeliveryProvider());
    dto.setSaleDeliverySaleId(p.getSaleDeliverySaleId());
    dto.setSaleDeliveryStatus(p.getSaleDeliveryStatus());
    dto.setSaleDeliveryTrackingNumber(p.getSaleDeliveryTrackingNumber());
    dto.setSaleDeliveryUpdatedAt(p.getSaleDeliveryUpdatedAt());
    return dto;
   }
}
