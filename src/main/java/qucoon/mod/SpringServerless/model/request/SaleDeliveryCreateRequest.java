package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@Data
public class SaleDeliveryCreateRequest {
public String saleDeliveryAddress;
public String saleDeliveryConfirmedAt;
public String saleDeliveryContactName;
public String saleDeliveryContactPhone;
public String saleDeliveryExpectedDeliveryDate;
public String saleDeliveryNotes;
public String saleDeliveryProvider;
@NotNull(message = "saleDeliverySaleId is required")
public int saleDeliverySaleId;
public String saleDeliveryTrackingNumber;
}
