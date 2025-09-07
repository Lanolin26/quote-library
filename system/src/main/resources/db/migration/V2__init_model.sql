create schema book;

CREATE TABLE book.quote
(
    id        UUID          NOT NULL,
    quote     VARCHAR(5120) NOT NULL,
    source_id UUID          NOT NULL,
    author_id UUID,
    CONSTRAINT pk_quote PRIMARY KEY (id)
);

CREATE TABLE book.source
(
    id             UUID          NOT NULL,
    source_name    VARCHAR(1024) NOT NULL,
    source_type_id UUID          NOT NULL,
    CONSTRAINT pk_source PRIMARY KEY (id)
);

CREATE TABLE book.source_type
(
    id          UUID         NOT NULL,
    source_type VARCHAR(512) NOT NULL,
    CONSTRAINT pk_source_type PRIMARY KEY (id)
);

CREATE TABLE book.users
(
    id         UUID NOT NULL,
    username   VARCHAR(255),
    password   VARCHAR(255),
    email      VARCHAR(255),
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE book.user_roles
(
    user_id UUID NOT NULL,
    roles   VARCHAR(255)
);

ALTER TABLE book.source
    ADD CONSTRAINT uc_source_source_name UNIQUE (source_name, source_type_id);

ALTER TABLE book.source_type
    ADD CONSTRAINT uc_sourcetype_sourcetype UNIQUE (source_type);

CREATE INDEX idx_source_source_name ON book.source (source_name);

CREATE INDEX idx_sourcetype_sourcetype_unq ON book.source_type (source_type);

ALTER TABLE book.quote
    ADD CONSTRAINT FK_QUOTE_ON_AUTHOR FOREIGN KEY (author_id) REFERENCES book.users (id);

ALTER TABLE book.quote
    ADD CONSTRAINT FK_QUOTE_ON_SOURCE FOREIGN KEY (source_id) REFERENCES book.source (id);

CREATE INDEX idx_quote_source_id ON book.quote (source_id);

ALTER TABLE book.source
    ADD CONSTRAINT FK_SOURCE_ON_SOURCE_TYPE FOREIGN KEY (source_type_id) REFERENCES book.source_type (id);

ALTER TABLE book.user_roles
    ADD CONSTRAINT fk_user_roles_on_user FOREIGN KEY (user_id) REFERENCES book.users (id);