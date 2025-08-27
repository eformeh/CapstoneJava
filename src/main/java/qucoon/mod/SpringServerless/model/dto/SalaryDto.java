package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Salary;


@Data
public class SalaryDto  {

private Double salaryBasicAmount;
private String salaryCreatedAt;
private Integer salaryEmployeeId;
private Double salaryGrossPay;
private Integer salaryId;
private Double salaryNetPay;
private Integer salaryPayPeriodId;
private String salaryStatus;
private String salaryUpdatedAt;

public static SalaryDto from(Salary p) {
    SalaryDto dto = new SalaryDto();

    dto.setSalaryBasicAmount(p.getSalaryBasicAmount());
    dto.setSalaryCreatedAt(p.getSalaryCreatedAt());
    dto.setSalaryEmployeeId(p.getSalaryEmployeeId());
    dto.setSalaryGrossPay(p.getSalaryGrossPay());
    dto.setSalaryId(p.getSalaryId());
    dto.setSalaryNetPay(p.getSalaryNetPay());
    dto.setSalaryPayPeriodId(p.getSalaryPayPeriodId());
    dto.setSalaryStatus(p.getSalaryStatus());
    dto.setSalaryUpdatedAt(p.getSalaryUpdatedAt());
    return dto;
   }
}
