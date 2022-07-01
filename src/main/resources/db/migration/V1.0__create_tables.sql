
--Categories Table
CREATE TABLE IF NOT EXISTS public.categories
(
    id SERIAL NOT NULL,
    name character varying(30) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT category_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.categories
    OWNER to postgres;

--Users table
CREATE TABLE IF NOT EXISTS public.users
(
    id SERIAL NOT NULL,
    username character varying(30) COLLATE pg_catalog."default" NOT NULL,
    password character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT unique_username_key UNIQUE (username)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;

--Items table
CREATE TABLE IF NOT EXISTS public.items
(
    id SERIAL NOT NULL,
    name character varying(30) COLLATE pg_catalog."default" NOT NULL,
    stock integer NOT NULL,
    category integer NOT NULL,
    price integer NOT NUll,
    CONSTRAINT item_pkey PRIMARY KEY (id),
    CONSTRAINT item_name_unique UNIQUE (name),
    CONSTRAINT category_fkey FOREIGN KEY (category)
                REFERENCES public.categories (id) MATCH SIMPLE
                ON UPDATE NO ACTION
                ON DELETE NO ACTION
                NOT DEFERRABLE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.items
    OWNER to postgres;

--Lists table
CREATE TABLE IF NOT EXISTS public.lists
(
    id SERIAL NOT NULL,
    shopping_month character varying(30) COLLATE pg_catalog."default" NOT NULL,
    list_date timestamp without time zone,
    CONSTRAINT lists_pkey PRIMARY KEY (id),
    CONSTRAINT lists_shopping_month_unique UNIQUE (shopping_month)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.lists
    OWNER to postgres;

--Lists_Items table
CREATE TABLE IF NOT EXISTS public.lists_items
(
    id SERIAL NOT NULL,
    list_id integer NOT NULL,
    item_id integer NOT NULL,
    quantity integer NOT NULL,
    CONSTRAINT lists_id_pkey PRIMARY KEY (id),
    CONSTRAINT lists_items_unique UNIQUE (list_id, item_id),
    CONSTRAINT lists_fkey FOREIGN KEY (list_id)
        REFERENCES public.lists (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT DEFERRABLE,
    CONSTRAINT items_fkey FOREIGN KEY (item_id)
        REFERENCES public.items (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT DEFERRABLE
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.lists_items
    OWNER to postgres;