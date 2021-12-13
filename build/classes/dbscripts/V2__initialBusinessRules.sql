-- Configurações de auditoria
CREATE TABLE audit_log (
    userid integer, -- who did the change
    event_time_utc timestamp, -- when the event was recorded
    table_name text, -- contains schema-qualified table name
    operation text, -- INSERT, UPDATE, DELETE or TRUNCATE
    before_value json, -- the OLD tuple value
    after_value json -- the NEW tuple value
);

CREATE OR REPLACE FUNCTION audit_trigger() 
  RETURNS trigger AS $$ 
DECLARE 
    old_row json := NULL; 
    new_row json := NULL; 
BEGIN 
    IF TG_OP IN ('UPDATE','DELETE') THEN 
        old_row = row_to_json(OLD); 
    END IF; 
    IF TG_OP IN ('INSERT','UPDATE') THEN 
        new_row = row_to_json(NEW); 
    END IF; 
    INSERT INTO  audit_log( 
        username, 
        event_time_utc, 
        table_name, 
        operation, 
        before_value, 
        after_value 
    ) VALUES ( 
        NEW.id_usuario_cadastro, 
        current_timestamp AT TIME ZONE 'UTC', 
        TG_TABLE_SCHEMA ||  '.' || TG_TABLE_NAME, 
        TG_OP, 
        old_row, 
        new_row 
    ); 
    RETURN NEW; 
END; 
$$ LANGUAGE plpgsql;

-- Tabelas auditadas

CREATE TRIGGER audit_cidade 
  AFTER INSERT OR UPDATE OR DELETE 
  ON cidade 
  FOR EACH ROW 
EXECUTE PROCEDURE audit_trigger();

CREATE TRIGGER audit_estado
  AFTER INSERT OR UPDATE OR DELETE 
  ON estado 
  FOR EACH ROW 
EXECUTE PROCEDURE audit_trigger();

CREATE TRIGGER audit_produto 
  AFTER INSERT OR UPDATE OR DELETE 
  ON produto 
  FOR EACH ROW 
EXECUTE PROCEDURE audit_trigger();

CREATE TRIGGER audit_tipo_produto
  AFTER INSERT OR UPDATE OR DELETE 
  ON tipo_produto 
  FOR EACH ROW 
EXECUTE PROCEDURE audit_trigger();

-- VIEWS

CREATE VIEW funcionario_v AS (
SELECT
	a.nome,
	a.cpf,
	a.rg,
	a.dt_nascimento,
	a.sexo,
	c.cidade,
	b.endereco,
	b.bairro,
	b.numero,
	b.telefone,
	b.celular,
	b.email
FROM
	funcionario a,
	entidade b,
	cidade c
WHERE
	a.id_entidade = b.id_entidade
	AND b.id_cidade = c.id_cidade
ORDER BY
	b.id_entidade
);

CREATE VIEW produto_v AS (
SELECT
	a.descricao,
	b.marca,
	b.recipiente,
	b.volume,
	a.valor
FROM
	produto a,
	tipo_produto b
WHERE
	a.id_tipo_produto = b.id_tipo_produto
ORDER BY
	a.descricao,
	b.marca
);


-- PROCEDURES

CREATE OR REPLACE FUNCTION data_venda (dt_venda date)
RETURNS SETOF venda
AS $$
SELECT *
FROM venda
WHERE dt_venda = $1
$$ LANGUAGE sql;

CREATE OR REPLACE FUNCTION busca_marca (marca text)
RETURNS text
AS $$
SELECT marca
FROM produto
WHERE marca = $1
$$ LANGUAGE sql;

-- Triggers de validação

CREATE FUNCTION valida_produto() RETURNS trigger AS $valida_produto$
    BEGIN
        IF NEW.descricao IS NULL THEN
            RAISE EXCEPTION 'A descrição do produto não pode ser nula';
        END IF;
        IF NEW.valor IS NULL THEN
            RAISE EXCEPTION '% não pode ter um valor nulo', NEW.nome;
        END IF;      
	IF NEW.valor < 0 THEN
            RAISE EXCEPTION '% não pode ter um valor negativo', NEW.nome;
        END IF;
        
		RETURN NEW;
    END;
  $valida_produto$ LANGUAGE plpgsql;

CREATE TRIGGER valida_produto BEFORE INSERT OR UPDATE ON produto
    FOR EACH ROW EXECUTE PROCEDURE valida_produto();