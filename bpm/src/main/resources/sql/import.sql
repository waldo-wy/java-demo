CREATE USER IF NOT EXISTS bpms PASSWORD 'bpms';
CREATE SCHEMA IF NOT EXISTS bpms;
GRANT ALL ON SCHEMA bpms TO bpms;

// DISTRIBUTE_RECORD

-- 分配记录表
DROP TABLE IF EXISTS DISTRIBUTE_RECORD;
CREATE TABLE DISTRIBUTE_RECORD (
  id                     IDENTITY PRIMARY KEY,
  gmt_create             TIMESTAMP,
  gmt_modified           TIMESTAMP,
  distribute_org_code    VARCHAR, -- 机构编码
  distribute_record_key  VARCHAR, -- 分配责任人
  distribute_record_type VARCHAR, -- 分配记录类型
  distribute_times       NUMBER, -- 分配次数
);
