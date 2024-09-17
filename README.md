# Atividade prática:
Construa uma aplicação REST utilizando Spring boot, realizando o CRUD em uma entidade no banco de dados e que utilize o Spring Security como camada de segurança.
## Comandos Úteis:
1. Inicializar o docker
docker compose up -d
2. Acessar o banco de dados
docker exec -it mysql mysql -u root -p
3. Criar usuario e senha utilizando hash
insert into usuarios (nome_de_usuario, senha) values ('usuario', '$2a$12$Ucg1nMr9Xlwd1sQSjWhFke6b2Nxel1amlKCnb3aqrHrXmtB2r15Qe');
4. Criar variável de ambiente
export SECRET=987654321
5. Mostrar variável de ambiente
echo $SECRET
Depois eu preciso gerar um token no auth.http e usá-lo na minha aplicação