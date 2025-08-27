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
public class Appraisal  {
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  appraisalCreatedAt;
@Column(type="DateTime",nullable=true )
public String  appraisalDate;
@Column(type="int",nullable=true )
public int  appraisalEmployeeIdRoleId;
@Column(type="int",nullable=true )
public int  appraisalFormId;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  appraisalGeneralFeedback;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  appraisalId;
@Column(type="double",nullable=true )
public Double  appraisalOverallScore;
@Column(type="int",nullable=true )
public int  appraisalReviewerId;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  appraisalStatus;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  appraisalUpdatedAt;
}
