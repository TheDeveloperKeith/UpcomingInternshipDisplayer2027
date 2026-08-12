sqlCREATE TABLE IF NOT EXISTS internshipwebsites (
    id BIGINT NOT NULL AUTO_INCREMENT,
    internships VARCHAR(255),
    programmingLanguage VARCHAR(255),
    PRIMARY KEY (id)
);

INSERT INTO internshipwebsites (internships, programmingLanguage) VALUES
('GOLDMAN SACHS', 'Java'),
('JPMORGAN', 'Java'),
('BANKOFAMERICA', 'Java'),
('JANESTREET', 'C++'),
('NVIDIA', 'C++'),
('AMD', 'C++'),
('NETFLIX', 'JavaScript'),
('TWITCH', 'JavaScript'),
('VERCEL', 'JavaScript'),
('GOOGLE', 'General'),
('MICROSOFT', 'General'),
('AMAZON', 'General');