

SELECT * From orders;
SELECT * From customers;

# 【例7.49】在 customers 表和orders表中，查询所有客户，包括没有订单的客户，SQL语句如下：

SELECT customers.c_id, orders.o_num
FROM customers LEFT OUTER JOIN orders
                               ON customers.c_id = orders.c_id;




















































































