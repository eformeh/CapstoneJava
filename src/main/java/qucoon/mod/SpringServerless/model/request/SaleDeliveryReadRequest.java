package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SaleDeliveryReadRequest {
@NotEmpty(message = "Saledeliveryaddress is required")
public String saleDeliveryAddress;
@NotEmpty(message = "Saledeliveryconfirmedat is required")
public String saleDeliveryConfirmedAt;
@NotEmpty(message = "Saledeliverycontactname is required")
public String saleDeliveryContactName;
@NotEmpty(message = "Saledeliverycontactphone is required")
public String saleDeliveryContactPhone;
@NotEmpty(message = "Saledeliverycreatedat is required")
public String saleDeliveryCreatedAt;
@NotEmpty(message = "Saledeliveryexpecteddeliverydate is required")
public String saleDeliveryExpectedDeliveryDate;
@NotEmpty(message = "Saledeliveryid is required")
public int saleDeliveryId;
@NotEmpty(message = "Saledeliverynotes is required")
public String saleDeliveryNotes;
@NotEmpty(message = "Saledeliveryprovider is required")
public String saleDeliveryProvider;
@NotEmpty(message = "Saledeliverysaleid is required")
public int saleDeliverySaleId;
@NotEmpty(message = "Saledeliverystatus is required")
public String saleDeliveryStatus;
@NotEmpty(message = "Saledeliverytrackingnumber is required")
public String saleDeliveryTrackingNumber;
@NotEmpty(message = "Saledeliveryupdatedat is required")
public String saleDeliveryUpdatedAt;
}
