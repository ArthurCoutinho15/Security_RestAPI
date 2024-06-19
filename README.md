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
    <li>userDetailsService(): Gerencia os detalhes dos usuários em memória..</li>
    <li>passwordEncoder(): Configura o codificador de senha BCrypt.</li>
  </ul>


