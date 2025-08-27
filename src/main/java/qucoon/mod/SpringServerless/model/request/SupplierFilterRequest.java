package qucoon.mod.SpringServerless.model.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SupplierFilterRequest {

private String supplierAddress;
private String supplierContactPerson;
private String supplierCreatedAt;
private Integer supplierCreatedByUserId;
private String supplierEmail;
private Integer supplierId;
private String supplierName;
private String supplierPhoneNumber;
private String supplierStatus;
private String supplierUpdatedAt;
private String sortBy = "1";
private String search;
private int pageNumber = 0;
private int pageSize = 10;
private String sortDir = "DESC";
}
