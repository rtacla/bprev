DROP TABLE IF EXISTS categoria;

CREATE TABLE categorias (
	idCategoria int AUTO_INCREMENT PRIMARY KEY,
	categoria VARCHAR(50) NOT NULL
);

CREATE TABLE produtos (
	idProduto int AUTO_INCREMENT PRIMARY KEY,
	idCategoria int NOT NULL,
	produto VARCHAR(50)  NOT NULL,
	preco decimal  NOT NULL,
	quantidade int  NOT NULL,
	descricao VARCHAR(50)  NOT NULL,
	foto VARCHAR2(300)
);

ALTER TABLE produtos
    ADD FOREIGN KEY (idCategoria) 
    REFERENCES categorias(idCategoria);

    
CREATE TABLE clientes (
	idCliente int AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(50)  NOT NULL,
	email VARCHAR(100)  NOT NULL,
	senha VARCHAR(20)  NOT NULL,
	rua VARCHAR(100)  NOT NULL,
	cidade VARCHAR(50)  NOT NULL,
	bairro VARCHAR(30)  NOT NULL,
	cep VARCHAR(8)  NOT NULL,
	estado VARCHAR(2)  NOT NULL
);


CREATE TABLE pedidos (
	idPedido int AUTO_INCREMENT PRIMARY KEY,
	data timestamp  NOT NULL,
	idCliente int  NOT NULL,
	status VARCHAR(20)  NOT NULL,
	sessao VARCHAR(100),
);

ALTER TABLE pedidos
    ADD FOREIGN KEY (idCliente) 
    REFERENCES clientes(idCliente);

    
CREATE TABLE pedidoItens (
	idItem int AUTO_INCREMENT PRIMARY KEY,
	idPedido int NOT NULL,
	idProduto int NOT NULL,
	produto VARCHAR(50) NOT NULL,
	quantidade int NOT NULL,
	valor decimal NOT NULL,
	subtotal decimal NOT NULL
);

ALTER TABLE pedidoItens
    ADD FOREIGN KEY (idPedido) 
    REFERENCES pedidos(idPedido);
    
ALTER TABLE pedidoItens
    ADD FOREIGN KEY (idProduto) 
    REFERENCES produtos(idProduto);    
    
