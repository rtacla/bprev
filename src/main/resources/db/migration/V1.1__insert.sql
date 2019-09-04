INSERT INTO categorias (categoria) values ('Brinquedos');
INSERT INTO categorias (categoria) values ('Roupas');
INSERT INTO categorias (categoria) values ('Sapatos');

INSERT INTO produtos (idCategoria, produto, preco, quantidade, descricao, foto) values (1, 'Playmobil', 150.00, 5, 'Playmobil modelo pirata', 'https://www.google.com/url?sa=i&source=images&cd=&ved=2ahUKEwjRqbi53K3kAhViJLkGHaLiBQEQjRx6BAgBEAQ&url=https%3A%2F%2Fwww.americanas.com.br%2Fproduto%2F122631636&psig=AOvVaw01OWGuz3E-VYzauXXDFR49&ust=1567361956258003');
INSERT INTO produtos (idCategoria, produto, preco, quantidade, descricao, foto) values (1, 'Lego', 350.00, 25, 'Lego Lunar', 'https://www.google.com/url?sa=i&source=images&cd=&ved=2ahUKEwjy09XS3K3kAhUjH7kGHTwgDtoQjRx6BAgBEAQ&url=https%3A%2F%2Fwww.lego.com%2Fen-us%2Fproduct%2Fnasa-apollo-11-lunar-lander-10266&psig=AOvVaw0xSE8-l9xRsyqpVFKTPGto&ust=1567362012564433');
INSERT INTO produtos (idCategoria, produto, preco, quantidade, descricao, foto) values (3, 'Tenis Adidas', 199.00, 25, 'Tenis Adidas Preto', 'https://assets.adidas.com/images/w_840,h_840,f_auto,q_auto:sensitive,fl_lossy/7a55cc461ba742048bd6a991000d0dde_9366/Tenis_8K_Preto_F34480_01_standard.jpg');

INSERT INTO clientes (nome, email, senha, rua, cidade, bairro, cep, estado) values ('JOSE SILVA', 'jose@teste.com', '789123', 'Avenida Paulista, 123', 'Sao Paulo', 'Consolacao', '01000000', 'SP');
INSERT INTO clientes (nome, email, senha, rua, cidade, bairro, cep, estado) values ('JOSE ANTONIO', 'jantonio@teste.com', '555444', 'Avenida Brasil, 555', 'Sao Paulo', 'Jardins', '99999999', 'SP');



