
-- Insert records into user_type
INSERT INTO user_type (name) VALUES ('Admin');
INSERT INTO user_type (name) VALUES ('User');

-- Insert records into document_type
INSERT INTO document_type (name) VALUES ('Passport');
INSERT INTO document_type (name) VALUES ('Driver License');

-- Insert records into organization
INSERT INTO organization (name, description) VALUES ('Quatro Inmobiliaria', 'Description for Quatro');
INSERT INTO organization (name, description) VALUES ('Imagina', 'Description for Imagina');

-- Insert records into tenant
INSERT INTO tenant (name, org_id) VALUES ('Way 3980', 1);
INSERT INTO tenant (name, org_id) VALUES ('Tenant 2', 2);

-- Insert records into user
INSERT INTO user (name, last_name, username, password, document_type, document, user_type) 
VALUES ('Cesar', 'Estrada', 'cesarestrada090@gmail.com', 'password123', 1, 'A12345678', 1);
INSERT INTO user (name, last_name, username, password, document_type, document, user_type) 
VALUES ('Melissa', 'Vasquez', 'mevv@gmail.com', 'password456', 2, 'B98765432', 2);

INSERT INTO user_tenant (user_id, tenant_id, status)
VALUES 
    (1, 1, 1), -- User 1 is active in Tenant 1
    (1, 2, 1), -- User 1 is active in Tenant 2
    (2, 1, 1); -- User 2 is active in Tenant 1