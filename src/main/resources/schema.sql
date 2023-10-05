CREATE TABLE job_application (
                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                 company_name VARCHAR(50),
                                 job_title VARCHAR(50),
                                 salary_range VARCHAR(30),
                                 job_url VARCHAR(200),
                                 applied_date DATE,
                                 description VARCHAR(500),
                                 status VARCHAR(20)
);

CREATE TABLE profile (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         first_name VARCHAR(200),
                         last_name VARCHAR(200),
                         address_street_1 VARCHAR(200),
                         address_street_2 VARCHAR(200),
                         address_city VARCHAR(50),
                         address_state VARCHAR(50),
                         address_zip VARCHAR(20),
                         linkedin VARCHAR(200),
                         github VARCHAR(200),
                         personal_website VARCHAR(200)
);

INSERT INTO profile (id) VALUES (1);
