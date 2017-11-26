--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

-- Started on 2017-07-12 10:23:30

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2154 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 186 (class 1259 OID 32919)
-- Name: biografia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE biografia (
    id integer NOT NULL,
    descricao_biografia character varying(255) NOT NULL,
    usuario_id integer NOT NULL
);


ALTER TABLE biografia OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 32917)
-- Name: biografia_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE biografia_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE biografia_id_seq OWNER TO postgres;

--
-- TOC entry 2155 (class 0 OID 0)
-- Dependencies: 185
-- Name: biografia_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE biografia_id_seq OWNED BY biografia.id;


--
-- TOC entry 190 (class 1259 OID 32968)
-- Name: publicacao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE publicacao (
    id integer NOT NULL,
    caminho_imagem character varying(255),
    legenda character varying(255) NOT NULL,
    nome_imagem character varying(255) NOT NULL,
    id_usuario integer
);


ALTER TABLE publicacao OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 32966)
-- Name: publicacao_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE publicacao_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE publicacao_id_seq OWNER TO postgres;

--
-- TOC entry 2156 (class 0 OID 0)
-- Dependencies: 189
-- Name: publicacao_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE publicacao_id_seq OWNED BY publicacao.id;


--
-- TOC entry 188 (class 1259 OID 32927)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE usuario (
    id integer NOT NULL,
    email character varying(255) NOT NULL,
    login character varying(10) NOT NULL,
    nome character varying(50) NOT NULL,
    senha character varying(10) NOT NULL
);


ALTER TABLE usuario OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 32925)
-- Name: usuario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE usuario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE usuario_id_seq OWNER TO postgres;

--
-- TOC entry 2157 (class 0 OID 0)
-- Dependencies: 187
-- Name: usuario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE usuario_id_seq OWNED BY usuario.id;


--
-- TOC entry 2014 (class 2604 OID 32922)
-- Name: biografia id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY biografia ALTER COLUMN id SET DEFAULT nextval('biografia_id_seq'::regclass);


--
-- TOC entry 2016 (class 2604 OID 32971)
-- Name: publicacao id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY publicacao ALTER COLUMN id SET DEFAULT nextval('publicacao_id_seq'::regclass);


--
-- TOC entry 2015 (class 2604 OID 32930)
-- Name: usuario id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario ALTER COLUMN id SET DEFAULT nextval('usuario_id_seq'::regclass);


--
-- TOC entry 2143 (class 0 OID 32919)
-- Dependencies: 186
-- Data for Name: biografia; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO biografia (id, descricao_biografia, usuario_id) VALUES (2, 'Bio Erika', 2);
INSERT INTO biografia (id, descricao_biografia, usuario_id) VALUES (6, 'Bio Usuario 3', 6);
INSERT INTO biografia (id, descricao_biografia, usuario_id) VALUES (1, 'Biografia Cezar
', 1);
INSERT INTO biografia (id, descricao_biografia, usuario_id) VALUES (9, '', 10);
INSERT INTO biografia (id, descricao_biografia, usuario_id) VALUES (10, 'ddddddddd', 11);


--
-- TOC entry 2158 (class 0 OID 0)
-- Dependencies: 185
-- Name: biografia_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('biografia_id_seq', 11, true);


--
-- TOC entry 2147 (class 0 OID 32968)
-- Dependencies: 190
-- Data for Name: publicacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO publicacao (id, caminho_imagem, legenda, nome_imagem, id_usuario) VALUES (2, '/temp/img/R.jpg', 'Razec', 'R.jpg', 1);
INSERT INTO publicacao (id, caminho_imagem, legenda, nome_imagem, id_usuario) VALUES (5, '/temp/img/20141005_173116.jpg', '', '20141005_173116.jpg', 2);
INSERT INTO publicacao (id, caminho_imagem, legenda, nome_imagem, id_usuario) VALUES (4, '/temp/img/2015-03-17 07.12.41 1.jpg', 'Amanhecer', '2015-03-17 07.12.41 1.jpg', 1);
INSERT INTO publicacao (id, caminho_imagem, legenda, nome_imagem, id_usuario) VALUES (7, '/temp/img/DSC01482.JPG', 'Sunset', 'DSC01482.JPG', 1);


--
-- TOC entry 2159 (class 0 OID 0)
-- Dependencies: 189
-- Name: publicacao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('publicacao_id_seq', 8, true);


--
-- TOC entry 2145 (class 0 OID 32927)
-- Dependencies: 188
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO usuario (id, email, login, nome, senha) VALUES (2, 'erika@gmail.com', 'erika', 'Erika', 'erika123');
INSERT INTO usuario (id, email, login, nome, senha) VALUES (6, 'usuario3@mail.com', 'usuario3', 'Usuario 3', 'usuario312');
INSERT INTO usuario (id, email, login, nome, senha) VALUES (1, 'cezar@gmail.com', 'cezarf2', 'Cezar Filho', 'cezar123');
INSERT INTO usuario (id, email, login, nome, senha) VALUES (9, 'cezarbx@gmail.com', 'cezarf6', 'Ceza', 'cezar123');
INSERT INTO usuario (id, email, login, nome, senha) VALUES (10, 'cezarbx@gmail.com', 'cezarf3', 'Cezar', 'cezar123');
INSERT INTO usuario (id, email, login, nome, senha) VALUES (11, 'cezarbx@gmail.com', 'cezarf4', 'Cezar', 'cezar123');


--
-- TOC entry 2160 (class 0 OID 0)
-- Dependencies: 187
-- Name: usuario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usuario_id_seq', 12, true);


--
-- TOC entry 2018 (class 2606 OID 32924)
-- Name: biografia biografia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY biografia
    ADD CONSTRAINT biografia_pkey PRIMARY KEY (id);


--
-- TOC entry 2022 (class 2606 OID 32976)
-- Name: publicacao publicacao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY publicacao
    ADD CONSTRAINT publicacao_pkey PRIMARY KEY (id);


--
-- TOC entry 2020 (class 2606 OID 32932)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);


--
-- TOC entry 2024 (class 2606 OID 32977)
-- Name: publicacao fkfmx5o13ybwqeiee1finmwdi48; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY publicacao
    ADD CONSTRAINT fkfmx5o13ybwqeiee1finmwdi48 FOREIGN KEY (id_usuario) REFERENCES usuario(id);


--
-- TOC entry 2023 (class 2606 OID 32933)
-- Name: biografia fkoxqp4ma8v3ymqex2f6a5kbt05; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY biografia
    ADD CONSTRAINT fkoxqp4ma8v3ymqex2f6a5kbt05 FOREIGN KEY (usuario_id) REFERENCES usuario(id);


-- Completed on 2017-07-12 10:23:30

--
-- PostgreSQL database dump complete
--

