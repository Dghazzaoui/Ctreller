SELECT cat_name, firstname, surname
FROM categories INNER JOIN staff ON categories.boss_id
= staff.id;