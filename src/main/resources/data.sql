insert into student (id, contact_data, full_name, study_course, study_group, test_result)
values (1, 'telegram:abcd', 'vasya pupkin', '3', '11', 100) ON CONFLICT DO NOTHING;

insert into student (id, contact_data, full_name, study_course, study_group, test_result)
values (2, 'telegram:ebgh', 'vasya ivanov', '3', '10', 24)ON CONFLICT DO NOTHING;

insert into mentor (id, contact_data, full_name, job_name)
values (1, 'telegram:1234', 'Ivan Ivanov', 'Java-developer')ON CONFLICT DO NOTHING;

insert into mentor (id, contact_data, full_name, job_name)
values (2, 'telegram:12346790', 'Ivan vASILIEV', 'JS-developer')ON CONFLICT DO NOTHING;

insert into practice_ticket (begin_of_practice, end_of_practice, mentor_id, programming_language, student_id,
                             final_mark, recommend_to_hire, task_name, final_mentor_review_id)
values (DATE'2022-06-01', DATE'2022-07-01', 1, 'Java', 1, null, false, 'calculator', null)ON CONFLICT DO NOTHING;


insert into practice_ticket (begin_of_practice, end_of_practice, mentor_id, programming_language, student_id,
                             final_mark, recommend_to_hire, task_name, final_mentor_review_id)
values (DATE'2022-05-22', DATE'2022-06-11', 2, 'JS', 2, null, false, 'Lending page', null)ON CONFLICT DO NOTHING;



insert into weekly_study_review (id, text_review, practice_ticket_begin_of_practice, practice_ticket_end_of_practice,
                                 practice_ticket_mentor_id, practice_ticket_programming_language,
                                 practice_ticket_student_id)
values (4, 'все хорошо', DATE'2022-06-01', DATE'2022-07-01', 1, 'Java', 1)ON CONFLICT DO NOTHING;

insert into weekly_study_review (id, text_review, practice_ticket_begin_of_practice, practice_ticket_end_of_practice,
                                 practice_ticket_mentor_id, practice_ticket_programming_language,
                                 practice_ticket_student_id)
values (1, 'все классно', DATE'2022-05-22', DATE'2022-06-11', 2, 'JS', 2)ON CONFLICT DO NOTHING;

insert into weekly_study_review (id, text_review, practice_ticket_begin_of_practice, practice_ticket_end_of_practice,
                                 practice_ticket_mentor_id, practice_ticket_programming_language,
                                 practice_ticket_student_id)
values (2, 'все классно', DATE'2022-05-22', DATE'2022-06-11', 2, 'JS', 2)ON CONFLICT DO NOTHING;

insert into weekly_study_review (id, text_review, practice_ticket_begin_of_practice, practice_ticket_end_of_practice,
                                 practice_ticket_mentor_id, practice_ticket_programming_language,
                                 practice_ticket_student_id)
values (3, 'все хорошо', DATE'2022-05-22', DATE'2022-06-11', 2, 'JS', 2)ON CONFLICT DO NOTHING;

insert into final_study_review (id, text_review, practice_ticket_begin_of_practice, practice_ticket_end_of_practice,
                                practice_ticket_mentor_id, practice_ticket_programming_language,
                                practice_ticket_student_id)
values (1, 'все классно', DATE'2022-05-22', DATE'2022-06-11', 2, 'JS', 2)ON CONFLICT DO NOTHING;


insert into practice_ticket (begin_of_practice, end_of_practice, mentor_id, programming_language, student_id,
                             final_mark, recommend_to_hire, task_name, final_mentor_review_id)
values (DATE'2022-05-22', DATE'2022-06-11', 2, 'html', 2, null, false, 'Lending page', null)ON CONFLICT DO NOTHING;

insert into weekly_study_review (id, text_review, practice_ticket_begin_of_practice, practice_ticket_end_of_practice,
                                 practice_ticket_mentor_id, practice_ticket_programming_language,
                                 practice_ticket_student_id)
values (5, 'все классно', DATE'2022-05-22', DATE'2022-06-11', 2, 'html', 2)ON CONFLICT DO NOTHING;

insert into weekly_study_review (id, text_review, practice_ticket_begin_of_practice, practice_ticket_end_of_practice,
                                 practice_ticket_mentor_id, practice_ticket_programming_language,
                                 practice_ticket_student_id)
values (6, 'все классно', DATE'2022-05-22', DATE'2022-06-11', 2, 'html', 2)ON CONFLICT DO NOTHING;

insert into weekly_study_review (id, text_review, practice_ticket_begin_of_practice, practice_ticket_end_of_practice,
                                 practice_ticket_mentor_id, practice_ticket_programming_language,
                                 practice_ticket_student_id)
values (7, 'все хорошо', DATE'2022-05-22', DATE'2022-06-11', 2, 'html', 2)ON CONFLICT DO NOTHING;

insert into final_study_review (id, text_review, practice_ticket_begin_of_practice, practice_ticket_end_of_practice,
                                practice_ticket_mentor_id, practice_ticket_programming_language,
                                practice_ticket_student_id)
values (2, 'все классно', DATE'2022-05-22', DATE'2022-06-11', 2, 'html', 2)ON CONFLICT DO NOTHING;

update practice_ticket pt
set final_mentor_review_id=1,
    final_mark=3,
    recommend_to_hire= true
where begin_of_practice = DATE'2022-05-22'
  and end_of_practice = DATE'2022-06-11'
  and mentor_id = 2
  and student_id = 2
  and programming_language = 'js'
  and final_mark is null;

update practice_ticket pt
set final_mentor_review_id=1,
    final_mark=2,
    recommend_to_hire= true
where begin_of_practice = DATE'2022-05-22'
  and end_of_practice = DATE'2022-06-11'
  and mentor_id = 2
  and student_id = 2
  and programming_language = 'html'
  and final_mark is null;


insert into student (id, contact_data, full_name, study_course, study_group, test_result)
values (3, 'telegram:ecb', 'vasya vasya', '4', '10', 55)ON CONFLICT DO NOTHING;

insert into practice_ticket (begin_of_practice, end_of_practice, mentor_id, programming_language, student_id,
                             final_mark, recommend_to_hire, task_name, final_mentor_review_id)
values (DATE'2022-05-22', DATE'2022-06-11', 2, 'html', 3, null, false, 'Lending page', null)ON CONFLICT DO NOTHING;

insert into weekly_study_review (id, text_review, practice_ticket_begin_of_practice, practice_ticket_end_of_practice,
                                 practice_ticket_mentor_id, practice_ticket_programming_language,
                                 practice_ticket_student_id)
values (8, 'все классно', DATE'2022-05-22', DATE'2022-06-11', 2, 'html', 3)ON CONFLICT DO NOTHING;

insert into weekly_study_review (id, text_review, practice_ticket_begin_of_practice, practice_ticket_end_of_practice,
                                 practice_ticket_mentor_id, practice_ticket_programming_language,
                                 practice_ticket_student_id)
values (9, 'все классно', DATE'2022-05-22', DATE'2022-06-11', 2, 'html', 3)ON CONFLICT DO NOTHING;

insert into weekly_study_review (id, text_review, practice_ticket_begin_of_practice, practice_ticket_end_of_practice,
                                 practice_ticket_mentor_id, practice_ticket_programming_language,
                                 practice_ticket_student_id)
values (10, 'все хорошо', DATE'2022-05-22', DATE'2022-06-11', 2, 'html', 3)ON CONFLICT DO NOTHING;

insert into final_study_review (id, text_review, practice_ticket_begin_of_practice, practice_ticket_end_of_practice,
                                practice_ticket_mentor_id, practice_ticket_programming_language,
                                practice_ticket_student_id)
values (3, 'все классно', DATE'2022-05-22', DATE'2022-06-11', 2, 'html', 3)ON CONFLICT DO NOTHING;

update practice_ticket pt
set final_mentor_review_id=1,
    final_mark=3,
    recommend_to_hire= false
where begin_of_practice = DATE'2022-05-22'
  and end_of_practice = DATE'2022-06-11'
  and mentor_id = 2
  and student_id = 3
  and programming_language = 'html'
  and final_mark is null
;

/*
 SET next sequence value if not set before to right work sequence generation after insert data.sql rows
 3 is max student id in data.sql rows
 */
SELECT setval('hibernate_sequence', 9)
from student
where 3 >= (select max(st.id) from student st);