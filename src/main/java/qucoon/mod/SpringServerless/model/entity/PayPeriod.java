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
public class PayPeriod  {
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  payPeriodCreatedAt;
@Column(type="DateTime",nullable=true )
public String  payPeriodEndDate;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  payPeriodId;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  payPeriodName;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  payPeriodPeriodType;
@Column(type="DateTime",nullable=true )
public String  payPeriodStartDate;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  payPeriodStatus;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  payPeriodUpdatedAt;
}
