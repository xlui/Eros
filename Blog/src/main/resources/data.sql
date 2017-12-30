use eros;

INSERT INTO sort (id, sort_name) VALUES
  (1, "Hello");

INSERT INTO article (content, date, title, sort_id) VALUES
  ("Hello World", now(), "我的博客第一篇", 1);

INSERT INTO tag (id, tag_name) VALUES (null, "标签");

INSERT INTO user (id, password, username) VALUES
  (NULL, "dev", 1);

INSERT INTO comment (content, article_id, user_id) VALUES
  ("第一条评论", 1, 1);

INSERT INTO t_tag_article (article_id, tag_id) VALUES
  (1, 1);
