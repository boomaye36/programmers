-- 코드를 입력하세요
SELECT b.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY, 
sum(b.PRICE * s.sales) as TOTAL_SALES
from BOOK b, AUTHOR a, BOOK_SALES s
where b.AUTHOR_ID = a.AUTHOR_ID and b.BOOK_ID = s.BOOK_ID
and s.SALES_DATE like '2022-01-%'
group by a.AUTHOR_NAME, b.CATEGORY
order by a.AUTHOR_ID, b.CATEGORY desc