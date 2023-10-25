--
-- PostgreSQL database dump
--

-- Dumped from database version 10.22
-- Dumped by pg_dump version 10.22

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: cours_devise; Type: TABLE; Schema: public; Owner: manoary
--

CREATE TABLE public.cours_devise (
    id_cours_devise integer NOT NULL,
    id_devise character varying(7) NOT NULL,
    montant double precision,
    date_cours date,
    montant_2 double precision
);


ALTER TABLE public.cours_devise OWNER TO manoary;

--
-- Name: cours_devise_id_cours_devise_seq; Type: SEQUENCE; Schema: public; Owner: manoary
--

CREATE SEQUENCE public.cours_devise_id_cours_devise_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cours_devise_id_cours_devise_seq OWNER TO manoary;

--
-- Name: cours_devise_id_cours_devise_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: manoary
--

ALTER SEQUENCE public.cours_devise_id_cours_devise_seq OWNED BY public.cours_devise.id_cours_devise;


--
-- Name: devise; Type: TABLE; Schema: public; Owner: manoary
--

CREATE TABLE public.devise (
    id character varying(7) NOT NULL,
    name character varying(20)
);


ALTER TABLE public.devise OWNER TO manoary;

--
-- Name: tany; Type: TABLE; Schema: public; Owner: manoary
--

CREATE TABLE public.tany (
    id integer NOT NULL,
    cin character varying(20),
    borne boolean,
    longueur double precision,
    largeur double precision
);


ALTER TABLE public.tany OWNER TO manoary;

--
-- Name: tany_id_seq; Type: SEQUENCE; Schema: public; Owner: manoary
--

CREATE SEQUENCE public.tany_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tany_id_seq OWNER TO manoary;

--
-- Name: tany_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: manoary
--

ALTER SEQUENCE public.tany_id_seq OWNED BY public.tany.id;


--
-- Name: cours_devise id_cours_devise; Type: DEFAULT; Schema: public; Owner: manoary
--

ALTER TABLE ONLY public.cours_devise ALTER COLUMN id_cours_devise SET DEFAULT nextval('public.cours_devise_id_cours_devise_seq'::regclass);


--
-- Name: tany id; Type: DEFAULT; Schema: public; Owner: manoary
--

ALTER TABLE ONLY public.tany ALTER COLUMN id SET DEFAULT nextval('public.tany_id_seq'::regclass);


--
-- Data for Name: cours_devise; Type: TABLE DATA; Schema: public; Owner: manoary
--

COPY public.cours_devise (id_cours_devise, id_devise, montant, date_cours, montant_2) FROM stdin;
1	DEV0001	1	2023-10-10	\N
2	DEV0002	3500	2023-10-10	\N
3	DEV0003	3347.98	2023-10-10	\N
4	DEV0004	100	2023-10-10	\N
5	DEV0002	4500	2023-10-16	\N
\.


--
-- Data for Name: devise; Type: TABLE DATA; Schema: public; Owner: manoary
--

COPY public.devise (id, name) FROM stdin;
DEV0001	AR
DEV0002	EUR
DEV0003	USD
DEV0004	YEN
\.


--
-- Data for Name: tany; Type: TABLE DATA; Schema: public; Owner: manoary
--

COPY public.tany (id, cin, borne, longueur, largeur) FROM stdin;
1	00001	f	123	244
3	00001	f	323	264
4	00002	t	423	274
2	00002	t	223	254
5	00003	f	523	284
\.


--
-- Name: cours_devise_id_cours_devise_seq; Type: SEQUENCE SET; Schema: public; Owner: manoary
--

SELECT pg_catalog.setval('public.cours_devise_id_cours_devise_seq', 5, true);


--
-- Name: tany_id_seq; Type: SEQUENCE SET; Schema: public; Owner: manoary
--

SELECT pg_catalog.setval('public.tany_id_seq', 5, true);


--
-- Name: cours_devise cours_devise_pkey; Type: CONSTRAINT; Schema: public; Owner: manoary
--

ALTER TABLE ONLY public.cours_devise
    ADD CONSTRAINT cours_devise_pkey PRIMARY KEY (id_cours_devise);


--
-- Name: devise devise_pkey; Type: CONSTRAINT; Schema: public; Owner: manoary
--

ALTER TABLE ONLY public.devise
    ADD CONSTRAINT devise_pkey PRIMARY KEY (id);


--
-- Name: tany tany_pkey; Type: CONSTRAINT; Schema: public; Owner: manoary
--

ALTER TABLE ONLY public.tany
    ADD CONSTRAINT tany_pkey PRIMARY KEY (id);


--
-- Name: cours_devise cours_devise_id_devise_fkey; Type: FK CONSTRAINT; Schema: public; Owner: manoary
--

ALTER TABLE ONLY public.cours_devise
    ADD CONSTRAINT cours_devise_id_devise_fkey FOREIGN KEY (id_devise) REFERENCES public.devise(id);


--
-- PostgreSQL database dump complete
--

