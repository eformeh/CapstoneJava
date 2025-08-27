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
public class SaleDelivery  {
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  saleDeliveryAddress;
@Column(type="DateTime",nullable=true )
public String  saleDeliveryConfirmedAt;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  saleDeliveryContactName;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  saleDeliveryContactPhone;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  saleDeliveryCreatedAt;
@Column(type="DateTime",nullable=true )
public String  saleDeliveryExpectedDeliveryDate;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  saleDeliveryId;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  saleDeliveryNotes;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  saleDeliveryProvider;
@Column(type="int",nullable=true )
public int  saleDeliverySaleId;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  saleDeliveryStatus;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  saleDeliveryTrackingNumber;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  saleDeliveryUpdatedAt;
}
