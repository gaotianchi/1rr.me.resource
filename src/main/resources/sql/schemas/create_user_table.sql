DROP DATABASE IF EXISTS user;

CREATE TABLE user
(
    username   VARCHAR(255) UNIQUE NOT NULL,
    password   VARCHAR(255)        NOT NULL,

    id         INT                 NOT NULL AUTO_INCREMENT,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP           NULL,

    created_by VARCHAR(255)        NOT NULL,
    updated_by VARCHAR(255)        NOT NULL,
    deleted_by VARCHAR(255)        NULL,

    is_deleted BOOLEAN   DEFAULT FALSE,

    PRIMARY KEY (id)
);