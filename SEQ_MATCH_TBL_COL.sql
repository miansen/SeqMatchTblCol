-- Create table
create table SEQ_MATCH_TBL_COL
(
  OWNER         VARCHAR2(50) not null,
  SEQ_NAME      VARCHAR2(250) not null,
  TABLE_NAME    VARCHAR2(50),
  COLUMN_NAME   VARCHAR2(50),
  COLUMN_LENGTH NUMBER(5),
  IS_EXISTS     CHAR(1),
  REMARK        VARCHAR2(500)
)
-- Add comments to the table 
comment on table SEQ_MATCH_TBL_COL
  is '配置表';
-- Add comments to the columns 
comment on column SEQ_MATCH_TBL_COL.OWNER
  is '表的用户(不是序列的)';
comment on column SEQ_MATCH_TBL_COL.SEQ_NAME
  is '序列名，格式(强制):表名_字段名。(如果序列的命名格式是 XXX_表名_字段名，则需要去掉''XXX_'')';
comment on column SEQ_MATCH_TBL_COL.TABLE_NAME
  is '表名(程序会自动更新)';
comment on column SEQ_MATCH_TBL_COL.COLUMN_NAME
  is '字段名(程序会自动更新)';
comment on column SEQ_MATCH_TBL_COL.COLUMN_LENGTH
  is '字段长度(程序会自动更新)';
comment on column SEQ_MATCH_TBL_COL.IS_EXISTS
  is '序列对应的表是否存在 1:存在 其他:不存在(程序会自动更新)';
comment on column SEQ_MATCH_TBL_COL.REMARK
  is '备注(程序会自动更新)';
