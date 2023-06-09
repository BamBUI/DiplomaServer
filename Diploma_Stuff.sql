PGDMP         	                {            Diploma_Stuff    14.2    14.2 )    :           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ;           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            <           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            =           1262    230080    Diploma_Stuff    DATABASE     l   CREATE DATABASE "Diploma_Stuff" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';
    DROP DATABASE "Diploma_Stuff";
                postgres    false                        3079    230084 	   uuid-ossp 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;
    DROP EXTENSION "uuid-ossp";
                   false            >           0    0    EXTENSION "uuid-ossp"    COMMENT     W   COMMENT ON EXTENSION "uuid-ossp" IS 'generate universally unique identifiers (UUIDs)';
                        false    2            �            1259    230310    address    TABLE     �   CREATE TABLE public.address (
    id uuid NOT NULL,
    name character varying(255) NOT NULL,
    x_coordinate character varying(25) NOT NULL,
    y_coordinate character varying(25) NOT NULL,
    city character varying(25) NOT NULL
);
    DROP TABLE public.address;
       public         heap    postgres    false            �            1259    230315    category    TABLE     a   CREATE TABLE public.category (
    id uuid NOT NULL,
    name character varying(255) NOT NULL
);
    DROP TABLE public.category;
       public         heap    postgres    false            �            1259    230320    events    TABLE     �   CREATE TABLE public.events (
    id uuid NOT NULL,
    date date NOT NULL,
    "time" time without time zone NOT NULL,
    numusers integer NOT NULL,
    address_id uuid,
    users_id uuid
);
    DROP TABLE public.events;
       public         heap    postgres    false            �            1259    230168    flyway_schema_history    TABLE     �  CREATE TABLE public.flyway_schema_history (
    installed_rank integer NOT NULL,
    version character varying(50),
    description character varying(200) NOT NULL,
    type character varying(20) NOT NULL,
    script character varying(1000) NOT NULL,
    checksum integer,
    installed_by character varying(100) NOT NULL,
    installed_on timestamp without time zone DEFAULT now() NOT NULL,
    execution_time integer NOT NULL,
    success boolean NOT NULL
);
 )   DROP TABLE public.flyway_schema_history;
       public         heap    postgres    false            �            1259    230095    roles    TABLE     C   CREATE TABLE public.roles (
    name character varying NOT NULL
);
    DROP TABLE public.roles;
       public         heap    postgres    false            �            1259    230180    tokens    TABLE     y   CREATE TABLE public.tokens (
    user_id uuid NOT NULL,
    value character varying(255) NOT NULL,
    killed boolean
);
    DROP TABLE public.tokens;
       public         heap    postgres    false            �            1259    230325 
   userevents    TABLE     `   CREATE TABLE public.userevents (
    id uuid NOT NULL,
    events_id uuid,
    users_id uuid
);
    DROP TABLE public.userevents;
       public         heap    postgres    false            �            1259    230102    users    TABLE     '  CREATE TABLE public.users (
    id uuid NOT NULL,
    firstname character varying(100) NOT NULL,
    lastname character varying(100) NOT NULL,
    role character varying,
    email character varying(25) NOT NULL,
    password character varying(120) NOT NULL,
    enabled boolean DEFAULT true
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    230192    verification_tokens    TABLE     �   CREATE TABLE public.verification_tokens (
    id uuid NOT NULL,
    token character varying(255),
    user_id uuid NOT NULL,
    expiry_date timestamp without time zone,
    confirmed boolean NOT NULL
);
 '   DROP TABLE public.verification_tokens;
       public         heap    postgres    false            4          0    230310    address 
   TABLE DATA           M   COPY public.address (id, name, x_coordinate, y_coordinate, city) FROM stdin;
    public          postgres    false    215   y/       5          0    230315    category 
   TABLE DATA           ,   COPY public.category (id, name) FROM stdin;
    public          postgres    false    216   �/       6          0    230320    events 
   TABLE DATA           R   COPY public.events (id, date, "time", numusers, address_id, users_id) FROM stdin;
    public          postgres    false    217   �/       1          0    230168    flyway_schema_history 
   TABLE DATA           �   COPY public.flyway_schema_history (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success) FROM stdin;
    public          postgres    false    212   �/       /          0    230095    roles 
   TABLE DATA           %   COPY public.roles (name) FROM stdin;
    public          postgres    false    210   �/       2          0    230180    tokens 
   TABLE DATA           8   COPY public.tokens (user_id, value, killed) FROM stdin;
    public          postgres    false    213   
0       7          0    230325 
   userevents 
   TABLE DATA           =   COPY public.userevents (id, events_id, users_id) FROM stdin;
    public          postgres    false    218   '0       0          0    230102    users 
   TABLE DATA           X   COPY public.users (id, firstname, lastname, role, email, password, enabled) FROM stdin;
    public          postgres    false    211   D0       3          0    230192    verification_tokens 
   TABLE DATA           Y   COPY public.verification_tokens (id, token, user_id, expiry_date, confirmed) FROM stdin;
    public          postgres    false    214   a0       �           2606    230314    address address_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.address DROP CONSTRAINT address_pkey;
       public            postgres    false    215            �           2606    230319    category category_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.category DROP CONSTRAINT category_pkey;
       public            postgres    false    216            �           2606    230324    events events_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.events
    ADD CONSTRAINT events_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.events DROP CONSTRAINT events_pkey;
       public            postgres    false    217            �           2606    230175 .   flyway_schema_history flyway_schema_history_pk 
   CONSTRAINT     x   ALTER TABLE ONLY public.flyway_schema_history
    ADD CONSTRAINT flyway_schema_history_pk PRIMARY KEY (installed_rank);
 X   ALTER TABLE ONLY public.flyway_schema_history DROP CONSTRAINT flyway_schema_history_pk;
       public            postgres    false    212            �           2606    230196 *   verification_tokens pk_verification_tokens 
   CONSTRAINT     h   ALTER TABLE ONLY public.verification_tokens
    ADD CONSTRAINT pk_verification_tokens PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.verification_tokens DROP CONSTRAINT pk_verification_tokens;
       public            postgres    false    214            �           2606    230101    roles roles_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (name);
 :   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_pkey;
       public            postgres    false    210            �           2606    230184    tokens tokens_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.tokens
    ADD CONSTRAINT tokens_pkey PRIMARY KEY (user_id);
 <   ALTER TABLE ONLY public.tokens DROP CONSTRAINT tokens_pkey;
       public            postgres    false    213            �           2606    230186    tokens tokens_value_key 
   CONSTRAINT     S   ALTER TABLE ONLY public.tokens
    ADD CONSTRAINT tokens_value_key UNIQUE (value);
 A   ALTER TABLE ONLY public.tokens DROP CONSTRAINT tokens_value_key;
       public            postgres    false    213            �           2606    230329    userevents userevents_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.userevents
    ADD CONSTRAINT userevents_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.userevents DROP CONSTRAINT userevents_pkey;
       public            postgres    false    218            �           2606    230178    users users_email_key 
   CONSTRAINT     Q   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key UNIQUE (email);
 ?   ALTER TABLE ONLY public.users DROP CONSTRAINT users_email_key;
       public            postgres    false    211            �           2606    230108    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    211            �           1259    230176    flyway_schema_history_s_idx    INDEX     `   CREATE INDEX flyway_schema_history_s_idx ON public.flyway_schema_history USING btree (success);
 /   DROP INDEX public.flyway_schema_history_s_idx;
       public            postgres    false    212            �           2606    230350    events fk_address_id    FK CONSTRAINT     x   ALTER TABLE ONLY public.events
    ADD CONSTRAINT fk_address_id FOREIGN KEY (address_id) REFERENCES public.address(id);
 >   ALTER TABLE ONLY public.events DROP CONSTRAINT fk_address_id;
       public          postgres    false    217    215    3224            �           2606    230109    users fk_roles    FK CONSTRAINT     l   ALTER TABLE ONLY public.users
    ADD CONSTRAINT fk_roles FOREIGN KEY (role) REFERENCES public.roles(name);
 8   ALTER TABLE ONLY public.users DROP CONSTRAINT fk_roles;
       public          postgres    false    210    3209    211            �           2606    230355    events fk_users_id    FK CONSTRAINT     l   ALTER TABLE ONLY public.events
    ADD CONSTRAINT fk_users_id FOREIGN KEY (id) REFERENCES public.users(id);
 <   ALTER TABLE ONLY public.events DROP CONSTRAINT fk_users_id;
       public          postgres    false    211    3213    217            �           2606    230197 2   verification_tokens fk_verification_tokens_on_user    FK CONSTRAINT     �   ALTER TABLE ONLY public.verification_tokens
    ADD CONSTRAINT fk_verification_tokens_on_user FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE CASCADE;
 \   ALTER TABLE ONLY public.verification_tokens DROP CONSTRAINT fk_verification_tokens_on_user;
       public          postgres    false    3213    211    214            �           2606    230202    tokens tokens_user_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.tokens
    ADD CONSTRAINT tokens_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE CASCADE;
 D   ALTER TABLE ONLY public.tokens DROP CONSTRAINT tokens_user_id_fkey;
       public          postgres    false    3213    211    213            4      x������ � �      5      x������ � �      6      x������ � �      1      x������ � �      /      x������ � �      2      x������ � �      7      x������ � �      0      x������ � �      3      x������ � �     