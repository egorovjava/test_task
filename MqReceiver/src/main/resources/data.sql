DROP TABLE IF EXISTS messages;

CREATE TABLE messages (
    id UUID DEFAULT random_uuid() PRIMARY KEY,
    message_text VARCHAR(250)
);