CREATE TABLE public."user"
(
    id bigserial NOT NULL,
    "firstName" character varying,
    "lastName" character varying,
    "middleName" character varying,
    "phoneNumber" numeric(10) NOT NULL,
    "emailId" character varying,
    "pin" numeric(6) NOT NULL,
    PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."user"
    OWNER to postgres;

COMMENT ON TABLE public."user"
    IS 'Table specific for users';