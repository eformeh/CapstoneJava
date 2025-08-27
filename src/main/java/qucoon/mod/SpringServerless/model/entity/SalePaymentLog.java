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
public class SalePaymentLog  {
@Column(type="double",nullable=true )
public Double  salePaymentLogAmount;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  salePaymentLogCreatedAt;
@Column(type="int",nullable=true )
public int  salePaymentLogEmployeeid;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  salePaymentLogid;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  salePaymentLogMethod;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  salePaymentLogNotes;
@Column(type="int",nullable=true )
public int  salePaymentLogSaleid;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  salePaymentLogStatus;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  salePaymentUpdatedAt;
}
