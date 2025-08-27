package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SaleDeliveryFilterRequest {

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
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
