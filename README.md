<h1>JWT Security REST API</h1>
<p>Este projeto é uma API REST que utiliza autenticação e autorização baseada em JSON Web Tokens (JWT). Ele permite o registro de usuários, autenticação e restrição de acesso a determinadas rotas com base nas roles dos usuários (ADMIN e USER).
</p>

<h1>Estrutura do Projeto</h1>

<h2>1. AuthConfig</h2> 
<p>Arquivo de configuração de segurança onde as rotas são protegidas e os usuários são gerenciados.</p> 
<p>
Classe: AuthConfig
Pacote: br.newtonpaiva.JWT_Security_RESTAPI.config
</p>
<h2>Principais Métodos:</h2>
  <ul>
    <li>securityFilterChain(HttpSecurity http): Configura a segurança HTTP, definindo as permissões das rotas.</li>
    <li>userDetailsService(): Gerencia os detalhes dos usuários em memória.</li>
    <li>passwordEncoder(): Configura o codificador de senha BCrypt.</li>
  </ul>
  
<h2>2. AuthController</h2> 
<p>Controlador responsável pelo gerenciamento de autenticação e registro de usuários.</p> 
<p>
Classe: AuthController
Pacote: br.newtonpaiva.JWT_Security_RESTAPI.controller
</p>
<h2>Principais Métodos:</h2>
  <ul>
    <li>register(LoginRequest user): Registra um novo usuário.</li>
    <li>login(LoginRequest loginRequest): Autentica um usuário e retorna um token JWT.</li>
    <li>getUserByUsername(String username): Obtém um usuário pelo username.</li>
  </ul>
  
<h2>3. LoginRequest</h2> 
<p>Modelo de dados para requisições de login e registro de usuários.</p> 
<p>
Classe: AuthController
Pacote: br.newtonpaiva.JWT_Security_RESTAPI.model
</p>

<h2>4. AuthRepository</h2> 
<p>Repositório para interagir com o banco de dados MongoDB.</p> 
<p>
Interface: SecurityRepository
Pacote: br.newtonpaiva.JWT_Security_RESTAPI.repository
</p>












