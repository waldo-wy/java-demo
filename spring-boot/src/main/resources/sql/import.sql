-- 书籍
DROP TABLE IF EXISTS book;
CREATE TABLE book (
  id          IDENTITY PRIMARY KEY,
  isbn        VARCHAR(32), -- 标准书号
  title       VARCHAR(512), -- 书名
  author_id   BIGINT, -- 作者
  description VARCHAR(1024), -- 书籍描述
);

-- 作者
DROP TABLE IF EXISTS author;
CREATE TABLE author (
  id         IDENTITY PRIMARY KEY,
  first_name VARCHAR(64),
  last_name  VARCHAR(64)
);