-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME,GENDER,
DATE_FORMAT(DATE_OF_BIRTH, "%Y-%m-%d") DATE_OF_BIRTH
from MEMBER_PROFILE
where DATE_OF_BIRTH like '%-03-%' and TLNO is not null and GENDER = "W"
order by MEMBER_ID 

