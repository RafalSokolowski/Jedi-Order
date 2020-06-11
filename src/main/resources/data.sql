DELETE FROM warrior;
DELETE FROM users;

INSERT INTO warrior (name, side, orderName, grade, lightsaber, strength, appearance, homeWorld, species, gender, master)
VALUES ('Testowy', 'LIGHT', 'REPUBLIC', 'ADEPT', 'HILT_LIGHTSABER', 550,'LUKE','TATOOINE','HUMAN','MALE','M_YODA');


-- INSERT INTO users (username, password, firstName, secondName, age, email, phone)
-- VALUES ('Admin', 'Admin', 'Mr.', 'Administrator', 42, 'admin@admin.ad','');
