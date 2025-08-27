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
public class JournalEntryLine  {
@Column(type="int",nullable=true )
public int  journalEntryLineAccountId;
@Column(type="double",nullable=true )
public Double  journalEntryLineAmount;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  journalEntryLineCreatedAt;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  journalEntryLineEntryType;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  journalEntryLineId;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  journalEntryLineStatus;
@Column(type="int",nullable=true )
public int  journalEntryLineTransactionId;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  journalEntryLineUpdatedAt;
}
