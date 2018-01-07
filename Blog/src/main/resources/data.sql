USE eros;

INSERT INTO sort (id, sort_name) VALUES
  (1, "默认分类");

INSERT INTO sort (id, sort_name) VALUES
  (2, "Hello");

INSERT INTO tag (id, tag_name) VALUES
  (1, "默认标签");

INSERT INTO tag (id, tag_name) VALUES
  (2, "新标签");

INSERT INTO article (content, date, title, sort_id) VALUES
  ("Hello World!

  `Hello`", "2017-12-31 12:26", "我的博客第一篇", 1);

INSERT INTO article (content, date, title, sort_id) VALUES
  ("这是**第二篇**博客", "2018-1-1 10:26", "Second", 2);

INSERT INTO article (content, date, title, sort_id) VALUES
  ("This is the third blog.

测试 markdown！

`Hello World`

[xlui 的博客](https://xlui.me)

![xlui 的头像](https://xlui.me/images/avatar.jpg)", "2018-01-02 17:26", "第三", 1);

INSERT INTO t_tag_article (article_id, tag_id) VALUES
  (1, 1),
  (1, 2),
  (2, 2),
  (3, 1);

INSERT INTO user (id, password, username) VALUES
  (NULL, "dev", 1);

INSERT INTO comment (content, article_id, user_id) VALUES
  ("第一条评论", 1, 1);
