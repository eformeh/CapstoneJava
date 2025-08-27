package qucoon.mod.SpringServerless.model.entity;


import lombok.Data;
import qucoon.mod.SpringServerless.repository.annotation.Column;
import qucoon.mod.SpringServerless.repository.annotation.Table;
import qucoon.mod.SpringServerless.utility.constant.PrefixConstant;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Date;
import java.time.LocalDateTime;


@Data
@Table
public class Salary  {
@Column(type="double",nullable=true )
public Double  salaryBasicAmount;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  salaryCreatedAt;
@Column(type="int",nullable=true )
public int  salaryEmployeeId;
@Column(type="double",nullable=true )
public Double  salaryGrossPay;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  salaryId;
@Column(type="double",nullable=true )
public Double  salaryNetPay;
@Column(type="int",nullable=true )
public int  salaryPayPeriodId;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  salaryStatus;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  salaryUpdatedAt;
}
