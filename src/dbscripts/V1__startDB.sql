-- -----------------------------------------------------
-- Table cliente
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS cliente (
  id SERIAL NOT NULL,
  razaosocial VARCHAR(100) NOT NULL,
  cnpj VARCHAR(100) NOT NULL,
  telefone VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table fornecedor
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS fornecedor (
  id SERIAL NOT NULL,
  razaosocial VARCHAR(100) NOT NULL,
  cnpj VARCHAR(100) NOT NULL,
  telefone VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table funcionario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS funcionario (
  id SERIAL NOT NULL,
  nome VARCHAR(100) NOT NULL,
  cpf VARCHAR(100) NOT NULL,
  telefone VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table login
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS usuario (
  id_usuario SERIAL NOT NULL,
  login VARCHAR(100) NOT NULL,
  senha VARCHAR(100) NOT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table tipo_produto
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tipo_produto (
  id SERIAL NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  situacao VARCHAR(45) NOT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table produto
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS produto (
  id SERIAL NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  valor DECIMAL(10,2) NOT NULL,
  tipo_produto_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_produto_tipo_produto
    FOREIGN KEY (tipo_produto_id)
    REFERENCES tipo_produto (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table estoque
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estoque (
  id SERIAL NOT NULL,
  quantidade INT NOT NULL,
  produto_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_estoque_produto
    FOREIGN KEY (produto_id)
    REFERENCES produto (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table venda
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS venda (
  id SERIAL NOT NULL,
  data DATE NOT NULL,
  valor VARCHAR(45) NOT NULL,
  situacao VARCHAR(1) NOT NULL,
  funcionario_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_venda_funcionario
    FOREIGN KEY (funcionario_id)
    REFERENCES funcionario (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table venda_produto
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS venda_produto (
  id SERIAL NOT NULL,
  data DATE NOT NULL,
  valor_produto DECIMAL(10,2) NOT NULL,
  quantidade INT NOT NULL,
  produto_id INT NOT NULL,
  venda_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_venda_produto_produto
    FOREIGN KEY (produto_id)
    REFERENCES produto (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_venda_produto_venda
    FOREIGN KEY (venda_id)
    REFERENCES venda (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table compra
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS compra (
  id SERIAL NOT NULL,
  data DATE NOT NULL,
  valor VARCHAR(45) NOT NULL,
  situacao VARCHAR(1) NOT NULL,
  funcionario_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_compra_funcionario
    FOREIGN KEY (funcionario_id)
    REFERENCES funcionario (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table contas_pagar
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS contas_pagar (
  id SERIAL NOT NULL,
  valor DECIMAL(10,2) NOT NULL,
  data_vencimento VARCHAR(45) NOT NULL,
  fornecedor_id INT NOT NULL,
  compra_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_contas_pagar_fornecedor
    FOREIGN KEY (fornecedor_id)
    REFERENCES fornecedor (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_contas_pagar_compra
    FOREIGN KEY (compra_id)
    REFERENCES compra (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table contas_receber
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS contas_receber (
  id SERIAL NOT NULL,
  valor DECIMAL(10,2) NOT NULL,
  data_vencimento VARCHAR(45) NOT NULL,
  cliente_id INT NOT NULL,
  venda_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_contas_receber_cliente
    FOREIGN KEY (cliente_id)
    REFERENCES cliente (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_contas_receber_venda
    FOREIGN KEY (venda_id)
    REFERENCES venda (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table compra_produto
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS compra_produto (
  id SERIAL NOT NULL,
  data DATE NOT NULL,
  valor_produto DECIMAL(10,2) NOT NULL,
  quantidade INT NOT NULL,
  produto_id INT NOT NULL,
  compra_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_compra_produto_produto
    FOREIGN KEY (produto_id)
    REFERENCES produto (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_compra_produto_compra
    FOREIGN KEY (compra_id)
    REFERENCES compra (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

INSERT INTO login(id, usuario, senha) VALUES ('9999', 'admin', '21232f297a57a5a743894a0e4a801fc3') ON CONFLICT DO NOTHING;