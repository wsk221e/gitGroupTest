-- 0.CREATE DB/USER
CREATE DATABASE IF NOT EXISTS gitGroupTest;

DROP USER IF EXISTS 'gitGroupTest'@'%';

CREATE USER 'gitGroupTest'@'%' IDENTIFIED BY '1234';

GRANT ALL PRIVILEGES ON gitGroupTest.* TO 'gitGroupTest'@'%';

FLUSH PRIVILEGES;

-- 1.CREATE TABLE
USE gitGroupTest;

DROP TABLE IF EXISTS tb_member;

CREATE TABLE tb_member
(
    m_no    INT NOT NULL,
    m_id    VARCHAR(20),
    m_pw    VARCHAR(20),
    m_name  VARCHAR(20),
    m_email VARCHAR(50),
    PRIMARY KEY (m_no)
);
