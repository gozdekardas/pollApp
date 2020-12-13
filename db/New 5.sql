/* Formatted on 3.12.2020 19:53:01 (QP5 v5.318) */
CREATE TABLE xx_questions
(
    question_id      NUMBER,
    question_text    VARCHAR2 (1000),
    created_by       VARCHAR2 (150),
    enabled          VARCHAR2 (1)
);



CREATE TABLE xx_responses
(
    response_id      NUMBER,
    question_id      NUMBER,
    response_text    VARCHAR2 (1000),
    created_by       VARCHAR2 (150),
    enabled          VARCHAR2 (1),
    answered         NUMBER
)


CREATE SEQUENCE xx_questions_seq

CREATE SEQUENCE xx_responses_seq


edit xx_questions

edit xx_responses

select xx_questions_seq.nextval from dual


edit xx_users