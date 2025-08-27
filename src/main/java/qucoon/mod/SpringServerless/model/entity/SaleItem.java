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
public class SaleItem  {
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  saleItemCreatedAt;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  saleItemId;
@Column(type="int",nullable=true )
public int  saleItemProductId;
@Column(type="int",nullable=true )
public int  saleItemQuantity;
@Column(type="int",nullable=true )
public int  saleItemSaleId;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  saleItemStatus;
@Column(type="double",nullable=true )
public Double  saleItemTotal;
@Column(type="double",nullable=true )
public Double  saleItemUnitPrice;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  saleItemUpdatedAt;
}
