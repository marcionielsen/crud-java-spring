CREATE TABLE public.produto (
	id bigint GENERATED ALWAYS AS IDENTITY NOT NULL,
	nome varchar(255) NOT NULL,
	datacadastro timestamp with time zone NOT NULL,
	preco money NOT NULL,
	CONSTRAINT produto_pk PRIMARY KEY (id),
	CONSTRAINT produto_nome_unique UNIQUE (nome)
);