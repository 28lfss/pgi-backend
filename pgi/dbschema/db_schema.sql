CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TYPE access_level AS ENUM ('collab', 'admin');
CREATE TYPE security_sheets_status AS ENUM ('active', 'expired', 'revision');
CREATE TYPE occurrence_status AS ENUM ('open', 'revision', 'closed');

CREATE TABLE users (
    user_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    username VARCHAR(128) NOT NULL,
    email TEXT UNIQUE NOT NULL,
    hash_password TEXT,
    session_token VARCHAR(255),
    login_timestamp BIGINT,
    access_level access_level DEFAULT 'collab',
    active BOOLEAN DEFAULT TRUE,
    device TEXT
);

CREATE TABLE security_sheets (
    security_sheets_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    product_name VARCHAR(255) NOT NULL,
    manufacturer VARCHAR(255) NOT NULL,
    product_type VARCHAR(128),
    document_attachment VARCHAR(255) NOT NULL,
    register_data TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status security_sheets_status NOT NULL,
    registrant_id UUID,
    CONSTRAINT fk_user FOREIGN KEY (registrant_id) REFERENCES users(user_id)
);

CREATE TABLE occurrences (
    occurrence_id BIGINT PRIMARY KEY,
    area VARCHAR(64) NOT NULL,
    description VARCHAR(255) NOT NULL,
    occurrence_image_url VARCHAR(255) NOT NULL,
    time_created BIGINT NOT NULL,
    occurrence_status occurrence_status DEFAULT 'open',
    registrant_id UUID,
    CONSTRAINT fk_user FOREIGN KEY (registrant_id) REFERENCES users(user_id)
);