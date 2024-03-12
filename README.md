# Sistema-Vendas
Sistema desenvolvido em Java, com fins didáticos de Programação Orientada a Objetos (POO)

## Apresentação do Projeto

Uma loja vende livros e cadernos. Livro tem nome e gênero. Já caderno tem quantidade de materias. Ambos tem preço uma quantidade que pode ser comprada.
Os pedidos podem ou não ter um cupom de desconto aplicado ao valor total. Este cupom tem código e porcemtagem de desconto. Os pedidos são de um cliente, qual tem um nome e cpf.
Por fim, o valor do frete varia de acordo com a quantidade de cada item, seu preço e um fator a depender de seu tipo.

- Os tipo para livro são: DRAMA, SUSPENSE e ROMANCE. (com os fatores 0.15, 0.10 e 0.05 respectivamente. Tal fator é MULTIPLICATIVO, ao total calculado: preço*quantidade).
- Os tipo para caderno são: M2, M5 e M10. (com fatores 2, 5 e 10 respectivamente. Tal fator é ADITIVO, ao total calculado: preço*quantidade).
