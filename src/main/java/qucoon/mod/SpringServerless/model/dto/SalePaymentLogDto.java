package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.SalePaymentLog;


@Data
public class SalePaymentLogDto  {

private Double salePaymentLogAmount;
private String salePaymentLogCreatedAt;
private Integer salePaymentLogEmployeeid;
private Integer salePaymentLogid;
private String salePaymentLogMethod;
private String salePaymentLogNotes;
private Integer salePaymentLogSaleid;
private String salePaymentLogStatus;
private String salePaymentUpdatedAt;

public static SalePaymentLogDto from(SalePaymentLog p) {
    SalePaymentLogDto dto = new SalePaymentLogDto();

    dto.setSalePaymentLogAmount(p.getSalePaymentLogAmount());
    dto.setSalePaymentLogCreatedAt(p.getSalePaymentLogCreatedAt());
    dto.setSalePaymentLogEmployeeid(p.getSalePaymentLogEmployeeid());
    dto.setSalePaymentLogid(p.getSalePaymentLogid());
    dto.setSalePaymentLogMethod(p.getSalePaymentLogMethod());
    dto.setSalePaymentLogNotes(p.getSalePaymentLogNotes());
    dto.setSalePaymentLogSaleid(p.getSalePaymentLogSaleid());
    dto.setSalePaymentLogStatus(p.getSalePaymentLogStatus());
    dto.setSalePaymentUpdatedAt(p.getSalePaymentUpdatedAt());
    return dto;
   }
}
