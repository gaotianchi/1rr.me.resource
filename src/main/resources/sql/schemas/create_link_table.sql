DROP DATABASE IF EXISTS link;

CREATE TABLE link
(
    short_url  VARCHAR(255) UNIQUE NOT NULL,
    long_url   VARCHAR(255)        NOT NULL,
    user_id    INT                 NOT NULL,

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