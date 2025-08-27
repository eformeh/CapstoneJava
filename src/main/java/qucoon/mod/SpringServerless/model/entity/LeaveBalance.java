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
public class LeaveBalance  {
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  leaveBalanceCreatedAt;
@Column(type="int",nullable=true )
public int  leaveBalanceEmployeeId;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  leaveBalanceId;
@Column(type="int",nullable=true )
public int  leaveBalanceRemainingDays;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  leaveBalanceStatus;
@Column(type="int",nullable=true )
public int  leaveBalanceTotalDays;
@Column(type="int",nullable=true )
public int  leaveBalanceTypeId;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  leaveBalanceUpdatedAt;
@Column(type="int",nullable=true )
public int  leaveBalanceUsedDays;
}
