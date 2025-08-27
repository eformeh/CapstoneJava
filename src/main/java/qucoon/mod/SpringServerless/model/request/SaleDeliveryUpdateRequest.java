package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SaleDeliveryUpdateRequest {
public String saleDeliveryAddress;
public String saleDeliveryConfirmedAt;
public String saleDeliveryContactName;
public String saleDeliveryContactPhone;
public String saleDeliveryCreatedAt;
public String saleDeliveryExpectedDeliveryDate;
public int saleDeliveryId;
public String saleDeliveryNotes;
public String saleDeliveryProvider;
public int saleDeliverySaleId;
public String saleDeliveryStatus;
public String saleDeliveryTrackingNumber;
public String saleDeliveryUpdatedAt;
}
