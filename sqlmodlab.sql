CREATE TABLE modlab.user (
    user_id VARCHAR(200) NOT NULL UNIQUE,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    username VARCHAR(45) NOT NULL UNIQUE,
    password_hash VARCHAR(200) NOT NULL,
    email VARCHAR(45) NOT NULL UNIQUE,
    phone VARCHAR(45) NOT NULL,
    created_at DATETIME NOT NULL,
    role BOOLEAN NOT NULL,
    PRIMARY KEY (user_id)
);



SELECT * FROM modlab.user;

INSERT INTO modlab.user
(user_id, first_name, last_name, username, password_hash, email, phone, created_at, role)
VALUES
("e493b02b-1860-47aa-8522-f6a03212993a", "Ash", "Grau", "ElMejorDeTodos",
 "f688ae26e9cfa3ba6235477831d5122e", "ashgrau@gmail.com", "719371945", "2022-06-30 00:00:00", true),

("2b5425d7-96cc-40b5-bf7a-1afe7255f252", "Alex", "Salas", "ElMasMejor",
 "6e6e2ddb6346ce143d19d79b3358c16a", "alexsalas@gmail.com", "937184926", "2022-06-30 00:00:00", true),

("eb08dbf1-ecab-46a2-8397-f8a691ac381d", "David", "Espinosa", "NoElMejorDeTodos",
 "30096b0fb740b338508de00821f8497a", "davideo@gmail.com", "748194726", "2022-06-30 00:00:00", true);




DROP TABLE IF EXISTS modlab.shipping_address;

CREATE TABLE modlab.shipping_address (
    address_id INT NOT NULL AUTO_INCREMENT,
    user_id VARCHAR(200) NOT NULL, -- Clave foránea
    address VARCHAR(200) NOT NULL,
    zip_code VARCHAR(200) NOT NULL,
    city VARCHAR(200) NOT NULL,
    state VARCHAR(200) NOT NULL,
    country VARCHAR(200) NOT NULL,
    PRIMARY KEY (address_id),
    FOREIGN KEY (user_id) REFERENCES modlab.user(user_id)
);


SELECT * FROM modlab.shipping_address;

INSERT INTO modlab.shipping_address
(user_id, address, zip_code, city, state, country)
VALUES
("e493b02b-1860-47aa-8522-f6a03212993a", "Plaza Catalunya,2", "08850", "Barcelona", "Catalunya", "Spain"),
("2b5425d7-96cc-40b5-bf7a-1afe7255f252", "Carrer del Moc", "08850", "Barcelona", "Catalunya", "Spain"),
("eb08dbf1-ecab-46a2-8397-f8a691ac381d", "Avinguda del MataMoros", "08850", "Barcelona", "Catalunya", "Spain");




CREATE TABLE modlab.review (
    review_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    product_id CHAR(32) NOT NULL,
    user_id VARCHAR(200) NOT NULL,
    rating INT NOT NULL,
    comment TEXT,
    review_date DATETIME NOT NULL,
    FOREIGN KEY (product_id) REFERENCES modlab.product(product_id),
    FOREIGN KEY (user_id) REFERENCES modlab.user(user_id)
);


SELECT * FROM modlab.review;

INSERT INTO modlab.review (product_id, user_id, rating, comment, review_date)
VALUES 
-- Review para SteelSeries Apex Pro
('a1b2c3d4e5f607182930404142434445', 'e493b02b-1860-47aa-8522-f6a03212993a', 5, 'Una experiencia de compra excelente. El envío fue rápido.', '2025-04-01 10:30:00'),

-- Review para Asus ROG Strix Scope NX Deluxe
('b2c3d4e5f60718293040414243444546', '2b5425d7-96cc-40b5-bf7a-1afe7255f252', 4, 'El teclado llegó en perfecto estado. Lo recomiendo.', '2025-04-02 14:15:00'),

-- Review para Aukey KM-G14
('c3d4e5f6071829304041424344454647', 'eb08dbf1-ecab-46a2-8397-f8a691ac381d', 3, 'El producto es bueno, pero el envío tardó más de lo esperado.', '2025-04-03 18:45:00'),

-- Review para HyperX Alloy Origins 60
('d4e5f607182930404142434445464748', 'e493b02b-1860-47aa-8522-f6a03212993a', 5, 'Fantástico para gaming. Tamaño ideal y muy sensible.', '2025-04-04 12:00:00'),

-- Review para Sharkoon Skiller Mech SGK3
('e5f60718293040414243444546474849', '2b5425d7-96cc-40b5-bf7a-1afe7255f252', 4, 'Buena relación calidad-precio. Recomendado para principiantes.', '2025-04-05 16:45:00');






/*PRODUCT*/

SELECT * FROM modlab.product;

CREATE TABLE modlab.product (
    product_id CHAR(32) NOT NULL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    description VARCHAR(1024) NOT NULL,
    price DOUBLE NOT NULL,
    stock_quantity INT NOT NULL,
    rating DOUBLE NOT NULL,
    image_url TEXT NOT NULL, -- Lista separada por comas
    brand VARCHAR(255) NOT NULL
);



INSERT INTO modlab.product (
    product_id, name, description, price, stock_quantity, rating, image_url, brand
) VALUES
('a1b2c3d4e5f607182930404142434445', 'Intel Core i9-13900K', 'CPU de alto rendimiento con 24 núcleos y arquitectura híbrida.', 699.99, 25, 4.8, 'https://example.com/images/i9.jpg', 'Intel'),
('b2c3d4e5f60718293040414243444546', 'AMD Ryzen 9 7950X', 'Procesador de 16 núcleos ideal para multitarea extrema.', 649.99, 30, 4.7,  'https://example.com/images/ryzen9.jpg', 'AMD'),
('c3d4e5f6071829304041424344454647', 'Intel Core i7-13700K', 'Gran equilibrio entre rendimiento gaming y productividad.', 439.99, 40, 4.5,  'https://example.com/images/i7.jpg', 'Intel'),
('d4e5f607182930404142434445464748', 'AMD Ryzen 7 7700X', 'Excelente opción para jugadores y creadores de contenido.', 399.99, 50, 4.6,  'https://example.com/images/ryzen7.jpg', 'AMD'),
('e5f60718293040414243444546474849', 'Intel Core i5-13600K', 'CPU potente de gama media con excelente eficiencia.', 319.99, 60, 4.4, 'https://example.com/images/i5.jpg,https://example.com/images/i6.jpg', 'Intel');


INSERT INTO modlab.product (
    product_id, name, description, price, stock_quantity, rating, image_url, brand
) VALUES
('f1a2b3c4d5e607182930404142434455', 'WD Blue 1TB', 'Disco duro mecánico para almacenamiento general', 49.99, 25, 4.1, 'https://example.com/images/wdblue.jpg', 'Western Digital'),
('f2b3c4d5e60718293040414243445546', 'Samsung 980 PRO 2TB', 'SSD NVMe de alto rendimiento', 149.99, 20, 4.8, 'https://example.com/images/980pro.jpg', 'Samsung'),
('f3c4d5e6071829304041424344554647', 'Crucial MX500 500GB', 'SSD SATA ideal para tareas cotidianas', 79.90, 35, 4.5, 'https://example.com/images/mx500.jpg', 'Crucial'),
('f4d5e607182930404142434455464748', 'Kingston A2000 1TB', 'SSD NVMe económico y eficiente', 89.90, 40, 4.4, 'https://example.com/images/a2000.jpg', 'Kingston'),
('f5e60718293040414243445546474849', 'Seagate Barracuda 4TB', 'Disco duro de gran capacidad', 109.90, 15, 4.0, 'https://example.com/images/barracuda.jpg', 'Seagate');


INSERT INTO modlab.product (
    product_id, name, description, price, stock_quantity, rating, image_url, brand
) VALUES
('a1a2b3c4d5e607182930404142434455', 'ASUS ROG STRIX Z790-E', 'Placa base ATX con soporte para DDR5 y chipset Z790. Ideal para gaming de alto rendimiento.', 329.99, 20, 4.8, 'https://example.com/images/z790e.jpg', 'ASUS'),
('a2b3c4d5e60718293040414243445546', 'MSI B550M PRO-VDH WIFI', 'Placa base Micro-ATX con chipset B550 y soporte para DDR4. Excelente para PC de oficina o gaming ligero.', 129.99, 35, 4.5, 'https://example.com/images/b550m.jpg', 'MSI'),
('a3c4d5e6071829304041424344554647', 'Gigabyte H610I DDR5', 'Mini-ITX compacta ideal para HTPCs, con soporte para procesadores Intel y DDR5.', 119.99, 15, 4.2, 'https://example.com/images/h610i.jpg', 'Gigabyte'),
('a4d5e607182930404142434455464748', 'ASRock X670E Steel Legend', 'Placa base ATX de gama alta con múltiples puertos M.2, DDR5 y chipset X670E.', 299.99, 10, 4.7, 'https://example.com/images/x670e.jpg', 'ASRock'),
('a5e60718293040414243445546474849', 'Biostar A520MH', 'Placa base económica Micro-ATX con soporte para DDR4 y chipset A520. Ideal para PCs básicos.', 79.99, 25, 4.1, 'https://example.com/images/a520mh.jpg', 'Biostar');

INSERT INTO modlab.product (
    product_id, name, description, price, stock_quantity, rating, image_url, brand
) VALUES
('b1a2b3c4d5e607182930404142434455', 'Corsair RM750x', 'Fuente modular de 750W con certificación 80+ Gold', 119.99, 25, 4.7, 'https://example.com/img/rm750x.jpg', 'Corsair'),
('b2b3c4d5e60718293040414243445546', 'Corsair CV550', 'Fuente de alimentación básica de 550W', 49.99, 40, 4.3, 'https://example.com/img/cv550.jpg', 'Corsair'),
('b3c4d5e6071829304041424344554647', 'Seasonic SP750', 'Fuente SFX de 750W para mini PCs', 129.99, 15, 4.8, 'https://example.com/img/sp750.jpg', 'Seasonic'),
('b4d5e607182930404142434455464748', 'Corsair RM650', 'Fuente de alimentación modular de 650W', 99.99, 30, 4.5, 'https://example.com/img/rm650.jpg', 'Corsair'),
('b5e60718293040414243445546474849', 'Corsair CX450', 'Fuente económica de 450W', 39.99, 50, 4.1, 'https://example.com/img/cx450.jpg', 'Corsair');


INSERT INTO modlab.product (
    product_id, name, description, price, stock_quantity, rating, image_url, brand
) VALUES
('r1a2b3c4d5e607182930404142434455', 'Corsair Vengeance LPX 16GB', 'RAM DDR4 de alto rendimiento con latencia CL16.', 74.99, 50, 4.6, 'img1.jpg,img2.jpg', 'Corsair'),
('r2b3c4d5e60718293040414243445546', 'G.Skill Ripjaws V 32GB', 'Kit de memoria DDR4 32GB (2x16GB) 3600MHz.', 129.90, 40, 4.7, 'img3.jpg,img4.jpg', 'G.Skill'),
('r3c4d5e6071829304041424344554647', 'Kingston Fury Beast DDR5', 'Módulo DDR5 de 16GB con iluminación RGB y latencia CL30.', 109.99, 30, 4.5, 'img5.jpg,img6.jpg', 'Kingston'),
('r4d5e607182930404142434455464748', 'Crucial 8GB DDR4', 'Memoria estándar DDR4 para equipos de oficina o uso general.', 29.99, 60, 4.3, 'img7.jpg', 'Crucial'),
('r5e60718293040414243445546474849', 'TeamGroup T-Force DDR5 32GB', 'RAM DDR5 de alto rendimiento para gaming.', 159.99, 25, 4.8, 'img8.jpg,img9.jpg', 'TeamGroup');

INSERT INTO modlab.product (
    product_id, name, description, price, stock_quantity, rating, image_url, brand
) VALUES
('t6a2b3c4d5e607182930404142434450', 'Phanteks Eclipse P400A', 'Torre ATX con excelente flujo de aire y panel frontal de malla.', 89.95, 30, 4.7, 'https://example.com/img/p400a.jpg', 'Phanteks'),
('t7b3c4d5e60718293040414243445046', 'Be Quiet! Pure Base 500DX', 'Chasis silencioso con gran refrigeración y diseño elegante.', 99.90, 25, 4.8, 'https://example.com/img/500dx.jpg', 'Be Quiet!'),
('t8c4d5e6071829304041424344504647', 'Fractal Design Meshify C', 'Torre compacta ATX con excelente flujo de aire y diseño moderno.', 109.90, 20, 4.6, 'https://example.com/img/meshifyc.jpg', 'Fractal Design'),
('t9d5e607182930404142434450464748', 'Cooler Master MasterBox NR600', 'Diseño minimalista con panel frontal de malla y USB-C.', 79.99, 40, 4.5, 'https://example.com/img/nr600.jpg', 'Cooler Master'),
('t0e60718293040414243445046474849', 'SilverStone Fara R1', 'Torre Micro-ATX con gran ventilación y diseño compacto.', 59.99, 45, 4.3, 'https://example.com/img/farar1.jpg', 'SilverStone');


INSERT INTO modlab.product (
    product_id, name, description, price, stock_quantity, rating, image_url, brand
) VALUES
('v1a2b3c4d5e607182930404142434451', 'Ventilador ARGB Pro', 'Ventilador de alto rendimiento con iluminación ARGB y control PWM.', 29.99, 150, 4.7, 'https://example.com/images/ventilador-argb-pro.jpg', 'Corsair'),
('v2a2b3c4d5e607182930404142434452', 'SilentFan 120', 'Ventilador silencioso con diseño optimizado para flujo de aire.', 19.90, 200, 4.3, 'https://example.com/images/silentfan-120.jpg', 'Noctua'),
('v3a2b3c4d5e607182930404142434453', 'ARGB Ring Fan', 'Ventilador con anillo LED RGB direccionable y rodamientos hidráulicos.', 22.50, 120, 4.6, 'https://example.com/images/argb-ring.jpg', 'Thermaltake'),
('v4a2b3c4d5e607182930404142434454', 'Basic Airflow 80', 'Ventilador básico de 80mm con gran flujo de aire y bajo nivel de ruido.', 12.75, 300, 4.0, 'https://example.com/images/basic-airflow-80.jpg', 'Arctic'),
('v5a2b3c4d5e607182930404142434455', 'RGB Performance 140', 'Ventilador de 140mm con LEDs RGB y gran presión estática.', 34.95, 90, 4.8, 'https://example.com/images/rgb-performance-140.jpg', 'CoolerMaster');






/*CPU*/


SELECT * FROM modlab.cpu;

CREATE TABLE modlab.cpu (
    product_id CHAR(32) NOT NULL PRIMARY KEY,
    base_clock VARCHAR(50) NOT NULL,
    cache_memory VARCHAR(50) NOT NULL,
    fragile BOOLEAN NOT NULL,
    frecuency VARCHAR(50) NOT NULL,
    has_integrated_graphics BOOLEAN NOT NULL,
    high DOUBLE NOT NULL,
    length DOUBLE NOT NULL,
    lithography VARCHAR(50) NOT NULL,
    model VARCHAR(100) NOT NULL,
    number_threads INT NOT NULL,
    processor_core INT NOT NULL,
    socket VARCHAR(50) NOT NULL,
    tdp VARCHAR(50) NOT NULL,
    weight DOUBLE NOT NULL,
    width DOUBLE NOT NULL,
    CONSTRAINT fk_cpu_product FOREIGN KEY (product_id) REFERENCES modlab.product(product_id)
);




INSERT INTO modlab.cpu (
    product_id, base_clock, cache_memory, fragile, frecuency, has_integrated_graphics, high, length, lithography, model, number_threads, processor_core, socket, tdp, weight, width
) VALUES
('a1b2c3d4e5f607182930404142434445', 3.0, '36 MB', false, 5.8, true, 4.4, 7.6, 10, 'i9-13900K', 32, 24, 'LGA1700', 125, 0.7, 4.4),
('b2c3d4e5f60718293040414243444546', 4.5, '64 MB', false, 5.7, false, 4.5, 7.5, 5, '7950X', 32, 16, 'AM5', 170, 0.6, 4.3),
('c3d4e5f6071829304041424344454647', 3.4, '30 MB', false, 5.4, true, 4.3, 7.4, 10, 'i7-13700K', 24, 16, 'LGA1700', 125, 0.65, 4.3),
('d4e5f607182930404142434445464748', 4.5, '32 MB', false, 5.4, false, 4.2, 7.3, 5, '7700X', 16, 8, 'AM5', 105, 0.58, 4.2),
('e5f60718293040414243444546474849', 3.5, '24 MB', false, 5.1, true, 4.1, 7.1, 10, 'i5-13600K', 20, 14, 'LGA1700', 125, 0.55, 4.1);






/*GraphicCard*/



CREATE TABLE modlab.graphic_card (
    product_id CHAR(32) NOT NULL PRIMARY KEY,
    color VARCHAR(50) NOT NULL,
    memory INT NOT NULL,
    memory_type VARCHAR(50) NOT NULL,
    recommended_power_supply INT NOT NULL,
    core_clock DOUBLE NOT NULL,
    boost_clock DOUBLE NOT NULL,
    tdp INT NOT NULL,
    interface_connection VARCHAR(150) NOT NULL,
    fragile BOOLEAN NOT NULL,
    high DOUBLE NOT NULL,
    length DOUBLE NOT NULL,
    width DOUBLE NOT NULL,
    weight DOUBLE NOT NULL,
    CONSTRAINT fk_graphic_card_product FOREIGN KEY (product_id) REFERENCES modlab.product(product_id)
);

INSERT INTO modlab.graphic_card (
    product_id, color, memory, memory_type, recommended_power_supply, core_clock, boost_clock, tdp, 
    interface_connection, fragile, high, length, width, weight
) VALUES
('a1b2c3d4e5f607182930404142434445', 'Black', 8, 'GDDR6', 650, 1.6, 2.1, 250, 'PCIe 4.0 x16', false, 4.4, 7.6, 5.2, 1.2),
('b2c3d4e5f60718293040414243444546', 'Silver', 12, 'GDDR6X', 750, 1.8, 2.5, 350, 'PCIe 4.0 x16', true, 4.5, 7.8, 5.4, 1.4),
('c3d4e5f6071829304041424344454647', 'Black', 8, 'GDDR5', 500, 1.4, 2.0, 200, 'PCIe 3.0 x16', false, 4.3, 7.4, 5.0, 1.1),
('d4e5f607182930404142434445464748', 'White', 6, 'GDDR5', 450, 1.5, 2.2, 180, 'PCIe 3.0 x16', false, 4.2, 7.3, 4.9, 1.0),
('e5f60718293040414243444546474849', 'Red', 12, 'GDDR6', 800, 1.9, 2.6, 400, 'PCIe 4.0 x16', true, 4.6, 7.9, 5.5, 1.5);



/*power_supply*/



CREATE TABLE modlab.powersupply  (
    product_id CHAR(32) NOT NULL PRIMARY KEY,
    model VARCHAR(20) NOT NULL,
    color VARCHAR(15) NOT NULL,
    total_power INT NOT NULL,
    connectors VARCHAR(50) NOT NULL,
    frecuency VARCHAR(15) NOT NULL,
    high DOUBLE NOT NULL,
    width DOUBLE NOT NULL,
    length DOUBLE NOT NULL,
    weight DOUBLE NOT NULL,
    fragile BOOLEAN NOT NULL,
    CONSTRAINT fk_power_supply_product FOREIGN KEY (product_id) REFERENCES modlab.product(product_id)
);

INSERT INTO modlab.powersupply  (
    product_id, model, color, total_power, connectors, frecuency,
    high, width, length, weight, fragile
) VALUES
('b1a2b3c4d5e607182930404142434455', 'RM750x', 'Negro', 750, '24-pin, 8-pin CPU, 2x PCIe', '50-60Hz', 3.4, 3.0, 7.2, 1.5, false),
('b2b3c4d5e60718293040414243445546', 'CV550', 'Negro', 550, '24-pin, 8-pin CPU, 1x PCIe', '50Hz', 3.2, 2.8, 6.8, 1.3, false),
('b3c4d5e6071829304041424344554647', 'SP750', 'Blanco', 750, '24-pin, 2x 8-pin CPU, 3x PCIe', '60Hz', 3.5, 3.1, 7.5, 1.6, true),
('b4d5e607182930404142434455464748', 'RM650', 'Negro', 650, '24-pin, 8-pin CPU, 2x PCIe', '50-60Hz', 3.3, 2.9, 7.0, 1.4, false),
('b5e60718293040414243445546474849', 'CX450', 'Negro', 450, '24-pin, 8-pin CPU', '50Hz', 3.0, 2.7, 6.5, 1.2, true);





/*RAM*/




CREATE TABLE modlab.ram (
    product_id CHAR(32) NOT NULL PRIMARY KEY,
    latency VARCHAR(20) NOT NULL,
    type_ddr VARCHAR(15) NOT NULL,
    internal_memory INT NOT NULL,
    memory_speed VARCHAR(32) NOT NULL,
    led BOOLEAN NOT NULL,
    memory_size INT NOT NULL,
    number_of_modules INT NOT NULL,
    voltage VARCHAR(32) NOT NULL,
    high DOUBLE NOT NULL,
    width DOUBLE NOT NULL,
    length DOUBLE NOT NULL,
    weight DOUBLE NOT NULL,
    fragile BOOLEAN NOT NULL,
    CONSTRAINT fk_ram_product FOREIGN KEY (product_id) REFERENCES modlab.product(product_id)
);




INSERT INTO modlab.ram (
    product_id, latency, type_ddr, internal_memory, memory_speed,
    led, memory_size, number_of_modules, voltage,
    high, width, length, weight, fragile
) VALUES
('c1a2b3c4d5e607182930404142434455', 'CL16', 'DDR4', 16, '3200MHz', true, 16, 2, '1.35V', 3.2, 1.4, 13.5, 0.15, false),
('c2b3c4d5e60718293040414243445546', 'CL18', 'DDR4', 32, '3600MHz', false, 32, 2, '1.2V', 3.5, 1.5, 14.0, 0.18, false),
('c3c4d5e6071829304041424344554647', 'CL30', 'DDR5', 16, '5200MHz', true, 16, 1, '1.1V', 3.1, 1.3, 13.0, 0.14, true),
('c4d5e607182930404142434455464748', 'CL20', 'DDR4', 8, '2666MHz', false, 8, 2, '1.2V', 3.0, 1.2, 12.5, 0.12, false),
('c5e60718293040414243445546474849', 'CL28', 'DDR5', 32, '5600MHz', true, 32, 2, '1.25V', 3.6, 1.6, 14.5, 0.20, true);


/*tower*/


CREATE TABLE modlab.tower (
    product_id CHAR(32) NOT NULL PRIMARY KEY,
    formFactor VARCHAR(32) NOT NULL,
    color VARCHAR(32) NOT NULL,
    connectors VARCHAR(50) NOT NULL,
    material VARCHAR(50) NOT NULL,
    fanSupport INT NOT NULL,
    maxGpuLength INT NOT NULL,
    maxCpuCoolerHeight INT NOT NULL,
    high DOUBLE NOT NULL,
    width DOUBLE NOT NULL,
    length DOUBLE NOT NULL,
    weight DOUBLE NOT NULL,
    fragile BOOLEAN NOT NULL,
    CONSTRAINT fk_tower_product FOREIGN KEY (product_id) REFERENCES modlab.product(product_id)
);





INSERT INTO modlab.tower (
    product_id, formFactor, color, connectors, material,
    fanSupport, maxGpuLength, maxCpuCoolerHeight,
    high, width, length, weight, fragile
) VALUES
('t6a2b3c4d5e607182930404142434450', 'ATX', 'Negro', 'USB 3.0, Audio HD', 'Acero y vidrio templado', 2, 360, 165, 45.0, 21.0, 43.0, 6.5, false),
('t7b3c4d5e60718293040414243445046', 'ATX', 'Blanco', 'USB 3.1, Audio HD', 'Acero y plástico', 2, 370, 170, 46.5, 22.0, 45.5, 6.8, false),
('t8c4d5e6071829304041424344504647', 'ATX', 'Negro', 'USB 3.1, Audio HD', 'Aluminio y acero', 2, 340, 160, 44.0, 20.0, 42.0, 6.0, false),
('t9d5e607182930404142434450464748', 'ATX', 'Negro', 'USB-C, USB 3.0, Audio HD', 'Acero y malla', 2, 330, 165, 43.0, 21.5, 44.0, 5.9, false),
('t0e60718293040414243445046474849', 'Micro-ATX', 'Negro', 'USB 2.0, USB 3.0', 'Acero', 1, 310, 150, 40.5, 19.0, 40.0, 5.3, true);


/*harddrive*/


CREATE TABLE modlab.hard_drive (
    product_id CHAR(32) NOT NULL PRIMARY KEY,
    storage_interface VARCHAR(50) NOT NULL,
    ssd BOOLEAN NOT NULL,
    random_reading INT NOT NULL,
    capacity INT NOT NULL,
    write_speed INT NOT NULL,
    form_factor DOUBLE NOT NULL,
    high DOUBLE NOT NULL,
    width DOUBLE NOT NULL,
    length DOUBLE NOT NULL,
    weight DOUBLE NOT NULL,
    fragile BOOLEAN NOT NULL,
    CONSTRAINT fk_hard_drive_product FOREIGN KEY (product_id) REFERENCES modlab.product(product_id)
);



INSERT INTO modlab.hard_drive (
    product_id, storage_interface, ssd, random_reading, capacity, write_speed, form_factor, high, width, length, weight, fragile
) VALUES
('f1a2b3c4d5e607182930404142434455', 'SATA III', false, 120, 1000, 150, 3.5, 2.5, 3.5, 10.0, 0.75, false),
('f2b3c4d5e60718293040414243445546', 'NVMe M.2', true, 250000, 2000, 220, 2.5, 1.0, 2.5, 8.0, 0.3, false),
('f3c4d5e6071829304041424344554647', 'SATA III', true, 100000, 500, 180, 2.5, 1.5, 2.0, 7.0, 0.4, true),
('f4d5e607182930404142434455464748', 'NVMe M.2', true, 280000, 1000, 240, 2.5, 1.2, 2.2, 6.5, 0.35, false),
('f5e60718293040414243445546474849', 'SATA III', false, 110, 4000, 160, 3.5, 2.7, 3.4, 10.2, 0.85, true);






/*ventilation*/


CREATE TABLE ventilation (
    product_id VARCHAR(100) NOT NULL,
    leds BOOLEAN NOT NULL,
    color VARCHAR(32) NOT NULL,
    max_airflow INT NOT NULL,
    rotation_speed INT NOT NULL,
    noise_level DOUBLE NOT NULL,
    bearing_type VARCHAR(50) NOT NULL,
    input_voltage INT NOT NULL,
    high DOUBLE NOT NULL,
    width DOUBLE NOT NULL,
    length DOUBLE NOT NULL,
    weight DOUBLE NOT NULL,
    fragile BOOLEAN NOT NULL,
    PRIMARY KEY (product_id),
    CONSTRAINT fk_ventilation_product FOREIGN KEY (product_id) REFERENCES product(product_id)
);

INSERT INTO modlab.ventilation (
    product_id, leds, color, max_airflow, rotation_speed, noise_level,
    bearing_type, input_voltage, high, width, length, weight, fragile
) VALUES
('v1a2b3c4d5e607182930404142434451', true, 'Negro', 75, 1500, 28.5, 'Hydraulic Bearing', 12, 2.5, 12.0, 12.0, 0.3, false),
('v2a2b3c4d5e607182930404142434452', false, 'Marrón', 65, 1300, 19.2, 'SSO2 Bearing', 12, 2.0, 12.0, 12.0, 0.25, false),
('v3a2b3c4d5e607182930404142434453', true, 'Negro con RGB', 80, 1600, 30.0, 'Hydraulic Bearing', 12, 2.5, 12.0, 12.0, 0.32, false),
('v4a2b3c4d5e607182930404142434454', false, 'Blanco', 60, 1400, 25.0, 'Sleeve Bearing', 12, 2.0, 8.0, 8.0, 0.2, false),
('v5a2b3c4d5e607182930404142434455', true, 'Negro con RGB', 90, 1700, 29.5, 'Ball Bearing', 12, 2.8, 14.0, 14.0, 0.4, false);


/*motherboard*/



CREATE TABLE modlab.motherboard  (
    product_id CHAR(32) NOT NULL PRIMARY KEY,
    cpu BOOLEAN NOT NULL,
    memory VARCHAR(150) NOT NULL,
    storage VARCHAR(50) NOT NULL,
    factor_form VARCHAR(150) NOT NULL,
    socket VARCHAR(25) NOT NULL,
    chipset VARCHAR(25) NOT NULL,
    memory_type VARCHAR(25) NOT NULL,
    memory_slots INT NOT NULL,
    max_memory INT NOT NULL,
    high DOUBLE NOT NULL,
    width DOUBLE NOT NULL,
    length DOUBLE NOT NULL,
    weight DOUBLE NOT NULL,
    fragile BOOLEAN NOT NULL,
    CONSTRAINT fk_mother_board_product FOREIGN KEY (product_id) REFERENCES modlab.product(product_id)
);

INSERT INTO modlab.motherboard (
    product_id, cpu, memory, storage, factor_form, socket, chipset, memory_type, memory_slots, max_memory,
    high, width, length, weight, fragile
) VALUES
('a1a2b3c4d5e607182930404142434455', true, '2x DDR5, hasta 64GB', '2x M.2, 4x SATA III', 'ATX', 'LGA1700', 'Z790', 'DDR5', 2, 128, 3.5, 3.5, 8.0, 1.2, false),
('a2b3c4d5e60718293040414243445546', false, '4x DDR4, hasta 128GB', '6x SATA III', 'Micro-ATX', 'AM4', 'B550', 'DDR4', 4, 128, 3.2, 3.0, 7.5, 1.1, true),
('a3c4d5e6071829304041424344554647', true, '2x DDR5, hasta 64GB', '1x M.2, 4x SATA III', 'Mini-ITX', 'LGA1700', 'H610', 'DDR5', 2, 64, 2.8, 2.9, 6.5, 0.9, false),
('a4d5e607182930404142434455464748', false, '4x DDR5, hasta 128GB', '3x M.2, 4x SATA III', 'ATX', 'AM5', 'X670E', 'DDR5', 4, 128, 3.6, 3.4, 8.5, 1.3, false),
('a5e60718293040414243445546474849', true, '2x DDR4, hasta 32GB', '2x SATA III', 'Micro-ATX', 'AM4', 'A520', 'DDR4', 2, 64, 3.0, 3.0, 7.0, 1.0, true);



/*PAGAMENT*/

SELECT * FROM modlab.payment_method;


CREATE TABLE modlab.payment_method (
    payment_id VARCHAR(32) NOT NULL PRIMARY KEY,
    payment_method VARCHAR(30) NOT NULL,
    card_number VARCHAR(19) NOT NULL,
    card_expiry VARCHAR(10) NOT NULL,
    card_cvv VARCHAR(4) NOT NULL,
    user_id VARCHAR(200) NOT NULL,
    CONSTRAINT fk_payment_user FOREIGN KEY (user_id) REFERENCES modlab.user(user_id)
);



/*order*/


CREATE TABLE modlab.`order` (
    order_id VARCHAR(32) NOT NULL PRIMARY KEY,
    order_date DATETIME NOT NULL,
    status VARCHAR(20) NOT NULL,
    user_id VARCHAR(200) NOT NULL,
    payment_id VARCHAR(32) NOT NULL,
    total_price DOUBLE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES modlab.user(user_id),
    FOREIGN KEY (payment_id) REFERENCES modlab.payment_method(payment_id)
);



INSERT INTO modlab.`order` (
    order_id, order_date, status, user_id, payment_id, total_price
) VALUES
('ord000000000000000000000000000001', NOW(), 'CONFIRMED',
 'e493b02b-1860-47aa-8522-f6a03212993a', 'pay000000000000000000000000000001', 849.99),

('ord000000000000000000000000000002', NOW(), 'CREATED',
 '2b5425d7-96cc-40b5-bf7a-1afe7255f252', 'pay000000000000000000000000000002', 129.99),

('ord000000000000000000000000000003', NOW(), 'DELIVERED',
 'eb08dbf1-ecab-46a2-8397-f8a691ac381d', 'pay000000000000000000000000000003', 299.50),

('ord000000000000000000000000000004', NOW(), 'CONFIRMED',
 'e493b02b-1860-47aa-8522-f6a03212993a', 'pay000000000000000000000000000004', 749.00),

('ord000000000000000000000000000005', NOW(), 'CONFIRMED',
 '2b5425d7-96cc-40b5-bf7a-1afe7255f252', 'pay000000000000000000000000000005', 65.90);





/*ShopCart*/
SELECT * FROM modlab.shop_cart;

CREATE TABLE modlab.shop_cart (
    cart_id INT NOT NULL AUTO_INCREMENT,
    user_id VARCHAR(200) NOT NULL,
    product_id CHAR(32) NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY (cart_id),
    FOREIGN KEY (user_id) REFERENCES modlab.user(user_id),
    FOREIGN KEY (product_id) REFERENCES modlab.product(product_id)
);




-- Ash agrega un Intel Core i9-13900K al carrito (cantidad 1)
INSERT INTO shop_cart (user_id, product_id, quantity)
VALUES ('e493b02b-1860-47aa-8522-f6a03212993a', 'a1b2c3d4e5f607182930404142434445', 1);

-- Alex agrega una RAM Corsair Vengeance LPX 16GB (cantidad 2)
INSERT INTO shop_cart (user_id, product_id, quantity)
VALUES ('2b5425d7-96cc-40b5-bf7a-1afe7255f252', 'r1a2b3c4d5e607182930404142434455', 2);

-- David agrega una fuente Corsair RM750x (cantidad 1)
INSERT INTO shop_cart (user_id, product_id, quantity)
VALUES ('eb08dbf1-ecab-46a2-8397-f8a691ac381d', 'b1a2b3c4d5e607182930404142434455', 1);

-- Ash agrega también una caja Phanteks Eclipse P400A (cantidad 1)
INSERT INTO shop_cart (user_id, product_id, quantity)
VALUES ('e493b02b-1860-47aa-8522-f6a03212993a', 't6a2b3c4d5e607182930404142434450', 1);

-- Alex agrega un SSD Samsung 980 PRO 2TB (cantidad 1)
INSERT INTO shop_cart (user_id, product_id, quantity)
VALUES ('2b5425d7-96cc-40b5-bf7a-1afe7255f252', 'f2b3c4d5e60718293040414243445546', 1);