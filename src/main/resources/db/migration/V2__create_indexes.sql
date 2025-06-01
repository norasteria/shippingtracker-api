CREATE INDEX idx_whitelist_users_email ON whitelisted_users(email);

CREATE UNIQUE INDEX unique_agent_name ON agents(LOWER(TRIM(name)));

CREATE INDEX idx_customers_name ON customers(LOWER(TRIM(name)));

CREATE INDEX idx_shipments_created_at ON shipments(created_at);

CREATE INDEX idx_shipment_status_log_id ON status_shipment_logs(shipment_id);
CREATE INDEX idx_shipment_status_created_at ON status_shipment_logs(created_at);
CREATE INDEX idx_shipment_status_log_latest ON status_shipment_logs(shipment_id, created_at DESC);
