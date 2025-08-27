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
public class Sale  {
@Column(type="double",nullable=true )
public Double  saleAmountPaid;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  saleCreatedAt;
@Column(type="DateTime",nullable=true )
public String  saleCreditDue;
@Column(type="int",nullable=true )
public int  saleCustomerId;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  saleDeliveryType;
@Column(type="int",nullable=true )
public int  saleEmployeeId;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  saleId;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  saleStatus;
@Column(type="double",nullable=true )
public Double  saleTotalAmount;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  saleType;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  saleUpdatedAt;
}
