package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SupplierReadRequest {
@NotEmpty(message = "Supplieraddress is required")
public String supplierAddress;
@NotEmpty(message = "Suppliercontactperson is required")
public String supplierContactPerson;
@NotEmpty(message = "Suppliercreatedat is required")
public String supplierCreatedAt;
@NotEmpty(message = "Suppliercreatedbyuserid is required")
public int supplierCreatedByUserId;
@NotEmpty(message = "Supplieremail is required")
public String supplierEmail;
@NotEmpty(message = "Supplierid is required")
public int supplierId;
@NotEmpty(message = "Suppliername is required")
public String supplierName;
@NotEmpty(message = "Supplierphonenumber is required")
public String supplierPhoneNumber;
@NotEmpty(message = "Supplierstatus is required")
public String supplierStatus;
@NotEmpty(message = "Supplierupdatedat is required")
public String supplierUpdatedAt;
}
