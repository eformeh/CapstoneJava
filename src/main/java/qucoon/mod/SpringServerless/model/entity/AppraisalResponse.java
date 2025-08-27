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
public class AppraisalResponse  {
@Column(type="int",nullable=true )
public int  appraisalResponseAppraisalId;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  appraisalResponseCreatedAt;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  appraisalResponseId;
@Column(type="int",nullable=true )
public int  appraisalResponseQuestionId;
@Column(type="double",nullable=true )
public Double  appraisalResponseScore;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  appraisalResponseStatus;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  appraisalResponseUpdatedAt;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  appraisalResponseValue;
}
