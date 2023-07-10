-- 코드를 입력하세요
SELECT * from PLACES where HOST_ID in (select HOST_ID from PLACES group by HOST_ID HAVING COUNT(ID)>= 2) order by ID;
-- select count(*) as count from PLACES group by HOST_ID