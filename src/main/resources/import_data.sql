INSERT INTO app_schema.person (id, first_name, middle_name, last_name, age, created_by, created_date, last_modified_by, last_modified_date) VALUES (app_schema.person_seq.nextval, 'Albert', NULL, 'Einstein', 76, current_user(), sysdate, current_user(), sysdate);
INSERT INTO app_schema.person (id, first_name, middle_name, last_name, age, created_by, created_date, last_modified_by, last_modified_date) VALUES (app_schema.person_seq.nextval, 'Leonardo', NULL, 'Da Vinci', 67, current_user(), sysdate, current_user(), sysdate);

COMMIT;