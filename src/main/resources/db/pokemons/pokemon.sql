-- liquibase formatted sql

-- changeset dixit:creating:pokemon
create table pokemon
(
    id         int          null,
    name       varchar(256) null,
    level      int          null,
    imageUrl   varchar(256) null,
    weight     int          null,
    created_at timestamp    null,
    constraint pokemon_to_id
        primary key (id)
)
    collate = utf8mb4_unicode_ci;