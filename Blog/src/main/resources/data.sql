use eros;

INSERT INTO sort (id, sort_name) VALUES
  (1, "默认分类");

INSERT INTO sort (id, sort_name) VALUES
  (2, "Hello");

INSERT INTO tag (id, tag_name) VALUES
  (1, "默认标签");

INSERT INTO tag (id, tag_name) VALUES
  (2, "新标签");

INSERT INTO article (content, date, title, sort_id) VALUES
  ("Hello World", now(), "我的博客第一篇", 1);

INSERT INTO article (content, date, title, sort_id) VALUES
  ("这是第二篇博客", now(), "Second", 2);

INSERT INTO article (content, date, title, sort_id) VALUES
  ("This is the third blog.", now(), "第三", 1);

INSERT INTO t_tag_article (article_id, tag_id) VALUES
  (1, 1),
  (1, 2),
  (2, 2),
  (3, 1);

INSERT INTO user (id, password, username) VALUES
  (NULL, "dev", 1);

INSERT INTO comment (content, article_id, user_id) VALUES
  ("第一条评论", 1, 1);
