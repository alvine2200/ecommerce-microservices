INSERT INTO categories (name, description) VALUES
('Electronics', 'Devices and gadgets'),
('Books', 'Printed and digital books'),
('Clothing', 'Men and women clothing'),
('Furniture', 'Home and office furniture'),
('Toys', 'Toys and games for children');

INSERT INTO products (name, description, available_quantity, price, category_id) VALUES
('Smartphone', 'Latest Android smartphone', 150, 699.99, 1),
('Laptop', 'High performance laptop', 75, 1299.50, 1),
('Novel', 'Best-selling fiction novel', 300, 19.99, 2),
('Office Chair', 'Ergonomic chair for office use', 50, 199.95, 4),
('T-Shirt', '100% cotton unisex t-shirt', 500, 9.99, 3),
('Wooden Table', 'Dining table for six', 20, 499.00, 4),
('Puzzle Game', '1000-piece puzzle for kids', 200, 14.50, 5),
('E-Reader', 'Digital book reader with Wi-Fi', 80, 129.99, 2),
('Dress', 'Summer dress for women', 120, 39.95, 3),
('Bluetooth Headphones', 'Wireless noise-canceling headphones', 60, 249.90, 1);
