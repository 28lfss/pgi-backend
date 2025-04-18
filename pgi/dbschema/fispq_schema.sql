-- Habilitar pgcrypto para gerar UUID aleatório
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

-- Criação dos tipos ENUM com letras minúsculas
CREATE TYPE access_level AS ENUM ('COLLAB', 'ADMIN');
CREATE TYPE security_sheets_status AS ENUM ('ACTIVE', 'EXPIRED', 'REVISION');

-- Tabela de usuários do sistema
CREATE TABLE users (
    user_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    username VARCHAR(100) NOT NULL,
    email TEXT UNIQUE NOT NULL,
    hash_password TEXT,
    session_token VARCHAR(256),
    login_timestamp BIGINT,
    access_level access_level NOT NULL,
    is_active BOOLEAN DEFAULT FALSE,
    device TEXT
);

-- Tabela de FISPQs (fichas de informação de segurança)
CREATE TABLE security_sheets (
    security_sheets_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    product_name VARCHAR(200) NOT NULL,
    manufacturer VARCHAR(200) NOT NULL,
    product_type VARCHAR(100),
    document_attachment BYTEA NOT NULL,
    register_data TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status security_sheets_status NOT NULL,
    registrant_id UUID REFERENCES users(user_id) ON DELETE SET NULL
);