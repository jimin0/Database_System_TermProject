DROP DATABASE IF EXISTS facebook;
CREATE DATABASE facebook;
USE facebook;

CREATE TABLE user (
    user_ID VARCHAR(50),
    password VARCHAR(50),
    user_name VARCHAR(50),
    phone_number VARCHAR(20),
    birthday DATE,
    address VARCHAR(50),
    follower INT,
    following INT,
    phone_number2 VARCHAR(50),
    PRIMARY KEY (user_ID)
);


CREATE TABLE user_image(
    user_image_ID varchar(50),
    user_ID varchar(50),
    image int,
    PRIMARY KEY (user_image_ID),
    FOREIGN KEY (user_ID) REFERENCES user(user_ID) ON UPDATE CASCADE
);

DROP TABLE IF EXISTS birth;
CREATE TABLE birth (
    user_ID varchar(50),
    age int,
    PRIMARY KEY (user_ID),
    FOREIGN KEY (user_ID) REFERENCES user(user_ID) ON UPDATE CASCADE
);


CREATE TABLE post(
    post_ID varchar(50),
    post_date datetime,
    body_text varchar(500),
    author_ID varchar(50),
    PRIMARY KEY (post_ID),
    FOREIGN KEY (author_ID) REFERENCES user(user_ID) ON UPDATE CASCADE
);

DROP TABLE IF EXISTS post_likes;
CREATE TABLE post_likes(
    user_ID varchar(50),
    post_ID varchar(50),
    PRIMARY KEY(user_ID, post_ID),
    FOREIGN KEY (user_ID) REFERENCES user(user_ID) ON UPDATE CASCADE,
    FOREIGN KEY (post_ID) REFERENCES post(post_ID) ON UPDATE CASCADE
);


CREATE TABLE follower(
    user_ID varchar(50),
    follower_ID varchar(50),
    PRIMARY KEY (user_ID, follower_ID),
    FOREIGN KEY (user_ID) REFERENCES user(user_ID) ON UPDATE CASCADE,
    FOREIGN KEY (follower_ID) REFERENCES user(user_ID) ON UPDATE CASCADE
);


CREATE TABLE following(
    user_ID varchar(50),
    following_ID varchar(50),
    PRIMARY KEY (user_ID, following_ID),
    FOREIGN KEY (user_ID) REFERENCES user(user_ID) ON UPDATE CASCADE,
    FOREIGN KEY (following_ID) REFERENCES user(user_ID) ON UPDATE CASCADE
);


DROP TABLE IF EXISTS organization;
CREATE TABLE organization(
    org_ID varchar(50),
    org_name varchar(50),
    org_address varchar(50),
    org_number varchar(20),
    PRIMARY KEY (org_ID)
);


DROP TABLE IF EXISTS belong;
CREATE TABLE belong(
    user_ID varchar(50),
    org_ID varchar(50),
    PRIMARY KEY(user_ID, org_ID),
    FOREIGN KEY (user_ID) REFERENCES user(user_ID) ON UPDATE CASCADE,
    FOREIGN KEY (org_ID) REFERENCES organization(org_ID) ON UPDATE CASCADE
);


DROP TABLE IF EXISTS groups_;
CREATE TABLE groups_(
    group_ID varchar(50),
    group_name varchar(20),
    group_content varchar(500),
    PRIMARY KEY (group_ID)
);


CREATE TABLE follow_group( 
    user_ID varchar(50),
    group_ID varchar(50),
    PRIMARY KEY (user_ID, group_ID),
    FOREIGN KEY (user_ID) REFERENCES user(user_ID),
    FOREIGN KEY (group_ID) REFERENCES groups_(group_ID)
);


DROP TABLE IF EXISTS comment;
CREATE TABLE comment(
    comment_ID varchar(50),
    user_ID varchar(50),
    comment_content varchar(250),
    comment_date DATETIME,
    post_ID varchar(50),
    PRIMARY KEY (comment_ID),
    FOREIGN KEY (user_ID) REFERENCES user(user_ID) ON UPDATE CASCADE,
    FOREIGN KEY (post_ID) REFERENCES post(post_ID) ON UPDATE CASCADE
);


DROP TABLE IF EXISTS comment_likes;
CREATE TABLE comment_likes(
    user_ID varchar(50),
    comment_ID varchar(50),
    PRIMARY KEY(user_ID, comment_ID),
    FOREIGN KEY(comment_ID) REFERENCES comment(comment_ID) ON UPDATE CASCADE,
    FOREIGN KEY(user_ID) REFERENCES user(user_ID) ON UPDATE CASCADE
);


DROP TABLE IF EXISTS comment_tag;
CREATE TABLE comment_tag(
    comment_ID varchar(50),
    user_ID varchar(50),
    tagged_ID varchar(50),
    PRIMARY KEY (user_ID, tagged_ID, comment_ID),
    FOREIGN KEY (user_ID) REFERENCES user(user_ID) ON UPDATE CASCADE,
    FOREIGN KEY (tagged_ID) REFERENCES user(user_ID) ON UPDATE CASCADE,
    FOREIGN KEY (comment_ID) REFERENCES comment(comment_ID) ON UPDATE CASCADE
);

