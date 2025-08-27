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
public class ProductionRecord  {
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  productionRecordBatchNumber;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  productionRecordCreatedAt;
@Column(type="int",nullable=true )
public int  productionRecordCreatedByUserId;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  productionRecordDate;
@Column(type="int",nullable=true )
public int  productionRecordFinishedGoodProductId;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  productionRecordId;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  productionRecordStatus;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  productionRecordUpdatedAt;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  supplierPhoneNumber;
}
