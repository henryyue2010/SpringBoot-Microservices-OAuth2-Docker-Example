CREATE TABLE IF NOT EXISTS items(
  id SERIAL PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  weight numeric NOT NULL,
  price numeric NOT NULL,
  created_at DATE,
  updated_at DATE
);
