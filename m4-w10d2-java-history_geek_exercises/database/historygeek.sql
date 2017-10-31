DROP TABLE IF EXISTS chat_history;
DROP SEQUENCE IF EXISTS seq_chat_history_id;
DROP TABLE IF EXISTS order_items;
DROP SEQUENCE IF EXISTS seq_order_item_id;
DROP TABLE IF EXISTS orders;
DROP SEQUENCE IF EXISTS seq_order_id;
DROP TABLE IF EXISTS products;
DROP SEQUENCE IF EXISTS seq_product_id;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id;

CREATE TABLE users (
	id INTEGER PRIMARY KEY DEFAULT NEXTVAL('seq_user_id'),
	email VARCHAR(256) NOT NULL,
	password VARCHAR(256) NOT NULL
);

CREATE SEQUENCE seq_product_id;

CREATE TABLE products (
	id INTEGER PRIMARY KEY DEFAULT NEXTVAL('seq_product_id'),
	sku VARCHAR(10) NOT NULL,
	name VARCHAR(256) NOT NULL,
	description TEXT NOT NULL,
	price DECIMAL(4,2) NOT NULL,
	imageName VARCHAR(128) NOT NULL,
	weight DECIMAL(5, 2) NOT NULL,
	active BOOLEAN DEFAULT TRUE
);

CREATE SEQUENCE seq_order_id;

CREATE TABLE orders (
	id INTEGER PRIMARY KEY DEFAULT NEXTVAL('seq_order_id'),
	userId INTEGER NOT NULL,
	billingAddress1 VARCHAR(300) NOT NULL,
	billingAddress2 VARCHAR(300) NULL,
	billingCity VARCHAR(300) NOT NULL,
	billingState VARCHAR(300) NOT NULL,
	billingPostalCode VARCHAR(10) NOT NULL,
	shippingAddress1 VARCHAR(300) NOT NULL,
	shippingAddress2 VARCHAR(300) NULL,
	shippingCity VARCHAR(300) NOT NULL,
	shippingState VARCHAR(300) NOT NULL,
	shippingPostalCode VARCHAR(10) NOT NULL,
	nameOnCard VARCHAR(100) NOT NULL,
	creditCardNumber VARCHAR(20) NOT NULL,
	expirationDate VARCHAR(10) NOT NULL,
	subTotal DECIMAL(4,2) NOT NULL,
	weight DECIMAL(5, 2) NOT NULL,
	shippingType VARCHAR(100) NOT NULL,
	shipping DECIMAL(4, 2) NOT NULL,
	tax DECIMAL(4,2) NOT NULL,
	
	CONSTRAINT fk_orders_users FOREIGN KEY (userId) REFERENCES users(id)
);

CREATE TABLE order_items (
	orderId INTEGER NOT NULL,
	productId INTEGER NOT NULL,
	quantity INTEGER NOT NULL,
	price DECIMAL(4,2) NOT NULL,

	CONSTRAINT fk_order_items_orders FOREIGN KEY (orderId) REFERENCES orders(id),
	CONSTRAINT fk_order_items_products FOREIGN KEY (productId) REFERENCES products(id)
);

CREATE SEQUENCE seq_chat_history_id;

create table chat_history (
	id INTEGER PRIMARY KEY DEFAULT NEXTVAL('seq_chat_history_id'),
	userId INTEGER NOT NULL,
	message TEXT NOT NULL,
	sentDate TIMESTAMP NOT NULL DEFAULT NOW(),

	CONSTRAINT fk_chat_history_users FOREIGN KEY (userId) REFERENCES users(id)
);

INSERT INTO products (sku, name, description, price, imageName, weight, active) VALUES ('ABC-1234', 'A People''s History of the United States', 'With a new introduction by Anthony Arnove, this updated edition of the classic national bestseller reviews the book�s thirty-five year history and demonstrates once again why it is a significant contribution to a complete and balanced understanding of American history.

Since its original landmark publication in 1980, A People''s History of the United States has been chronicling American history from the bottom up, throwing out the official version of history taught in schools�with its emphasis on great men in high places�to focus on the street, the home, and the, workplace.

Known for its lively, clear prose as well as its scholarly research, A People''s History of the United States is the only volume to tell America''s story from the point of view of�and in the words of�America''s women, factory workers, African-Americans, Native Americans, the working poor, and immigrant laborers. As historian Howard Zinn shows, many of our country''s greatest battles�the fights for a fair wage, an eight-hour workday, child-labor laws, health and safety standards, universal suffrage, women''s rights, racial equality�were carried out at the grassroots level, against bloody resistance.

Covering Christopher Columbus''s arrival through President Clinton''s first term, A People''s History of the United States, which was nominated for the American Book Award in 1981, features insightful analysis of the most important events in our history.', CAST(18.99 AS DECIMAL(4, 2)), 'abc-1234.jpg', CAST(22.80 AS DECIMAL(5, 2)), TRUE);

INSERT INTO products (sku, name, description, price, imageName, weight, active) VALUES ('DEF-5678', 'Lincoln Little Thinker', 'Yes, in many ways we feel like Lincoln, though not quite as tall. And that''s why we put such care and pride into our Abraham Lincoln Little Thinker doll. Abe stands a towering 12 inches tall and sports his trademark stovepipe hat. He''s well constructed with exacting attention to every detail. They just don''t make Republicans like they used to. Thankfully, we do.
', CAST(8.99 AS DECIMAL(4, 2)), 'def-5678.jpg', CAST(8.80 AS DECIMAL(5, 2)), TRUE);

INSERT INTO products (sku, name, description, price, imageName, weight, active)  VALUES ('GHI-9123', 'Theodore Roosevelt Plush Doll', 'TR was a conservationist who took steps to preserve natural wonders such as the Grand Canyon, though he failed to champion the people from whom the continent was "won." Theodore Roosevelt bristled with contradictions! He was a privileged and sickly child who refashioned himself into a rowdy intellectual who took on the powerful and the moneyed on behalf of the people. Now this man who was immortalized on Mount Rushmore (a/k/a Six Grandfathers) is immortalized as a cuddly 11" Little Thinker doll!', CAST(9.25 AS DECIMAL(4, 2)), 'ghi-9123.jpg', CAST(8.20 AS DECIMAL(5, 2)), TRUE);

INSERT INTO products (sku, name, description, price, imageName, weight, active)  VALUES ('JKL-4567', 'George Washington Plush Doll', 'Have you ever wanted to hug the father of our country? In real life, George Washington was known to be a hugger. Washington hugged his pal, Lafayette, who was a major-general in the Revolutionary War. On his way to resign his commission, Washington wept unashamedly and embraced each of his officers in appreciation for their camaraderie.', CAST(12.99 AS DECIMAL(4, 2)), 'jkl-4567.jpg', CAST(11.10 AS DECIMAL(5, 2)), TRUE);
