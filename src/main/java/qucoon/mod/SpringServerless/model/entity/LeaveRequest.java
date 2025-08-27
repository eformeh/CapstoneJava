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
public class LeaveRequest  {
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  leaveRequestCreatedAt;
@Column(type="DateTime",nullable=true )
public String  leaveRequestDecisionDate;
@Column(type="int",nullable=true )
public int  leaveRequestEmployeeId;
@Column(type="DateTime",nullable=true )
public String  leaveRequestEndDate;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  leaveRequestId;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  leaveRequestReason;
@Column(type="int",nullable=true )
public int  leaveRequestReviewerId;
@Column(type="DateTime",nullable=true )
public String  leaveRequestStartDate;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  leaveRequestStatus;
@Column(type="DateTime",nullable=true )
public String  leaveRequestSubmittedAt;
@Column(type="int",nullable=true )
public int  leaveRequestTypeId;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  leaveRequestUpdatedAt;
}
