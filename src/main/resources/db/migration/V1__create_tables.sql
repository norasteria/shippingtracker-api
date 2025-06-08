CREATE TABLE whitelisted_users (
  id UUID PRIMARY KEY,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
  email TEXT NOT NULL,
  full_name TEXT NOT NULL,

  CONSTRAINT unique_email UNIQUE(email)
);

CREATE TABLE customers (
   id UUID PRIMARY KEY,
   created_at TIMESTAMP WITH TIME ZONE NOT NULL,
   updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
   name TEXT NOT NULL
);

CREATE TABLE agents (
  id UUID PRIMARY KEY,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
  name TEXT NOT NULL
);

CREATE TABLE destination_ports (
  id UUID PRIMARY KEY,
  incoterm_code TEXT NOT NULL,
  name TEXT NOT NULL,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE TABLE shipments (
  id UUID PRIMARY KEY,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
  customer_id UUID NOT NULL REFERENCES customers(id),
  agent_id UUID NOT NULL REFERENCES agents(id),
  document_indicator  TEXT,
  destination_id UUID REFERENCES destination_ports(id)
);

CREATE TABLE statuses (
  id UUID PRIMARY KEY,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
  code TEXT NOT NULL,
  name TEXT NOT NULL,

  CONSTRAINT unique_status_code UNIQUE(code)
);

CREATE TABLE status_shipment_logs (
  id UUID PRIMARY KEY,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
  shipment_id UUID NOT NULL REFERENCES shipments(id),
  data JSONB NOT NULL,
  status_id UUID NOT NULL REFERENCES statuses(id)
);
