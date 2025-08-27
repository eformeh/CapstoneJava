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
public class FinishedGoodDetails  {
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  finishedGoodDetailsCreatedAt;
@Column(type="DateTime",nullable=true )
public String  finishedGoodDetailsExpiryDate;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  finishedGoodDetailsId;
@Column(type="int",nullable=true )
public int  finishedGoodDetailsInventoryItemId;
@Column(type="DateTime",nullable=true )
public String  finishedGoodDetailsManufacturingDate;
@Column(type="int",nullable=true )
public int  finishedGoodDetailsProductId;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  finishedGoodDetailsStatus;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  finishedGoodDetailsUpdatedAt;
}
