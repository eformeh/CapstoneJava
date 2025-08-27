package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class FinishedGoodDetailsReadRequest {
@NotEmpty(message = "Finishedgooddetailscreatedat is required")
public String finishedGoodDetailsCreatedAt;
@NotEmpty(message = "Finishedgooddetailsexpirydate is required")
public String finishedGoodDetailsExpiryDate;
@NotEmpty(message = "Finishedgooddetailsid is required")
public int finishedGoodDetailsId;
@NotEmpty(message = "Finishedgooddetailsinventoryitemid is required")
public int finishedGoodDetailsInventoryItemId;
@NotEmpty(message = "Finishedgooddetailsmanufacturingdate is required")
public String finishedGoodDetailsManufacturingDate;
@NotEmpty(message = "Finishedgooddetailsproductid is required")
public int finishedGoodDetailsProductId;
@NotEmpty(message = "Finishedgooddetailsstatus is required")
public String finishedGoodDetailsStatus;
@NotEmpty(message = "Finishedgooddetailsupdatedat is required")
public String finishedGoodDetailsUpdatedAt;
}
