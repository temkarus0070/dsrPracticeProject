insert into student (id, contact_data, full_name, study_course, study_group, test_result)
values (1, 'telegram:abcd', 'vasya pupkin', '3', '11', 100) ON CONFLICT DO NOTHING;

insert into student (id, contact_data, full_name, study_course, study_group, test_result)
values (2, 'telegram:ebgh', 'vasya ivanov', '3', '10', 24)ON CONFLICT DO NOTHING;

insert into mentor (id, contact_data, full_name, job_name)
values (1, 'telegram:1234', 'Ivan Ivanov', 'Java-developer')ON CONFLICT DO NOTHING;

insert into mentor (id, contact_data, full_name, job_name)
values (2, 'telegram:12346790', 'Ivan vASILIEV', 'JS-developer')ON CONFLICT DO NOTHING;

