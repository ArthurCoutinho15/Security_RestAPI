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
<img src="https://github.com/ArthurCoutinho15/Security_RestAPI/blob/master/imagens/AuthCOnfig.png?raw=true" width="800px" height="600px"/>
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
<img src="https://github.com/ArthurCoutinho15/Security_RestAPI/blob/master/imagens/AuthController.png?raw=true" width="800px" height="600px"/>
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
<img src="https://github.com/ArthurCoutinho15/Security_RestAPI/blob/master/imagens/SecurityRepository.png?raw=true" width="800px" height="500px"/>

<h2>5. JwtFilter</h2> 
<p>Filtro JWT para interceptar requisições HTTP e validar tokens JWT.</p> 
<p>
Classe: JwtFilter
Pacote: br.newtonpaiva.JWT_Security_RESTAPI.security
</p>
<img src="https://github.com/ArthurCoutinho15/Security_RestAPI/blob/master/imagens/JwtFilter.png?raw=true" width="800px" height="600px"/>

<h2>6. JwtUtil</h2> 
<p>
Utilitário para geração e validação de tokens JWT.</p> 
<p>
Classe: JwtUtil
Pacote: br.newtonpaiva.JWT_Security_RESTAPI.security
</p>
<img src="https://github.com/ArthurCoutinho15/Security_RestAPI/blob/master/imagens/JwtUtil.png?raw=true" width="800px" height="600px"/>

<h2>7. AuthService</h2> 
<p>
Serviço para autenticação e autorização de usuários.</p> 
<p>
Classe: AuthService
Pacote: br.newtonpaiva.JWT_Security_RESTAPI.service
</p>
<h2>Principais Métodos:</h2>
  <ul>
    <li>generateToken(String username, String role): Gera um token JWT.</li>
    <li>extractUsername(String token): Extrai o username do token.</li>
    <li>extractUserRole(String token): Extrai a role do usuário do token.</li>
    <li>authenticateUser(String username, String password): Autentica o usuário e retorna um token JWT.</li>
    <li>saveUser(LoginRequest user): Salva um usuário no banco de dados.</li>
    <li>findByUsername(String username): Busca um usuário pelo username.</li>
    <li>validateToken(String token, UserDetails userDetails): Valida o token JWT.</li>
  </ul>

<h1>Executando Projeto</h1>
<p>Utilizando o insomnia crie uma nova requisição</p>
<h2>Rotas</h2>
<h3>Registro de Usuário</h3>
<ul>
  <li>Método: POST</li>
  <li>URL: http://localhost:8080/auth/register</li>
  <li>Permissões: Público</li>
  <li>Descrição: Registra um novo usuário.</li>
</ul>
<img src="https://github.com/ArthurCoutinho15/Security_RestAPI/blob/master/imagens/Register.png?raw=true" width="800px" height="600px"/>


<h3>Login</h3>
<ul>
  <li>Método: POST</li>
  <li>URL: http://localhost:8080/auth/login</li>
  <li>Permissões: Público</li>
  <li>Descrição: Autentica um usuário e retorna um token JWT.</li>
</ul>
<h3>Obter Usuário por Username</h3>
<ul>
  <li>Método: GET</li>
  <li>URL: http://localhost:8080/auth/user/{username}</li>
  <li>Permissões: Público</li>
  <li>Descrição: Retorna os detalhes de um usuário pelo username.</li>
</ul>
<h3>Editar Usuário</h3>
<p>Para essa rota é necessário entrar na aba de Auth types do insomnia e selecionar API key </p>
<ul>
  <li>Método: PUT</li>
  <li>URL: http://localhost:8080/auth/edit/{id}</li>
  <li>Permissões: Admin</li>
  <li>Descrição: Edita os detalhes de um usuário.</li>
</ul>





















