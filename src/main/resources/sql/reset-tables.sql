DROP TABLE IF EXISTS link;
DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    username              VARCHAR(255) UNIQUE NOT NULL,
    password              VARCHAR(255)        NULL,
    email                 VARCHAR(255) UNIQUE NOT NULL,
    email_is_verified     BOOLEAN   DEFAULT FALSE,
    use_third_party_login BOOLEAN   DEFAULT FALSE,

    id                    INT                 NOT NULL AUTO_INCREMENT,

    created_at            TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at            TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at            TIMESTAMP           NULL,

    created_by            VARCHAR(255)        NOT NULL,
    updated_by            VARCHAR(255)        NOT NULL,
    deleted_by            VARCHAR(255)        NULL,

    is_deleted            BOOLEAN   DEFAULT FALSE,

    PRIMARY KEY (id)
);

CREATE TABLE link
(
    code VARCHAR(255) UNIQUE NOT NULL,
    original_url VARCHAR(255)        NOT NULL,
    expired_at TIMESTAMP    NULL,
    password   VARCHAR(255) NULL,
    user_id      INT                 NOT NULL,

    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE,

    id           INT                 NOT NULL AUTO_INCREMENT,

    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at   TIMESTAMP           NULL,

    created_by   VARCHAR(255)        NOT NULL,
    updated_by   VARCHAR(255)        NOT NULL,
    deleted_by   VARCHAR(255)        NULL,

    is_deleted   BOOLEAN   DEFAULT FALSE,

    PRIMARY KEY (id)
);