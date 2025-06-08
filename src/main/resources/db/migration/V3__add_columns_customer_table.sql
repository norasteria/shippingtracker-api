ALTER TABLE customers RENAME COLUMN name to company_name;
ALTER TABLE customers ADD COLUMN city TEXT;
ALTER TABLE customers ADD COLUMN address TEXT;
ALTER TABLE customers ADD COLUMN province TEXT;
ALTER TABLE customers ADD COLUMN slug TEXT;