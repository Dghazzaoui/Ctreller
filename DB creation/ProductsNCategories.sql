SELECT products.*, cat_name 
FROM products 
LEFT JOIN product_categories ON products.id = product_categories.product_id 
LEFT JOIN categories ON categories.id = product_categories.category_id;

