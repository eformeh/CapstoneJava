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
public class OrderItem  {
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  orderItemCreatedAt;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  orderItemId;
@Column(type="int",nullable=true )
public int  orderItemInventoryItemId;
@Column(type="int",nullable=true )
public int  orderItemOrderId;
@Column(type="int",nullable=true )
public int  orderItemQuantityOrdered;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  orderItemStatus;
@Column(type="double",nullable=true )
public Double  orderItemTotalCost;
@Column(type="double",nullable=true )
public Double  orderItemUnitCost;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  orderItemUpdatedAt;
}
