CREATE TABLE clients
(
 "id"            integer NOT NULL,
 name          varchar(128) NOT NULL,
 email         varchar(128) NOT NULL,
 date_of_birth timestamp NOT NULL,
 cpf           varchar(16) NOT NULL,
 CONSTRAINT PK_1 PRIMARY KEY ( "id" )
);

CREATE TABLE orders
(
 "id"              integer NOT NULL,
 num_of_products integer NOT NULL,
 id_client       integer NOT NULL,
 totalValue      numeric(15,2) NOT NULL,
 CONSTRAINT PK_1 PRIMARY KEY ( "id" ),
 CONSTRAINT FK_1 FOREIGN KEY ( id_client ) REFERENCES clients ( "id" )
);

CREATE INDEX FK_2 ON orders
(
 id_client
);

CREATE TABLE products
(
 "id"          integer NOT NULL,
 description varchar(128) NOT NULL,
 value       numeric(15,2) NOT NULL,
 CONSTRAINT PK_1 PRIMARY KEY ( "id" )
);

CREATE TABLE order_products
(
 id_order   integer NOT NULL,
 id_product integer NOT NULL,
 CONSTRAINT FK_2 FOREIGN KEY ( id_order ) REFERENCES orders ( "id" ),
 CONSTRAINT FK_3 FOREIGN KEY ( id_product ) REFERENCES products ( "id" )
);

CREATE INDEX FK_1 ON order_products
(
 id_order
);

CREATE INDEX FK_2 ON order_products
(
 id_product
);
