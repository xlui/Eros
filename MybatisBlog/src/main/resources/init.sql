USE `eros`;

# Drop Table

DROP TABLE IF EXISTS `st_article_tag`;
DROP TABLE IF EXISTS `comment`;
DROP TABLE IF EXISTS `article`;
DROP TABLE IF EXISTS `sort`;
DROP TABLE IF EXISTS `tag`;
DROP TABLE IF EXISTS `user`;

# Create Table

CREATE TABLE `sort` (
  id   INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(32) NOT NULL,
  UNIQUE KEY `name` (`name`)
)
  ENGINE = INNODB
  AUTO_INCREMENT = 11
  DEFAULT CHARSET = utf8;

CREATE TABLE `tag` (
  id   INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(32) NOT NULL,
  UNIQUE KEY `name` (`name`)
)
  ENGINE = INNODB
  AUTO_INCREMENT = 13
  DEFAULT CHARSET = utf8;

CREATE TABLE `article` (
  id          INT      AUTO_INCREMENT PRIMARY KEY,
  title       CHAR(32) NOT NULL,
  content     TEXT,
  create_date DATETIME DEFAULT now(),
  update_date DATETIME DEFAULT now(),
  sort_id     INT      NOT NULL,
  KEY `title` (`title`),
  CONSTRAINT `fk_article_sort` FOREIGN KEY (`sort_id`) REFERENCES sort (`id`)
)
  ENGINE = INNODB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8;

CREATE TABLE `user` (
  id       INT         AUTO_INCREMENT PRIMARY KEY,
  username CHAR(20)     NOT NULL,
  password VARCHAR(128) NOT NULL,
  avatar   CHAR(64),
  nickname VARCHAR(32) DEFAULT NULL,
  KEY `username` (`username`)
)
  ENGINE = INNODB
  AUTO_INCREMENT = 23
  DEFAULT CHARSET = utf8;

CREATE TABLE `comment` (
  id         INT      AUTO_INCREMENT PRIMARY KEY,
  content    CHAR(128) NOT NULL,
  date       DATETIME DEFAULT NOW(),
  article_id INT       NOT NULL,
  user_id    INT       NOT NULL,
  KEY `content` (`content`),
  CONSTRAINT `fk_comment_article` FOREIGN KEY (`article_id`) REFERENCES article (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `fk_comment_user` FOREIGN KEY (`user_id`) REFERENCES user (`id`)
    ON DELETE CASCADE
)
  ENGINE = INNODB
  AUTO_INCREMENT = 29
  DEFAULT CHARSET = utf8;

CREATE TABLE `st_article_tag` (
  article_id INT NOT NULL,
  tar_id     INT NOT NULL,
  CONSTRAINT `fk_st_article_tag_article` FOREIGN KEY (`article_id`) REFERENCES article (`id`),
  CONSTRAINT `fk_st_article_tag_tag` FOREIGN KEY (`tar_id`) REFERENCES tag (`id`)
)
  ENGINE = INNODB
  AUTO_INCREMENT = 27
  DEFAULT CHARSET = utf8;

# init database

INSERT INTO `user` (id, username, password) VALUES
  (1, 1, 'dev');

INSERT INTO `sort` (id, name) VALUES
  (1, '默认分类'),
  (2, '随笔');

INSERT INTO `tag` (id, name) VALUES
  (1, '默认标签'),
  (2, 'markdown');

INSERT INTO `article` (id, title, content, create_date, sort_id) VALUES
  (1, '我的博客第一篇', 'Hello World!

  `Hello`', '2017-12-31 12:26', 1),
  (2, 'Second', '这是**第二篇**博客', '2018-1-1 10:26', 2),
  (3, '第三篇', 'This is the third blog.

测试 markdown！

`Hello World`

[xlui 的博客](https://xlui.me)

![xlui 的头像](https://xlui.me/images/avatar.jpg)', NOW(), 1);

INSERT INTO `comment` (content, date, article_id, user_id) VALUES
  ('第一条评论', '2018-01-02 17:20', 1, 1),
  ('测试评论', NOW(), 1, 1);

INSERT INTO `st_article_tag` (article_id, tar_id) VALUES
  (1, 1),
  (1, 2),
  (2, 2),
  (3, 1);
