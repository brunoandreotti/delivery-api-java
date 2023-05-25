# Delivery API

## Spring boot

### Jakarta EE

É uma especificação/padronização que possui várias outras especificações
Por exemplo o JPA é uma especificação do Hibernate e o próprio Hibernate passou a ser a implementação da especificação JPA.
Porém existem várias outras implementações do JPA fora o Hibernate.

### Starters

São dependências que agrupam outras dependências, isso facilita e diminuiu a quantidade de dependências dentro do pom.xml

## Injeção de Dependências

Possui a função de desacoplar o código.
A técnica consiste em passar a dependência (o serviço) para o dependente (o cliente). Isso é a chamada injeção. O importante é entender que injetamos o serviço no cliente, ao invés de o próprio cliente procurar e construir o serviço que irá utilizar.

Na pratica seria:
Criar uma interface que será implementada pelos serviços.
Passar a interface como argumento/dependência da classe/cliente que usará o serviço.
É necessário criar um construtor na classe recebendo a interface como parâmetro.
Dessa maneira, na classe será possível utilizar qualquer serviço que tenha a interface implementada.
O serviço que implementa a interface virou uma dependência da classe.
Ao instanciar a classe será necessário passar um serviço com a interface implementada como argumento.
Ou seja, nos estamos injetando um serviço (dependência) na classe.
Então ao instanciar a classe será possível passar qualquer serviço como argumento desde que o serviço implemente a interface.
