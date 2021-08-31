DROP TABLE IF EXISTS TreeSpecie;

CREATE TABLE TreeSpecie (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS Tree;

CREATE TABLE Tree (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    barcode_no VARCHAR(50) NOT NULL,
    height INT(8) NOT NULL,
    tree_specie_id INT NOT NULL,
    FOREIGN KEY (tree_specie_id) REFERENCES TreeSpecie(id)
);