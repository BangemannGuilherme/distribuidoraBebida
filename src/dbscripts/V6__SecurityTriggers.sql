-- Inserts de apoio iniciais

insert into estado values(1,'Rio Grande do Sul','RS','A');
insert into cidade values(1, 'Lajeado',1,'A',1);
insert into entidade values(1, 'Rua 123', 'Central', '123','A',1,'5137501010','51999999999','email@email.com',1);
insert into funcionario values(1, 'Bóris', '12345678912','1234567891', current_date, 'Masculino', 1);
insert into usuario values(1, 'admin', 'admin', current_date, current_date, 1, 'A');

-- Triggers de Validação em banco

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

-- Tabela tipo_produto
-- Valores de reserva e descrição precisam estar corretos

CREATE FUNCTION valida_tipo_produto() RETURNS trigger AS $valida_tipo_produto$
    BEGIN
        IF NEW.marca IS NULL THEN
            RAISE EXCEPTION 'A marca do tipo de produto não pode ser nula';
        END IF;
        IF NEW.volume < 0 THEN
            RAISE EXCEPTION '% não pode ter um valor negativo.', NEW.marca;
        END IF;
    RETURN NEW;
END;
$valida_tipo_produto$ LANGUAGE plpgsql;

CREATE TRIGGER valida_tipo_produto BEFORE INSERT OR UPDATE ON tipo_produto
    FOR EACH ROW EXECUTE PROCEDURE valida_tipo_produto();