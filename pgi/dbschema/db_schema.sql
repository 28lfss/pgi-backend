CREATE TYPE access_level AS ENUM ('collab', 'admin');
CREATE TYPE security_sheets_status AS ENUM ('active', 'expired', 'revision');
CREATE TYPE occurrence_status AS ENUM ('open', 'revision', 'closed');

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(128) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    hash_password VARCHAR(255),
    session_token VARCHAR(255),
    login_timestamp BIGINT,
    access_level access_level DEFAULT 'collab',
    active BOOLEAN DEFAULT TRUE,
    device VARCHAR(255)
);

CREATE TABLE security_sheets (
    security_sheets_id SERIAL PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    manufacturer VARCHAR(255) NOT NULL,
    product_type VARCHAR(128),
    document_path VARCHAR(255) NOT NULL,
    register_data BIGINT,
    status security_sheets_status NOT NULL,
    sheet_registrant_id SERIAL,
    CONSTRAINT fk_user FOREIGN KEY (sheet_registrant_id) REFERENCES users(user_id)
);

CREATE TABLE occurrences (
    occurrence_id SERIAL PRIMARY KEY,
    area VARCHAR(64) NOT NULL,
    description VARCHAR(255) NOT NULL,
    image_path VARCHAR(255) NOT NULL,
    time_created BIGINT,
    status occurrence_status DEFAULT 'open',
    occurrence_registrant_id SERIAL,
    CONSTRAINT fk_user FOREIGN KEY (occurrence_registrant_id) REFERENCES users(user_id)
);