insert into DBO_SAMPLE.REF_COUNTRY (NAME, CODE, CREATED_BY, CREATED_ON, MODIFIED_BY, MODIFIED_ON, IS_DELETED)
values ('United States', 'US', 'SYSTEM', NOW(), 'SYSTEM', NOW(), 0),
       ('United Kingdom', 'GB', 'SYSTEM', NOW(), 'SYSTEM', NOW(), 0),
       ('Canada', 'CA', 'SYSTEM', NOW(), 'SYSTEM', NOW(), 0);
commit;