-- 博客表
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

-- 标签表
CREATE TABLE `t_tag` (
  `id` varchar(50) NOT NULL,
  `name` varchar(200) DEFAULT NULL COMMENT '标签名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `delete_status` int(11) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `id` (`id`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标签表';

-- 博客标签关联表
CREATE TABLE `t_article_tag` (
  `article_id` varchar(50) NOT NULL,
  `tag_id` varchar(50) NOT NULL,
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客与标签关联表';