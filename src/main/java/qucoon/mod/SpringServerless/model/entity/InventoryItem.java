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
public class InventoryItem  {
@Column(type="int",nullable=true )
public int  inventoryItemAvailableStock;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  inventoryItemCategory;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  inventoryItemCreatedAt;
@Column(type="int",nullable=true )
public int  inventoryItemCurrentStock;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  inventoryItemDescription;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  inventoryItemId;
@Column(type="int",nullable=true )
public int  inventoryItemMinimumStockLevel;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  inventoryItemName;
@Column(type="int",nullable=true )
public int  inventoryItemReservedStock;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  inventoryItemStatus;
@Column(type="double",nullable=true )
public Double  inventoryItemUnitCost;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  inventoryItemUnitOfMeasure;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  inventoryItemUpdatedAt;
}
