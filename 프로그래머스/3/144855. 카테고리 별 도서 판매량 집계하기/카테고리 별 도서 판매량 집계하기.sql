-- 코드를 입력하세요
SELECT b.category as CATEGORY, sum(s.sales) as TOTAL_SALES 
from book as b
join book_sales as s 
on b.book_id = s.book_id
where s.SALES_DATE like'2022-01%'
group by b.category
order by b.category