# # # -- 코드를 입력하세요
SELECT 
    H.HISTORY_ID,
    CASE 
        WHEN (DATEDIFF(H.END_DATE, H.START_DATE)+1 < 7) THEN C.DAILY_FEE * (DATEDIFF(H.END_DATE, H.START_DATE)+1)
        WHEN (DATEDIFF(H.END_DATE, H.START_DATE)+1 < 30) THEN C.DAILY_FEE * (DATEDIFF(H.END_DATE, H.START_DATE)+1) * 
        (SELECT 100 - cast(SUBSTRING_INDEX(DISCOUNT_RATE, '%', 1) as unsigned) FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN WHERE DURATION_TYPE = "7일 이상" AND CAR_TYPE = "트럭") DIV 100
        WHEN (DATEDIFF(H.END_DATE, H.START_DATE)+1 < 90) THEN C.DAILY_FEE * (DATEDIFF(H.END_DATE, H.START_DATE)+1) * 
        (SELECT 100-cast(SUBSTRING_INDEX(DISCOUNT_RATE, '%', 1) as unsigned) FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN WHERE DURATION_TYPE = "30일 이상" AND CAR_TYPE = "트럭") DIV 100
        ELSE C.DAILY_FEE * (DATEDIFF(H.END_DATE, H.START_DATE)+1) * 
        (SELECT 100 - cast(SUBSTRING_INDEX(DISCOUNT_RATE, '%', 1) as unsigned) FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN WHERE DURATION_TYPE = "90일 이상" AND CAR_TYPE = "트럭") DIV 100
    END as FEE
FROM CAR_RENTAL_COMPANY_CAR as C
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY as H
ON C.CAR_ID = H.CAR_ID
WHERE C.CAR_TYPE = "트럭"
ORDER BY FEE DESC, H.HISTORY_ID DESC;

# SELECT * FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY WHERE HISTORY_ID = 527;
# SELECT * FROM CAR_RENTAL_COMPANY_CAR WHERE CAR_ID = 8
# SELECT * FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN;