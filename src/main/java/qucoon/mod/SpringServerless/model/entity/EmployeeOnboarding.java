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
public class EmployeeOnboarding  {
@Column(type="int",nullable=true )
public int  employeeOnboardingAssignedBy;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  employeeOnboardingAttachmentUrl;
@Column(type="DateTime",nullable=true )
public String  employeeOnboardingCompletedDate;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  employeeOnboardingCreatedAt;
@Column(type="DateTime",nullable=true )
public String  employeeOnboardingDueDate;
@Column(type="int",nullable=true )
public int  employeeOnboardingEmployeeId;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  employeeOnboardingId;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  employeeOnboardingNotes;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  employeeOnboardingStatus;
@Column(type="int",nullable=true )
public int  employeeOnboardingTaskId;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  employeeOnboardingUpdatedAt;
}
