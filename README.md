# CadastroDeTarefa

Implementação utilizando servidor Tomcat versão 9.0 e gerenciamento de pacotes Maven. 

Para rodar os dados e a aplicação funcionar é importante usar esse script

-- Database: tarefas_estagio

DROP DATABASE IF EXISTS tarefas_estagio;

CREATE DATABASE tarefas_estagio
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

-- Table: public.responsaveis

DROP TABLE IF EXISTS public.responsaveis;

CREATE TABLE IF NOT EXISTS public.responsaveis
(
    id_responsavel integer NOT NULL,
    nome character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT responsaveis_pkey PRIMARY KEY (id_responsavel)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.responsaveis
    OWNER to postgres;

-- Table: public.tarefas

DROP TABLE IF EXISTS public.tarefas;

CREATE TABLE IF NOT EXISTS public.tarefas
(
    id_tarefa integer NOT NULL,
    titulo character varying(30) COLLATE pg_catalog."default",
    descricao character varying(250) COLLATE pg_catalog."default",
    id_responsavel integer,
    prioridade integer,
    deadline timestamp without time zone,
    CONSTRAINT tarefas_pkey PRIMARY KEY (id_tarefa),
    CONSTRAINT tarefas_id_responsavel_fkey FOREIGN KEY (id_responsavel)
        REFERENCES public.responsaveis (id_responsavel) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tarefas
    OWNER to postgres;

-- SEQUENCE: public.sq_responsaveis

DROP SEQUENCE IF EXISTS public.sq_responsaveis;

CREATE SEQUENCE IF NOT EXISTS public.sq_responsaveis
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.sq_responsaveis
    OWNED BY public.responsaveis.id_responsavel;

ALTER SEQUENCE public.sq_responsaveis
    OWNER TO postgres;

-- SEQUENCE: public.sq_tarefas

DROP SEQUENCE IF EXISTS public.sq_tarefas;

CREATE SEQUENCE IF NOT EXISTS public.sq_tarefas
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.sq_tarefas
    OWNED BY public.tarefas.id_tarefa;

ALTER SEQUENCE public.sq_tarefas
    OWNER TO postgres;

INSERT INTO Responsaveis (id_responsavel, nome) VALUES (nextval('sq_responsaveis'),'João');

INSERT INTO Responsaveis (id_responsavel, nome) VALUES (nextval('sq_responsaveis'),'Antonio');