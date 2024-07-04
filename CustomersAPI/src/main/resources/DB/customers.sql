CREATE TABLE public.customers
(
    id bigint NOT NULL,
    created bigint NOT NULL,
    updated bigint NOT NULL,
    full_name character varying(50) NOT NULL,
    email character varying(100) NOT NULL,
    phone character varying(14),
    is_active boolean NOT NULL,
    PRIMARY KEY (id)
);