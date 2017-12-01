DROP TABLE IF EXISTS message;
DROP TABLE IF EXISTS app_user;

CREATE TABLE app_user (
  user_name varchar(32) NOT NULL,
  password varchar(32) NOT NULL,
  CONSTRAINT pk_app_user_username PRIMARY KEY (user_name)
);

CREATE TABLE message (
  message_id serial,
  sender_name varchar(32) NOT NULL,
  private boolean NOT NULL DEFAULT FALSE,
  receiver_name varchar(32),
  message_text varchar(200) NOT NULL,
  create_date timestamp NOT NULL DEFAULT now(),
  CONSTRAINT pk_message_message_id PRIMARY KEY (message_id)
);

ALTER TABLE message ADD FOREIGN KEY (sender_name) REFERENCES app_user(user_name);

-- Test data

INSERT INTO app_user (user_name, password) VALUES ('gates', 'bill');
INSERT INTO app_user (user_name, password) VALUES ('jobs', 'steve');
INSERT INTO app_user (user_name, password) VALUES ('woz', 'steve');
INSERT INTO app_user (user_name, password) VALUES ('ellison', 'larry');
INSERT INTO app_user (user_name, password) VALUES ('kildall', 'gary');

INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('gates', true, 'jobs', 'hey');
INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('jobs', true, 'gates', 'hey back');
INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('gates', true, 'woz', 'what''s with steve?');
INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('woz', true, 'jobs', 'bill''s asking what''s with you');
INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('jobs', true, 'woz', 'bill can suck eggs');
INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('woz', true, 'gates', 'steve says hi');
INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('gates', true, 'jobs', 'woz said you said hi');
INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('ellison', true, 'kildall', 'bill and the two steves are losers');
INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('kildall', true, 'ellison', 'tell me about it');
INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('jobs', true, 'gates', 'wonder what ellison and kildall are whining about now');

INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('gates', false, null, 'Windoze 4Everrrrrrr!!!!!!');
INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('woz', false, null, 'Anybody interested in a game of AD&D?');
INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('ellison', false, null, 'I am better than everyone!');
INSERT INTO message (sender_name, private, receiver_name, message_text)
VALUES ('gates', false, null, 'I am richer than everyone!');

