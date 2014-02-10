SELECT products.*, users.username, quantity
FROM products 
-- LEFT JOIN shopping_cart ON products.id = shopping_cart.product_id 
LEFT JOIN users ON products.id = users;
-- WHERE username = 'Suspendisse@facilisismagnatellus.edu';
