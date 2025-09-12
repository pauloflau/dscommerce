# 🎯 Sistema de Estudo - Loja Virtual  
O sistema é um **projeto de estudo** desenvolvido para acompanhar o curso do **Nélio Alves**, tendo como ponto de partida a modelagem de um banco de dados para então aplicar:

- Desenvolvimento de APIs REST com **Spring Boot**
- Mapeamento objeto-relacional (ORM) com **JPA / Hibernate**
- Boas práticas de camadas de **serviço e repositório**
- Tratamento de **relacionamentos entre entidades** no contexto do Spring
- Construção de um backend robusto que pode ser consumido por aplicações web ou mobile

---

## 🚀 Tecnologias para Implementação

- Backend: **Java + Spring Boot**
- Banco de Dados: **PostgreSQL / MySQL**
- Frontend: **Angular ou React**
- Ferramentas de Build: **Maven**
- Containerização: **Docker**

---

## 📑 Entidades do Sistema  

#### 🔹 PRODUTO  
#### 🔹 PEDIDO  
#### 🔹 USUARIO  
#### 🔹 CATEGORIA
#### 🔹 ITEMPEDIDO
#### 🔹 PAGAMENTO  

---

## 🔗 Relacionamentos  

- **Produto ↔ Pedido** → Muitos-para-Muitos (via ItemPedido)  
- **Produto ↔ Categoria** → Muitos-para-Muitos  
- **Pedido ↔ Usuário** → Muitos pedidos pertencem a 1 usuário  
- **Pedido ↔ Pagamento** → 1 pedido pode ter 0 ou 1 pagamento (1-para-1 opcional)  

---

## 🛠️ Modelagem Relacional (SQL - DDL)

```sql
CREATE TABLE USUARIO (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefone VARCHAR(20),
    dataAniversario DATE,
    senha VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE PRODUTO (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL,
    imagem VARCHAR(255)
);

CREATE TABLE CATEGORIA (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

-- Relacionamento N:N entre Produto e Categoria
CREATE TABLE PRODUTO_CATEGORIA (
    produto_id BIGINT,
    categoria_id BIGINT,
    PRIMARY KEY (produto_id, categoria_id),
    FOREIGN KEY (produto_id) REFERENCES PRODUTO(id),
    FOREIGN KEY (categoria_id) REFERENCES CATEGORIA(id)
);

CREATE TABLE PEDIDO (
    id BIGINT PRIMARY KEY,
    momento TIMESTAMP NOT NULL,
    status VARCHAR(30) NOT NULL,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES USUARIO(id)
);

CREATE TABLE ITEMPEDIDO (
    pedido_id BIGINT,
    produto_id BIGINT,
    quantidade INT NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (pedido_id, produto_id),
    FOREIGN KEY (pedido_id) REFERENCES PEDIDO(id),
    FOREIGN KEY (produto_id) REFERENCES PRODUTO(id)
);

CREATE TABLE PAGAMENTO (
    id BIGINT PRIMARY KEY,
    momento TIMESTAMP NOT NULL,
    pedido_id BIGINT UNIQUE,
    FOREIGN KEY (pedido_id) REFERENCES PEDIDO(id)
);
```

---


