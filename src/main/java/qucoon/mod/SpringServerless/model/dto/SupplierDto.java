package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Supplier;


@Data
public class SupplierDto  {

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

public static SupplierDto from(Supplier p) {
    SupplierDto dto = new SupplierDto();

    dto.setSupplierAddress(p.getSupplierAddress());
    dto.setSupplierContactPerson(p.getSupplierContactPerson());
    dto.setSupplierCreatedAt(p.getSupplierCreatedAt());
    dto.setSupplierCreatedByUserId(p.getSupplierCreatedByUserId());
    dto.setSupplierEmail(p.getSupplierEmail());
    dto.setSupplierId(p.getSupplierId());
    dto.setSupplierName(p.getSupplierName());
    dto.setSupplierPhoneNumber(p.getSupplierPhoneNumber());
    dto.setSupplierStatus(p.getSupplierStatus());
    dto.setSupplierUpdatedAt(p.getSupplierUpdatedAt());
    return dto;
   }
}
