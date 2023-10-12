-- 코드를 입력하세요
SELECT month(START_DATE) as month, CAR_ID, count(HISTORY_ID) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where START_DATE between '2022-08-01' and '2022-10-31' 
and CAR_ID in (select CAR_ID from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
             where START_DATE between '2022-08-01' and '2022-10-31' 
               group by CAR_ID having count(*) >= 5)
 
group by CAR_ID, month
having RECORDS > 0
order by month, CAR_ID desc