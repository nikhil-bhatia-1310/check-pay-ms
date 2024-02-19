-- Table: public.user

-- DROP TABLE IF EXISTS public."user";

CREATE TABLE IF NOT EXISTS public."user"
(
    id bigint NOT NULL,
    email_id character varying(255) COLLATE pg_catalog."default",
    first_name character varying(255) COLLATE pg_catalog."default",
    last_name character varying(255) COLLATE pg_catalog."default",
    middle_name character varying(255) COLLATE pg_catalog."default",
    phone_number bigint NOT NULL,
    pin integer NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS public."account" (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(255) NULL DEFAULT NULL,
  `account_number` DATETIME(6) NULL DEFAULT NULL,
  `ifsc_code` VARCHAR(255) NULL DEFAULT NULL,
  `bank` VARCHAR(255) NULL DEFAULT NULL,
  `created_on` VARCHAR(255) NULL DEFAULT NULL,
  `status` DATETIME(6) NULL DEFAULT NULL
  PRIMARY KEY (`id`),
  CONSTRAINT FOREIGN KEY (`user_id`)
    REFERENCES `public`.`user` (`id`)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."user"
    OWNER to postgres;

ALTER TABLE IF EXISTS public."account"
    OWNER to postgres;
    
-- SEQUENCE: public.user_seq

-- DROP SEQUENCE IF EXISTS public.user_seq;

CREATE SEQUENCE IF NOT EXISTS public.user_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.user_seq
    OWNER TO postgres;