-- *회원서비스 
--1. 로그인 요청시 실행해야되는 sql문
SELECT * FROM MEMBER WHERE STATUS = 'Y' AND USER_ID = ? AND USER_PWD = ?;

--2. 회원가입 요청시 실행해야될 sql문 
INSERT 
INTO MEMBER
(
    USER_NO
  , USER_ID
  , USER_PWD
  , USER_NAME
  , PHONE
  , EMAIL
  , ADDRESS
  , INTEREST
) 
VALUES
(
    SEQ_UNO.NEXTVAL
   ,?
   ,?
   ,?
   ,?
   ,?
   ,?
   ,?
);

INSERT INTO MEMBER(USER_NO, USER_ID, USER_PWD, USER_NAME, PHONE, EMAIL, ADDRESS, INTEREST) VALUES(SEQ_UNO.NEXTVAL,?,?,?,?,?,?,?);

--3. 사용자가 정보변경 요청시 실행할 SQL문
UPDATE MEMBER
   SET USER_NAME = ?
     , PHONE = ?
     , EMAIL = ?
     , ADDRESS = ?
     , INTEREST = ?
     , MODIFY_DATE = SYSDATE
WHERE USER_ID = ?;

UPDATE MEMBER SET USER_NAME = ?, PHONE = ?, EMAIL = ?, ADDRESS = ?, INTEREST = ? WHERE USER_ID = ?

--->> 해당 회원의 아이디를 가지고 회원정보 조회해오는 SQL
SELECT * FROM MEMBER WHERE STATUS = 'Y' AND USER_ID = ?

--4. 비밀번호 변경 요청시 실행할 sql문 
UPDATE MEMBER
   SET USER_PWD =?
     , MODIFY_DATE = SYSDATE
WHERE USER_ID = ?
  AND USER_PWD = ?; 


UPDATE MEMBER SET USER_PWD =?, MODIFY_DATE = SYSDATE WHERE USER_ID = ? AND USER_PWD = ?; 

SELECT * FROM MEMBER WHERE USER_ID = 'user01';

UPDATE MEMBER SET STATUS='N' WHERE USER_ID = ? AND USER_PWD = ?;


-- * 공지사항 서비스
-- 1. 공지사항 전체 리스트 조회 요청시 실행할 sql문
SELECT
       NOTICE_NO
     , NOTICE_TITLE
     , USER_ID
     , COUNT
     , CREATE_DATE
  FROM NOTICE N
  JOIN MEMBER ON (NOTICE_WRITER=USER_NO)
 WHERE N.STATUS='Y'
 ORDER 
    BY NOTICE_NO DESC; 
    
--2.공지사항 작성하기 요청시 실행할 SQL문
INSERT 
  INTO NOTICE
  (
       NOTICE_NO
     , NOTICE_TITLE
     , NOTICE_CONTENT
     , NOTICE_WRITER
  )
  VALUES
  (
       SEQ_NNO.NEXTVAL
     , ?
     , ?
     , ?
  );

--3.사용자가 상세조회 요청시 실행할 sql문
--  > 조회수 증가시키는 update문
UPDATE
       NOTICE
   SET COUNT=COUNT+1
 WHERE NOTICE_NO = ?
   AND STATUS = 'Y';
   
-- > 그리고 나서 공지사항 상세조회
SELECT
       NOTICE_NO
     , NOTICE_TITLE
     , NOTICE_CONTENT
     , USER_ID
     , CREATE_DATE
  FROM NOTICE N
  JOIN MEMBER ON(NOTICE_WRITER=USER_NO)
 WHERE NOTICE_NO = ?
   AND N.STATUS = 'Y';
 
--5. 공지사항 수정 요청시 실행할 SQL문
UPDATE
       NOTICE
   SET NOTICE_TITLE = ?
     , NOTICE_CONTENT = ?
 WHERE NOTICE_N O= ?
 
 --6.  공지사항 삭제
UPDATE  
       NOTICE
   SET STATUS = 'N'
 WHERE NOTICE_NO = ?;
   
-- * 일반게시판 서비스
-- 1. 일반 게시판 총 갯수 조회요청시 실행할 sql문
SELECT COUNT(*)
  FROM BOARD
 WHERE BOARD_TYPE = 1 
   AND STATUS = 'Y';

-- 1-2. 사용자가 요청한 페이지에 보여져야할 일반 게시판 조회요청시 실행할 sql문
SELECT *
  FROM (
        SELECT 
               ROWNUM RNUM
             , A.*
         FROM (
                SELECT
                       BOARD_NO
                     , CATEGORY_NAME
                     , BOARD_TITLE
                     , USER_ID
                     , COUNT
                     , CREATE_DATE
                  FROM BOARD B
                  JOIN CATEGORY USING (CATEGORY_NO)
                  JOIN MEMBER ON (BOARD_WRITER=USER_NO)
                 WHERE B.STATUS = 'Y' 
                   AND BOARD_TYPE = 1
                 ORDER
                    BY BOARD_NO DESC
                 ) A
      )
   WHERE RNUM BETWEEN ? AND ?; 
    
COMMIT;

-- 2-1. 일반게시판 작성요청시 Board테이블에 insert할 sql문
INSERT
  INTO BOARD
    (
       BOARD_NO
     , BOARD_TYPE
     , CATEGORY_NO
     , BOARD_TITLE
     , BOARD_CONTENT
     , BOARD_WRITER
     , CREATE_DATE
    )
VALUES
    (
       SEQ_BNO.NEXTVAL
     , 1
     , ?
     , ?
     , ?
     , ?
     , SYSDATE
     );
     
--2-2. 첨부파일이 있을 경우 ATTACHMENT 테이블에 INSERT 할 SQL문
INSERT
  INTO ATTACHMENT
     ( 
       FILE_NO
     , REF_BNO
     , ORIGIN_NAME
     , CHANGE_NAME
     , FILE_PATH
     )
VALUES
     (
       SEQ_FNO.NEXTVAL
     , SEQ_BNO.CURRVAL  --성공적인 마지막 번호를 가져 오는거!! 위에서 받은 번호를 그대로 가젹오기 
     , ?
     , ?
     , ?
     );
     
--3. 일반 게시판 상세조회 요청시 실행할 sql문들
--3_1. 해당 게시글 찾아서 조회수 증가시키는 sql문
UPDATE
      BOARD
  SET COUNT = COUNT + 1
WHERE BOARD_NO = ?
  AND STATUS = 'Y';

-- 3-2 해당 게시글에 대한 정보 조회시 실행시킬 SQL문
SELECT
       BOARD_NO
     , CATEGORY_NAME
     , BOARD_TITLE
     , BOARD_CONTENT
     , USER_ID
     , CREATE_DATE
  FROM BOARD B
  JOIN CATEGORY USING(CATEGORY_NO)
  JOIN MEMBER ON (BOARD_WRITER = USER_NO)
 WHERE BOARD_NO = ?
   AND B.STATUS = 'Y'; 

--3_3. 해당 게시글에 딸려있는 첨부파일에 대한 정보 조회시 실행할 SQL문
SELECT
       FILE_NO
     , ORIGIN_NAME
     , CHANGE_NAME
     , FILE_PATH
  FROM ATTACHMENT
 WHERE REF_BNO = ?;
 
 --4.일반 게시판 정보 수정 요청시 실행할 sql문들 
 -- 공통적으로 수행할 SQL문
 UPDATE
        BOARD
    SET 




