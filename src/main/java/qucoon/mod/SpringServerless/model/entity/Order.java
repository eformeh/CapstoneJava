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
public class Order  {
@Column(type="DateTime",nullable=true )
public String  orderActualDeliveryDate;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  orderCreatedAt;
@Column(type="int",nullable=true )
public int  orderCreatedByUserId;
@Column(type="DateTime",nullable=true )
public String  orderExpectedDeliveryDate;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  orderId;
@Column(type="DateTime",nullable=true )
public String  orderOrderDate;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  orderStatus;
@Column(type="int",nullable=true )
public int  orderSupplierId;
@Column(type="double",nullable=true )
public Double  orderTotalCost;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  orderType;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  orderUpdatedAt;
}
