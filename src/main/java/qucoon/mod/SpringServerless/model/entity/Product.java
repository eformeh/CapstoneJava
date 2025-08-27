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
public class Product  {
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  productBarcode;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  productCategory;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  productCreatedAt;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  productDescription;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  productId;
@Column(type="int",nullable=true )
public int  productMinimumThreshold;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  productName;
@Column(type="double",nullable=true )
public Double  productPrice;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  productSKU;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  productStatus;
@Column(type="int",nullable=true )
public int  productStockQuantity;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  productUpdatedAt;
}
