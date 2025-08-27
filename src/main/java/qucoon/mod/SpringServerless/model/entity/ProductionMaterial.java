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
public class ProductionMaterial  {
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  productionMaterialCreatedAt;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  productionMaterialId;
@Column(type="int",nullable=true )
public int  productionMaterialInventoryItemId;
@Column(type="int",nullable=true )
public int  productionMaterialProductionRecordId;
@Column(type="int",nullable=true )
public int  productionMaterialQuantityConsumed;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  productionMaterialStatus;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  productionMaterialUpdatedAt;
}
