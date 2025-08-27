package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.PayPeriod;


@Data
public class PayPeriodDto  {

private String payPeriodCreatedAt;
private String payPeriodEndDate;
private Integer payPeriodId;
private String payPeriodName;
private String payPeriodPeriodType;
private String payPeriodStartDate;
private String payPeriodStatus;
private String payPeriodUpdatedAt;

public static PayPeriodDto from(PayPeriod p) {
    PayPeriodDto dto = new PayPeriodDto();

    dto.setPayPeriodCreatedAt(p.getPayPeriodCreatedAt());
    dto.setPayPeriodEndDate(p.getPayPeriodEndDate());
    dto.setPayPeriodId(p.getPayPeriodId());
    dto.setPayPeriodName(p.getPayPeriodName());
    dto.setPayPeriodPeriodType(p.getPayPeriodPeriodType());
    dto.setPayPeriodStartDate(p.getPayPeriodStartDate());
    dto.setPayPeriodStatus(p.getPayPeriodStatus());
    dto.setPayPeriodUpdatedAt(p.getPayPeriodUpdatedAt());
    return dto;
   }
}
