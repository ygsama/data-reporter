-- 初始化数据
use data_report;
INSERT INTO `role` VALUES ('aa3a05d507a94970a8fcec3b4b0c4661', '系统管理员', 'T', '', '{}');
INSERT INTO `role` VALUES ('d93b082d11674aa28c81ee4bccbb1b99', '公司管理员', 'T', '', '{}');
INSERT INTO `role` VALUES ('90b5a6f075844fa8a62ad235d42eaa09', '空间管理员', 'T', '','{}');
INSERT INTO `role` VALUES ('0', '普通用户', 'T', '','{}');
commit;

INSERT INTO `groups` VALUES ('0507ea07e59e43249493933935ca078a', '公开空间', '', '{}');
INSERT INTO `groups` VALUES ('efdb5419d5ff413d80cf2ef8be9bc5d5', '测试空间', '', '{}');
INSERT INTO `groups` VALUES ('649adabd7489456193ca3ce8ade3d538', '普通空间', '', '{}');
commit;

INSERT INTO `company` VALUES ('28965e34f0aa4bd6a65c360a0fd2f571', '紫津融畅', '', '', 'T', '南京', '中国江苏南京', '123123','2g@zjft.com','','{}');
INSERT INTO `company` VALUES ('4b682213999e4054925bcdb67383cdf1', 'XX银行', '', '', 'T', '北京', '中国北京', '213213','123@a.com','','{}');
commit;


INSERT INTO `users` VALUES ('admin', '张三', 'password', 'T','','', '28965e34f0aa4bd6a65c360a0fd2f571', '3760eeb1b3694f228f542151c6f6e6d3','aa3a05d507a94970a8fcec3b4b0c4661','','','','');
commit;

INSERT INTO `space` VALUES ('12deef1506cf4b8db9dea7a7d5f90e86', 'demo', 'T', '4b682213999e4054925bcdb67383cdf1','0507ea07e59e43249493933935ca078a','admin','2018-09-20','','{}');
INSERT INTO `space` VALUES ('3760eeb1b3694f228f542151c6f6e6d3', '紫津融畅', 'T', '28965e34f0aa4bd6a65c360a0fd2f571',  '649adabd7489456193ca3ce8ade3d538','admin','2018-09-20','','{}');
INSERT INTO `space` VALUES ('bf85be932c7041db98176dfc56c75a0c', '紫津融畅', 'T', '28965e34f0aa4bd6a65c360a0fd2f571',  'efdb5419d5ff413d80cf2ef8be9bc5d5','admin','2018-09-20','','{}');
commit;

INSERT INTO `report` VALUES ('35169c804c6147bf90ccc38506e679ff', '紫金报表', 'F', '','T','28965e34f0aa4bd6a65c360a0fd2f571', '3760eeb1b3694f228f542151c6f6e6d3','admin','2018-09-20','','{}');
commit;

INSERT INTO `dashboard` VALUES ('ce3fe2da62444ed085dffc203124bfbd', '紫金大屏', 'F', '','T','28965e34f0aa4bd6a65c360a0fd2f571', '3760eeb1b3694f228f542151c6f6e6d3','admin','2018-09-20','','{}');
commit;

INSERT INTO `resource` VALUES ('840d76091ca74a6ca110917b89148d3d', 'ATM数据', 'http://www.zjft.com/api/xxxx','F', '','T','28965e34f0aa4bd6a65c360a0fd2f571', '3760eeb1b3694f228f542151c6f6e6d3','admin','2018-09-20','','{}');
commit;
