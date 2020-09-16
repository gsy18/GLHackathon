CREATE TABLE contest_details (
id CHARACTER VARYING (128),
contestid text NOT NULL,
teamid text NOT NULL,
score NUMERIC (10,2),
submissiontime BIGINT	NOT NULL,
CONSTRAINT pk_contest_details PRIMARY KEY (id),
CONSTRAINT unique_contest_details UNIQUE (contestid,teamid)
);