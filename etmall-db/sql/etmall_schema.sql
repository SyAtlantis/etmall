drop database if exists etmall;
drop user if exists 'etmall'@'localhost';
-- 支持emoji：需要mysql数据库参数： character_set_server=utf8mb4
create database etmall default character set utf8mb4 collate utf8mb4_unicode_ci;
use etmall;
create user 'etmall'@'localhost' identified by 'etmall123456';
grant all privileges on etmall.* to 'etmall'@'localhost';
flush privileges;