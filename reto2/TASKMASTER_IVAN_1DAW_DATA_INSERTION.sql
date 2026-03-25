-- ---------------------------------- --
-- 1. Inserción de Usuarios de prueba --
-- ---------------------------------- --
-- Nota: Las contraseñas simulan estar encriptadas
INSERT INTO Usuarios (nombre_usuario, email, password) VALUES
('laura_dev', 'laura.dev@email.com', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi'),
('carlos_m', 'carlos.m@email.com', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi'),
('ana_admin', 'ana.admin@email.com', '$2y$10$92IXUNpkjO0rOQ5byMi.Ye4oKoEa3Ro9llC/.og/at2.uheWG/igi');

-- -------------------------- --
-- 2. Insercion de Categorías --
-- -------------------------- --
INSERT INTO Categorias (nombre, descripcion) VALUES
('Trabajo', 'Tareas relacionadas con el empleo o la empresa.'),
('Estudios', 'Trabajos, exámenes y repasos del ciclo formativo.'),
('Hogar', 'Compras, limpieza y mantenimiento de la casa.'),
('Personal', 'Ocio, salud, deporte y metas personales.');

-- -------------------------------- --
-- 3. Insercion de Tareas de prueba --
-- -------------------------------- --
INSERT INTO Tareas (titulo, descripcion, fecha_creacion, fecha_limite, observaciones, id_usuario, id_categoria, id_estado) VALUES
('Terminar diseño de BD', 'Crear el modelo relacional y físico para el Reto 2.', '2026-03-20', '2026-03-26', 'Falta revisar las claves foráneas.', 1, 2, 2),

('Comprar componentes PC', 'Comprar memoria RAM y disco SSD para actualizar el servidor.', '2026-03-22', '2026-03-24', 'Comparar precios en varias tiendas.', 2, 1, 3),

('Renovar DNI', 'Pedir cita previa para renovar el documento de identidad.', '2026-03-10', '2026-04-15', 'Cita programada para el 12 de abril.', 3, 4, 1),

('Revisión del coche', 'Llevar el coche al taller para el cambio de aceite anual.', '2026-03-01', '2026-03-05', 'Demasiado caro, lo haré el mes que viene.', 2, 3, 4),

('Estudiar HTML y CSS', 'Repasar etiquetas semánticas y selectores para el examen.', '2026-03-24', '2026-04-02', 'Priorizar el estudio de Flexbox y Grid.', 1, 2, 1);