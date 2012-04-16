CREATE Database lportal;
use mysql;
INSERT INTO user (Host,User,Password) VALUES('localhost','liferay',PASSWORD(''));
flush privileges;
grant all privileges on lportal.* to liferay@localhost;
flush privileges;
