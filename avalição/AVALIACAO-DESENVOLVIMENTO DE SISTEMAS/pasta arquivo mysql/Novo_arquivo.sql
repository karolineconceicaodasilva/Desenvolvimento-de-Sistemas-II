
CREATE TABLE Clientes (
id int  AUTO_INCREMENT PRIMARY KEY,
nome varchar(50),
endereco varchar(50),
cpf varchar(14),
sexo char(1) 
);

CREATE TABLE Pedidos (
id int  AUTO_INCREMENT PRIMARY KEY,
valor_total decimal(6,2),
status varchar(20),
data_venda date,
data_entrega date,
Clientes_id int,
CONSTRAINT Clientes_fk
FOREIGN KEY (Clientes_id) REFERENCES Clientes(id)
);

CREATE TABLE Produtos (
id int  AUTO_INCREMENT PRIMARY KEY,
nome varchar(50),
descricao varchar(20),
valor decimal(5,2),
quantidade int 
);
  
CREATE TABLE Pedido_Produto (
id_Pedido int,
id_Produto int,
PRIMARY KEY (id_Pedido,id_Produto),
FOREIGN KEY (id_Pedido) REFERENCES Pedidos(id),
FOREIGN KEY (id_Produto) REFERENCES Produtos(id)
);

select * from Pedidos;
  

