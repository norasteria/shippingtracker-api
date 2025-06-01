CREATE TABLE whitelisted_users (
  id          UUID                       PRIMARY KEY,
  created_at  TIMESTAMP WITH TIME ZONE   NOT NULL,
  updated_at  TIMESTAMP WITH TIME ZONE   NOT NULL,
  email       TEXT                       NOT NULL,
  full_name   TEXT                       NOT NULL,

  CONSTRAINT unique_email UNIQUE(email)
);

CREATE TABLE customers (
   id         UUID                         PRIMARY KEY,
   created_at TIMESTAMP WITH TIME ZONE NOT NULL,
   updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
   name       TEXT                         NOT NULL
);

CREATE TABLE agents (
  id            UUID                       PRIMARY KEY,
  created_at    TIMESTAMP WITH TIME ZONE   NOT NULL,
  updated_at    TIMESTAMP WITH TIME ZONE   NOT NULL,
  name          TEXT                       NOT NULL
);

CREATE TABLE incoterms (
  id          UUID                       PRIMARY KEY,
  code        TEXT                       NOT NULL,
  description TEXT                       NOT NULL,
  created_at  TIMESTAMP WITH TIME ZONE   NOT NULL,
  updated_at  TIMESTAMP WITH TIME ZONE   NOT NULL
);

CREATE TABLE shipments (
  id                  UUID                       PRIMARY KEY,
  created_at          TIMESTAMP WITH TIME ZONE   NOT NULL,
  updated_at          TIMESTAMP WITH TIME ZONE   NOT NULL,
  customer_id         UUID                       NOT NULL,
  incoterm_id         UUID                       NOT NULL,
  agent_id            UUID                       NOT NULL,
  document_indicator  TEXT,
  destination_port    TEXT,

 FOREIGN KEY (customer_id) REFERENCES customers(id),
 FOREIGN KEY (incoterm_id) REFERENCES incoterms(id),
 FOREIGN KEY (agent_id) REFERENCES agents(id)
);

CREATE TABLE statuses (
  id                  UUID                        PRIMARY KEY,
  created_at          TIMESTAMP WITH TIME ZONE    NOT NULL,
  updated_at          TIMESTAMP WITH TIME ZONE    NOT NULL,
  code                TEXT                        NOT NULL,
  name                TEXT                        NOT NULL,

  CONSTRAINT unique_status_code UNIQUE(code)
);

CREATE TABLE status_shipment_logs (
  id                  UUID                       PRIMARY KEY,
  created_at          TIMESTAMP WITH TIME ZONE   NOT NULL,
  updated_at          TIMESTAMP WITH TIME ZONE   NOT NULL,
  shipment_id         UUID                       NOT NULL,
  data                JSONB                      NOT NULL,
  status_id           UUID                       NOT NULL,

  FOREIGN KEY (shipment_id) REFERENCES shipments(id),
  FOREIGN KEY (status_id)   REFERENCES statuses(id)
);