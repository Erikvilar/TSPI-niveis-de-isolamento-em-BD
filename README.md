## API PARA TESTES DE CONCORRENCIA 

### LOCK PESSIMISTA, LOCK OTIMISTA E SEM LOCK

#### COMO FUNCIONA?


```
Primeiro crie um banco de dados no MYSQL Workbench, passe como parametro o nome do banco de dados. 

spring.datasource.url=jdbc:mysql://localhost:3306/nomedobanco

Após isto inicie a aplicação SPRING com o Dashboard Spring extension junto ao Java.
```

### 1 - Insira ao menos 5 Clientes no banco de dados com o seguinte endpoint

## ENDPOINT SEM LOCK

[http://192.168.100.5:6680/pedido/cliente] -- JSON TESTE CLIENTE:

```
{

"nome":"Henry",

"cargo":"teste",

"endereco":"rua sla 1000",

"cidade":"udia",

"cep":"821378239",

"pais":"brasil",

"telefone":"19380193",

"fax":"93839018301"

}
```
[http://192.168.100.5:6680/pedido/produto]
-- JSON TESTE PARA PRODUTO
### ! Nessa parte após inserir o produto, pegue o ID  retornando como response do produto.
### Defina a quantidade para fazer os testes.
### 
```
{

"produtoNome":"playstation",

"categoriaID":1,

"preco":1500.00,

"unidadeEmEstoque":1000,

"imagem":"IMAGE/PATH"

}



USE ESTE ENDPOINT PARA TESTE DO LOCK OTIMISTA
[http://192.168.100.5:6680/pedido_otimista/produto] --  lock otimista usa  uma tabela separada devido ao uso da anotação 

@Version ou seja e nescessario usar este enpoint no caso do teste em lock otimista, 

Por ser uma tabela separada ele funciona diferente dos outros endpoints ou seja no front end use o ID fornecido do produto por este endpoint

{

"produtoNome":"playstation",

"categoriaID":1,

"preco":1500.00,

"unidadeEmEstoque":1000,

"imagem":"IMAGE/PATH"

}


```


[http://192.168.100.5:6680/pedido/novo]
-- JSON TESTE PARA CRIAR PEDIDO
### Este enpoint e crucial para o testes, para testar outro produto passe outro ID de um novo produto criado.
```
{
  
  "clienteID":1,
  
  "produtoID":1,
  
  "valueSpent":1500.00,
  
  "quantidade":1,
  
  "desconto":10
}   
```
### APÓS CRIAR CLIENTE-PRODUTO-PEDIDO
#### INICIE O FRONT-END, ABRA O " CLIENTESERVICE " 
execute o comando
```
-- npm i

-- npm run dev

-- acesse o http://localhost:5173/
```
### SELECIONE UM DOS BOTÕES AZUL COM LOCK OTIMISTA SEM LOCK OTIMISTA E SEM LOCK
### CLICK NOS TESTES MARCADOS COM CORES AMARELO, VERMELHO, E LARANJA

##  _E importante mecionar que os produtos podem esgotar conforme faz os testes cada testes e separado em um component, então no front end e nescessario mudar o ID do produto, pois caso esteja esgotado o teste termina_ 
![alt text](https://github.com/Erikvilar/TSPI-niveis-de-isolamento-em-BD/blob/f38de834f0e692fc225abf26704b47456ac8e6ec/assets/content.png)

![Descrição da imagem](https://github.com/Erikvilar/TSPI-niveis-de-isolamento-em-BD/blob/e64c574368b43d02c5bf41c50327b836da2ba751/assets/testes.png)


