<h2><span style="text-decoration: underline;"><strong>UserManagementService</strong></span></h2>
<hr />
<h3><em>REST API - Server side</em> - based on Spring Boot supported by</h3>
<ul style="list-style-type: circle;">
<li><strong>&nbsp;JPA Hibernate</strong></li>
<li><strong>&nbsp;postgresql</strong></li>
<li>&nbsp;<strong>springfox - Swagger2</strong></li>
<li>&nbsp;<strong>Spring security</strong> (not fully deployed)</li>
</ul>
<p>  </p>
<p>This API REST works in between a Service with data layer over postgresql hosted in Docker/postgres9.6 container configured for data persistence and listening on localhost and LAN (see Application properties) for testing purposes.</p>
<blockquote>
Functionality checked with Postman app client, and traffic back-forth client-server with wireshark for facilitating understanding the processes behing the framework</blockquote>

<div><h5> Tree </h5></div>
Estructura
UserManagementService

<hr>
<div>com.jpbtech.webappservice.controller.UsuariosServiceController</div>
<br>@RestController
<br>@RequestMapping("/manager-tool")
<br> GET/POST/PUT/DELETE ... 
<hr>
<br><div>com.jpbtech.webappservice.model</div>   
<br>UsuarioInfo ~ User general info Object with atributes for Request and JPA -> DB/Table/Columns
<br>PassKeyUsers ~  Username+password Object with atributes for JPA to store password-username in different schema -> DB/Table/Columns

<br>.messagehandler.NewUserPostWrapper ~ to wrap POST requests with [User general info + password] , and separate have a shorter responsee 
<hr>
<br><div>com.jpbtech.webappservice.exceptions</div>   
<hr>
<br><div>com.jpbtech.webappservice.repository ~ for retrieving and handling data from the DB </div>  
<hr>
<br><div>com.jpbtech.webappservice.service ~ UserServiceImpl: to execute the logic behind de controller (password handling embebded </div>
<hr>
<br><div>com.jpbtech.webappservice.security ~ SecurityAPIuserManagement: Spring security config, provisional basic auth implementation with 'user' and 'password' inMemoryAuthentication , no - roles for authoritzation implemented yet. BCryptPasswordEncoder imported too for handling user's password before saving it to the DB</div>
<hr>
<br><div>com.jpbtech.webappservice.swager - http://localhost:8080/swagger-ui.html for the API information *Responses not well implemented :(  </div>
<hr>
<blockquote><h5>Pending to debug and implement:</h5>  proper Authentication between APIs with third party as OAuth, and JWT . Granting roles for Authorization for different resources/modules of the API .  Review standard response according to methods and hedaders, and handle these properly. Implement HTTPS with certificate to secure traffic data. Stablish proper routing to reach the the API and this to DB Postgresql docker</blockquote>
