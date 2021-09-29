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
CREATE TABLE IF NOT EXISTS login (
  id SERIAL NOT NULL,
  usuario VARCHAR(100) NOT NULL,
  senha VARCHAR(100) NOT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table tipo_item
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tipo_item (
  id SERIAL NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  situacao VARCHAR(45) NOT NULL,
  PRIMARY KEY (id))
;


-- -----------------------------------------------------
-- Table item
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS item (
  id SERIAL NOT NULL,
  descricao VARCHAR(100) NOT NULL,
  valor DECIMAL(10,2) NOT NULL,
  situacao VARCHAR(1) NOT NULL,
  tipo_item_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_item_tipo_item
    FOREIGN KEY (tipo_item_id)
    REFERENCES tipo_item (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table estoque
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estoque (
  id SERIAL NOT NULL,
  quantidade INT NOT NULL,
  item_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_estoque_item
    FOREIGN KEY (item_id)
    REFERENCES item (id)
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
-- Table venda_item
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS venda_item (
  id SERIAL NOT NULL,
  data DATE NOT NULL,
  valor_item DECIMAL(10,2) NOT NULL,
  quantidade INT NOT NULL,
  item_id INT NOT NULL,
  venda_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_venda_item_item
    FOREIGN KEY (item_id)
    REFERENCES item (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_venda_item_venda
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
-- Table compra_item
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS compra_item (
  id SERIAL NOT NULL,
  data DATE NOT NULL,
  valor_item DECIMAL(10,2) NOT NULL,
  quantidade INT NOT NULL,
  item_id INT NOT NULL,
  compra_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_compra_item_item
    FOREIGN KEY (item_id)
    REFERENCES item (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_compra_item_compra
    FOREIGN KEY (compra_id)
    REFERENCES compra (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

INSERT INTO funcionario (id, nome, telefone, email, cpf) VALUES ('1', 'Administrador', '(55) 95555-5555', 'admin@admin.com', '000.000.000-00') ON CONFLICT DO NOTHING;

INSERT INTO login(id, usuario, senha) VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3') ON CONFLICT DO NOTHING;