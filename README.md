# 🩺 MedAgenda - API de Agendamento Médico
Projeto de API REST para gerenciamento de consultas médicas, desenvolvida com Java e Spring Boot.

## 📌 Funcionalidades
✅ Cadastro, atualização, listagem e exclusão de médicos e pacientes

✅ Agendamento de consultas entre médicos e pacientes

✅ Filtros por data, médico ou paciente

✅ Paginação e ordenação das consultas

✅ Cancelamento de consultas com motivo

✅ Tratamento de exceções personalizadas

✅ Mapeamento DTO com MapStruct

## 🚀 Tecnologias utilizadas
Java 21

Spring Boot

Spring Data JPA

Hibernate

Lombok

MapStruct

MySQL

Maven

## 🎯 Modelo de Dados
Entidades principais:

Medico

Paciente

Consulta (com relacionamentos @ManyToOne para médico e paciente)

## 🔒 Segurança
O projeto já conta com estrutura básica de configuração de segurança (Spring Security), com todos os endpoints liberados por enquanto.

## 📄 Requisições Suportadas
|Recurso | Verbo HTTP           | Descrição                      |
|--------|----------------------|--------------------------------|
|/medicos	|GET/POST/PUT/DELETE	|CRUD de médicos|
|/pacientes	|GET/POST/PUT/DELETE	|CRUD de pacientes|
|/consultas	|GET/POST/PUT/DELETE	|CRUD de consultas, com filtros por data, médico ou paciente|

## 📚 Aprendizados
Esse projeto foi desenvolvido com foco em aprofundar conhecimentos em:

Estruturação de APIs RESTful com boas práticas

Camadas Controller, Service, Repository

Manipulação de DTOs com MapStruct

Filtros, paginação e ordenação com Spring Data

Tratamento de exceções personalizado

Integração com banco de dados relacional

## 🤝 Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.

## 📧 Contato
Caso tenha interesse em conversar sobre o projeto:

🔗 [Victor da Costa Almada](https://www.linkedin.com/in/victor-almada/)

📫 Email: victor_mathers@hotmail.com
