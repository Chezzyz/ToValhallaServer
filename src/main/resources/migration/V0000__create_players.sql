DROP TABLE IF EXISTS players;
CREATE TABLE players
(
    id               serial      NOT NULL,
    uuid             uuid        NOT NULL,
    username         text        NOT NULL,
    game_time        bigint    NOT NULL,
    entire_fly_time  bigint    NOT NULL,
    sessions_count   integer     NOT NULL,
    coins_count      integer     NOT NULL,
    hammers_count    integer     NOT NULL,
    skins_count      integer     NOT NULL,
    artifacts_count  integer     NOT NULL,
    best_scores      text       NOT NULL,
    create_timestamp timestamptz NOT NULL DEFAULT now(),
    update_timestamp timestamptz NOT NULL DEFAULT now(),
    PRIMARY KEY (id),
    UNIQUE (id)
);
CREATE UNIQUE INDEX udx_players_id ON players USING btree (id);
CREATE UNIQUE INDEX udx_players_uuid ON players USING btree (uuid);