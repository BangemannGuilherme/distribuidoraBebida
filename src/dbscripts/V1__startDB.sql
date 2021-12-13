-- -----------------------------------------------------
-- Table estado
-- -----------------------------------------------------
create table estado(
  id_estado serial not null, 
  estado varchar(45) not null, 
  sigla_estado varchar(2) not null, 
  situacao varchar(1) not null, 
  constraint PK_estado primary key (id_estado))
;


-- -----------------------------------------------------
-- Table cidade
-- -----------------------------------------------------
create table cidade(
  id_cidade serial not null, 
  cidade varchar(45) not null, 
  id_usuario_cadastro integer not null, 
  situacao varchar(1) not null, 
  id_estado integer not null, 
  constraint PK_cidade primary key (id_cidade), 
  constraint FK_cidade_estado foreign key (id_estado) references estado)
;


-- -----------------------------------------------------
-- Table entidade
-- -----------------------------------------------------
create table entidade(
  id_entidade serial not null, 
  endereco varchar(45) not null, 
  bairro varchar(45) not null, 
  numero varchar(45) not null, 
  situacao varchar(1) not null, 
  id_usuario_cadastro integer not null, 
  telefone varchar(45), 
  celular varchar(45), 
  email varchar(45), 
  id_cidade integer not null, 
  constraint PK_entidade primary key (id_entidade), 
  constraint FK_entidade_cidade foreign key (id_cidade) references cidade)
;


-- -----------------------------------------------------
-- Table cliente
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS cliente (
  id_cliente SERIAL NOT NULL,
  razaosocial VARCHAR(100) NOT NULL,
  cnpj VARCHAR(100) NOT NULL,
  situacao varchar(1),
  id_entidade integer not null,
  constraint PK_cliente primary key (id_cliente),
  constraint FK_cliente_entidade foreign key (id_entidade) references entidade) 
;


-- -----------------------------------------------------
-- Table fornecedor
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS fornecedor (
  id_fornecedor SERIAL NOT NULL,
  razaosocial VARCHAR(100) NOT NULL,
  cnpj VARCHAR(100) NOT NULL,
  situacao varchar(1),
  id_entidade integer not null,
  constraint PK_fornecedor primary key (id_fornecedor),
  constraint FK_cliente_entidade foreign key (id_entidade) references entidade) 
;


-- -----------------------------------------------------
-- Table funcionario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS funcionario (
  id_funcionario SERIAL NOT NULL,
  nome VARCHAR(100) NOT NULL,
  cpf VARCHAR(100) NOT NULL,
  rg VARCHAR(100) NOT NULL,
  dt_nascimento DATE NOT NULL,
  sexo varchar(45) NOT NULL,
  id_entidade integer not null, 
  constraint PK_funcionario primary key (id_funcionario), 
  constraint FK_funcionario_entidade foreign key (id_entidade) references entidade)
;


-- -----------------------------------------------------
-- Table usuario
-- -----------------------------------------------------
create table IF NOT EXISTS usuario(
  id_usuario serial not null, 
  login varchar(45) not null, 
  senha varchar(45) not null, 
  dt_criacao date not null, 
  dt_alteracao_senha date,
  situacao varchar(1) not null, 
  permissao varchar(1) not null,
  id_funcionario integer not null, 
  constraint PK_usuario primary key (id_usuario), 
  constraint FK_usuario_funcionario foreign key (id_funcionario) references funcionario)
;


-- -----------------------------------------------------
-- Table permissao
-- -----------------------------------------------------
create table permissao(
	id_permissao serial not null, 
	descricao varchar(45) not null, 
	id_usuario_cadastro integer not null, 
	situacao varchar(1) not null, 
	constraint PK_permissao primary key (id_permissao))
;


-- -----------------------------------------------------
-- Table permissao_usuario
-- -----------------------------------------------------
create table permissao_usuario(
  id_permissao integer not null,
  id_usuario integer not null,
  id_usuario_cadastro integer not null,
  constraint PK_permissao_usuario primary key (id_permissao, id_usuario),
  constraint FK_permissao_usuario_permissao foreign key (id_permissao) references permissao,
  constraint FK_permissao_usuario_usuario foreign key (id_usuario) references usuario)
;


-- -----------------------------------------------------
-- Table tipo_produto
-- -----------------------------------------------------
create table tipo_produto(
  id_tipo_produto serial not null, 
  marca varchar(100) not null,
  recipiente varchar(100) not null,
  volume decimal(11,2) not null, 
  id_usuario_cadastro integer not null, 
  situacao varchar(1) not null, 
  constraint PK_tipo_produto primary key (id_tipo_produto))
;


-- -----------------------------------------------------
-- Table produto
-- -----------------------------------------------------
create table produto(
  id_produto serial not null, 
  descricao varchar(100) not null, 
  valor decimal(11,2) not null, 
  id_usuario_cadastro integer not null, 
  situacao varchar(1) not null, 
  id_tipo_produto integer not null, 
  constraint PK_produto primary key (id_produto), 
  constraint FK_produto_tipo_produto foreign key (id_tipo_produto) references tipo_produto)
;


-- -----------------------------------------------------
-- Table venda
-- -----------------------------------------------------
create table venda(
  id_venda serial not null, 
  dt_venda date not null, 
  id_usuario_cadastro integer not null, 
  id_cliente integer not null,
  id_funcionario integer not null, 
  constraint PK_venda primary key (id_venda), 
  constraint FK_venda_cliente foreign key (id_cliente) references cliente,
  constraint FK_venda_funcionario foreign key (id_funcionario) references funcionario)
;


-- -----------------------------------------------------
-- Table venda_produto
-- -----------------------------------------------------
create table venda_produto(
  id_venda_produto integer not null,
  quantidade integer not null,
  vl_venda decimal(11,2) not null,
  id_venda integer not null, 
  id_produto integer not null, 
  constraint PK_venda_produto primary key (id_venda_produto), 
  constraint FK_venda_produto_venda foreign key (id_venda) references venda, 
  constraint FK_venda_produto_produto foreign key (id_produto) references produto)
;


insert into estado values(1,'Rio Grande do Sul','RS','A');
insert into cidade values(1, 'Lajeado',1,'A',1);
insert into entidade values(1, 'Rua 123', 'Central', '123','A',1,'5137501010','51999999999','email@email.com',1);
insert into funcionario values(1, 'Bóris', '12345678912','1234567891', current_date, 'Masculino', 1);
insert into usuario values(1, 'admin', 'admin', current_date, current_date, 'A', 0, 1);
insert into funcionario values(2, 'User', '33333','1234567891', current_date, 'Masculino', 1);
insert into usuario values(2, 'usuario', 'usuario', current_date, current_date, 'A', 1, 2);
insert into entidade values(4, 'Rua Amazonas', 'Centro', '458', 'A', 1, '5137501010', '51999999999', 'email@email.com',1);
insert into cliente values(1, 'McDonalds', '42.591.651/0001-43','A', 1);

INSERT INTO estado(id_estado, estado, sigla_estado, situacao) VALUES ('1', 'Rio Grande do Sul', 'RS', 'A') ON CONFLICT DO NOTHING;
INSERT INTO cidade(id_cidade, cidade, id_usuario_cadastro, situacao, id_estado) VALUES ('1', 'Estrela', '1', 'A' ,'1') ON CONFLICT DO NOTHING;
INSERT INTO entidade(id_entidade, endereco, bairro, numero, situacao, id_usuario_cadastro, telefone, celular, email, id_cidade) VALUES ('1', 'Rua Pércio Freitas', 'Alto da Bronze', '41', 'A', '1', '51333333' ,'51988880000', 'essentialdrinks@gmail.com', '1') ON CONFLICT DO NOTHING;
INSERT INTO funcionario(id_funcionario, nome, cpf, rg, dt_nascimento, sexo, id_entidade) VALUES ('1', 'Administrator', '000.000.000-99','4000400900' ,'10/12/2021', 'Masculino', '1') ON CONFLICT DO NOTHING;
INSERT INTO usuario(id_usuario, login, senha, dt_criacao, situacao, id_funcionario, permissao) VALUES ('1', 'admin', 'admin', '10/12/2021', 'A', '1', 0) ON CONFLICT DO NOTHING;