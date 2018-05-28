CREATE TABLE `t_article` (
  `articleId` varchar(100) NOT NULL,
  `publishTime` datetime DEFAULT NULL COMMENT '创建日期',
  `userId` varchar(100) DEFAULT NULL,
  `title_pictrues` text,
  `title_mini` text,
  `articelTitle` varchar(200) DEFAULT NULL,
  `articelContent` text COMMENT '文章内容',
  `categoryId` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`articleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客表';

