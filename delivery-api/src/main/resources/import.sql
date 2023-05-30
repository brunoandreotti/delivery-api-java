insert into tb_cozinha (id, nome) values (1, 'Tailandesa');
insert into tb_cozinha (id, nome) values (2, 'Brasileira');

insert into tb_restaurante (nome, taxa_frete, cozinha_id) values ('Thai Gourmet', 10, 1);
insert into tb_restaurante (nome, taxa_frete, cozinha_id) values ('Thai Delivery', 9.50, 1);
insert into tb_restaurante (nome, taxa_frete, cozinha_id) values ('Chapa Comida Brasileira', 15, 2);

insert into tb_restaurante (nome, taxa_frete, cozinha_id) values ('Chapa Comida Brasileira', 15, 2);

insert into tb_forma_pagamento(descricao) values ('Crédito');
insert into tb_forma_pagamento(descricao) values ('Debito');