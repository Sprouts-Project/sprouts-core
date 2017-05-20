#import.sql

start transaction;

INSERT INTO hibernate_sequences (sequence_name, sequence_next_hi_value) VALUES ('DomainEntity', '1');

INSERT INTO authority (id, version, authority) VALUES ('1', '0', 'USER');

INSERT INTO useraccount (id, version, username, password) VALUES ('2', '0', 'user', '8fde763698e52e18f6bd6c08e61d954ca7141c85fdae95c12dc479a3621922c0024e929dc6e7c3ed');

INSERT INTO user_authority (user_account, authority) VALUES ('2', '1');

INSERT INTO user (id, version, name, userAccountId) VALUES ('3', '0', 'John Doe', '2');

INSERT INTO note (id, version, text, public, publishingDate, user) VALUES ('4', '0', 'This is my first note. Hello world!', TRUE, '2017/05/20 18:58', '3');
INSERT INTO note (id, version, text, public, publishingDate, user) VALUES ('5', '0', 'And this is my second note', FALSE, '2017/05/20 18:59', '3');

commit;