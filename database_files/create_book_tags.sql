-- Table: public.book_tags

-- DROP TABLE public.book_tags;

CREATE TABLE public.book_tags
(
    isbn_13 character varying(13) COLLATE pg_catalog."default" NOT NULL,
    tag_name character varying(100) COLLATE pg_catalog."default",
    content bytea,
    CONSTRAINT book_tags_pkey PRIMARY KEY (isbn_13)
)

TABLESPACE pg_default;

ALTER TABLE public.book_tags
    OWNER to pubhubuser;