-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-04-27 07:42:20.4

-- tables
-- Table: company
CREATE TABLE company (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    reg_number int  NOT NULL,
    "user" int  NOT NULL,
    CONSTRAINT company_pk PRIMARY KEY (id)
);

-- Table: company_construction_site
CREATE TABLE company_construction_site (
    id serial  NOT NULL,
    company_id int  NOT NULL,
    construction_site_id int  NOT NULL,
    main_contractor boolean  NOT NULL DEFAULT false,
    CONSTRAINT company_construction_site_pk PRIMARY KEY (id)
);

-- Table: company_user
CREATE TABLE company_user (
    id serial  NOT NULL,
    company_id int  NOT NULL,
    user_id int  NOT NULL,
    CONSTRAINT company_user_pk PRIMARY KEY (id)
);

-- Table: construction_site
CREATE TABLE construction_site (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    address varchar(255)  NOT NULL,
    latitude int  NULL,
    longitude int  NULL,
    CONSTRAINT construction_site_pk PRIMARY KEY (id)
);

-- Table: contact
CREATE TABLE contact (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    phone_number varchar(255)  NULL,
    first_name varchar(255)  NOT NULL,
    middle_name varchar(255)  NULL,
    last_name varchar(255)  NOT NULL,
    CONSTRAINT contact_pk PRIMARY KEY (id)
);

-- Table: incident
CREATE TABLE incident (
    id serial  NOT NULL,
    safe boolean  NOT NULL,
    safety_field_id int  NOT NULL,
    report_id int  NOT NULL,
    CONSTRAINT result_pk PRIMARY KEY (id)
);

-- Table: report
CREATE TABLE report (
    id serial  NOT NULL,
    construction_site_id int  NOT NULL,
    date date  NOT NULL,
    CONSTRAINT report_pk PRIMARY KEY (id)
);

-- Table: report_picture
CREATE TABLE report_picture (
    id serial  NOT NULL,
    report_id int  NOT NULL,
    task_id int  NOT NULL,
    description varchar(255)  NULL,
    base64 bytea  NOT NULL,
    CONSTRAINT picture_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: safety_field
CREATE TABLE safety_field (
    id serial  NOT NULL,
    field_number int  NOT NULL,
    field_description varchar(255)  NOT NULL,
    CONSTRAINT kontroll_koht_pk PRIMARY KEY (id)
);

-- Table: task
CREATE TABLE task (
    id serial  NOT NULL,
    safety_field_id int  NOT NULL,
    report_id int  NOT NULL,
    description varchar(255)  NOT NULL,
    deadline date  NOT NULL,
    is_done boolean  NOT NULL,
    CONSTRAINT Korrastamisülesanne_pk PRIMARY KEY (id)
);

-- Table: task_response
CREATE TABLE task_response (
    id serial  NOT NULL,
    task_id int  NOT NULL,
    description varchar(255)  NULL,
    time timestamp  NOT NULL,
    CONSTRAINT task_response_pk PRIMARY KEY (id)
);

-- Table: task_response_picture
CREATE TABLE task_response_picture (
    id serial  NOT NULL,
    task_response_id int  NOT NULL,
    base64 bytea  NOT NULL,
    CONSTRAINT task_response_picture_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
    id serial  NOT NULL,
    email varchar(255)  NOT NULL,
    password varchar(255)  NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: user_role
CREATE TABLE user_role (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    role_id int  NOT NULL,
    CONSTRAINT user_role_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: company_construction_site_construction_site (table: company_construction_site)
ALTER TABLE company_construction_site ADD CONSTRAINT company_construction_site_construction_site
    FOREIGN KEY (construction_site_id)
    REFERENCES construction_site (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: company_project_company (table: company_construction_site)
ALTER TABLE company_construction_site ADD CONSTRAINT company_project_company
    FOREIGN KEY (company_id)
    REFERENCES company (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: company_user_company (table: company_user)
ALTER TABLE company_user ADD CONSTRAINT company_user_company
    FOREIGN KEY (company_id)
    REFERENCES company (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: company_user_user (table: company_user)
ALTER TABLE company_user ADD CONSTRAINT company_user_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: contact_user (table: contact)
ALTER TABLE contact ADD CONSTRAINT contact_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: incident_report (table: incident)
ALTER TABLE incident ADD CONSTRAINT incident_report
    FOREIGN KEY (report_id)
    REFERENCES report (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: incident_safety_field (table: incident)
ALTER TABLE incident ADD CONSTRAINT incident_safety_field
    FOREIGN KEY (safety_field_id)
    REFERENCES safety_field (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: picture_report (table: report_picture)
ALTER TABLE report_picture ADD CONSTRAINT picture_report
    FOREIGN KEY (report_id)
    REFERENCES report (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: picture_task (table: report_picture)
ALTER TABLE report_picture ADD CONSTRAINT picture_task
    FOREIGN KEY (task_id)
    REFERENCES task (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: report_construction_site (table: report)
ALTER TABLE report ADD CONSTRAINT report_construction_site
    FOREIGN KEY (construction_site_id)
    REFERENCES construction_site (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: task_report (table: task)
ALTER TABLE task ADD CONSTRAINT task_report
    FOREIGN KEY (report_id)
    REFERENCES report (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: task_response_picture_task_response (table: task_response_picture)
ALTER TABLE task_response_picture ADD CONSTRAINT task_response_picture_task_response
    FOREIGN KEY (task_response_id)
    REFERENCES task_response (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: task_response_task (table: task_response)
ALTER TABLE task_response ADD CONSTRAINT task_response_task
    FOREIGN KEY (task_id)
    REFERENCES task (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: task_safety_field (table: task)
ALTER TABLE task ADD CONSTRAINT task_safety_field
    FOREIGN KEY (safety_field_id)
    REFERENCES safety_field (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_role_role (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_role
    FOREIGN KEY (role_id)
    REFERENCES role (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_role_user (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

