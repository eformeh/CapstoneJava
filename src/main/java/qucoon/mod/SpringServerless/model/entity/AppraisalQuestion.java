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
public class AppraisalQuestion  {
@Column(type="int",nullable=true )
public int  appraisalFormId;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  appraisalQuestionCreatedAt;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  appraisalQuestionId;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  appraisalQuestionStatus;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  appraisalQuestionText;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  appraisalQuestionType;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  appraisalQuestionUpdatedAt;
@Column(type="double",nullable=true )
public Double  appraisalQuestionWeight;
}
