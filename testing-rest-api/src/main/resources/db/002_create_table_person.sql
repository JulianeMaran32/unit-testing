USE testing_db;
CREATE TABLE person
(
    id         BIGINT       NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(80)  NOT NULL,
    last_name  VARCHAR(80)  NOT NULL,
    email      VARCHAR(100) NOT NULL UNIQUE,
    address    VARCHAR(150) NOT NULL,
    gender     VARCHAR(15)  NOT NULL,
    PRIMARY KEY (id)
);
