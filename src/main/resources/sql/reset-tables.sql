DROP TABLE IF EXISTS link;
DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    username   VARCHAR(255) UNIQUE NOT NULL,
    password   VARCHAR(255)        NOT NULL,
    email      VARCHAR(255) UNIQUE NOT NULL,
    email_is_verified BOOLEAN DEFAULT FALSE,

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

CREATE TABLE link
(
    short_url  VARCHAR(255) UNIQUE NOT NULL,
    long_url   VARCHAR(255)        NOT NULL,
    user_id    INT                 NOT NULL,
    expired_at TIMESTAMP NULL,

    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE,

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