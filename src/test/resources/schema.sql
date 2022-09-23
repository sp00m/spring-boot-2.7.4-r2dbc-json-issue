CREATE TABLE `some_table`
(
    `id`   BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `json` JSON DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

INSERT INTO some_table (id, json) VALUE (1, '{}');