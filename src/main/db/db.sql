-- 博客表
CREATE TABLE `t_article` (
  `articleId` varchar(100) NOT NULL COMMENT '博客主键',
  `publishTime` datetime DEFAULT NULL COMMENT '创建日期',
  `userId` varchar(100) DEFAULT NULL,
  `title_pictrues` text COMMENT '标题图片',
  `title_mini` text COMMENT '文章简介',
  `articelTitle` varchar(200) DEFAULT NULL COMMENT '文章标题',
  `articelContent` text COMMENT '文章内容',
  `categoryId` varchar(100) DEFAULT NULL COMMENT '关联标签id',
  `type` varchar(5) DEFAULT NULL COMMENT '文章类型/暂定 1是轮播图文章',
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