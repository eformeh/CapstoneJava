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
public class LeaveType  {
@Column(type="double",nullable=true )
public Double  leaveTypeAccrualRatePerMonth;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  leaveTypeCreatedAt;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  leaveTypeDescription;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  leaveTypeId;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  leaveTypeName;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  leaveTypeResetPolicy;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  leaveTypeStatus;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  leaveTypeUpdatedAt;
}
