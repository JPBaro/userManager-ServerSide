##Note: Authentication+Authorization with Auth0+JWT - testing with in-memory credentials username/password (jpb/123) (**GET Method at /login  just for testing** still pending HTTPS implementation. - For working with UserManager-ClientSide switch to No-Auth branch of this repository, as sending credentials are not yet implemented in the other app
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
<p>This API REST is meant to work in between: <b>Client (UI Angular)</b> and a Data layer over postgresql hosted in Docker/postgres9.6 container configured for data persistence and listening on localhost and LAN (see Application properties) for testing purposes.</p>
<blockquote>
Functionality checked with Postman app client, and traffic back-forth client-server with wireshark for facilitating understanding the processes behing the framework</blockquote>

<div><h5> Tree </h5></div>
Estructura
UserManagementService

<hr>
<div><h6>com.jpbtech.webappservice.controller.UsuariosServiceController</h6></div>
<br>@RestController
<br>@RequestMapping("/manager-tool")
<br> GET/POST/PUT/DELETE ... 
<hr>
<br><div><h6>com.jpbtech.webappservice.model</h6></div>   
<br>UsuarioInfo ~ User general info Object with atributes for Request and JPA -> DB/Table/Columns
<br>PassKeyUsers ~  Username+password Object with atributes for JPA to store password-username in different schema -> DB/Table/Columns

<br><h6>.messagehandler.NewUserPostWrapper</h6> ~ to wrap POST requests with [User general info + password] , and separate have a shorter responsee 
<hr>
<br><div><h6>com.jpbtech.webappservice.exceptions</h6></div>   
<hr>
<br><div><h6>com.jpbtech.webappservice.repository</h6> ~ for retrieving and handling data from the DB </div>  
<hr>
<br><div><h6>com.jpbtech.webappservice.service ~ UserServiceImpl:</h6> to execute the logic behind de controller (password handling embebded </div>
<hr>
<br><div><h6>com.jpbtech.webappservice.security ~ SecurityAPIuserManagement:</h6> Spring security config, provisional basic auth implementation with 'user' and 'password' inMemoryAuthentication , no - roles for authoritzation implemented yet. BCryptPasswordEncoder imported too for handling user's password before saving it to the DB</div>
<hr>
<br><div><h6>com.jpbtech.webappservice.swager</h6> - http://localhost:8080/swagger-ui.html for the API information *Responses not well implemented :(  </div>
<hr>
<blockquote><h5>Pending to debug and implement:</h5>  proper Authentication between APIs with third party as OAuth, and JWT . Granting roles for Authorization for different resources/modules of the API .  Review standard response according to methods and hedaders, and handle these properly. Implement HTTPS with certificate to secure traffic data. Stablish proper routing to reach the the API and this to DB Postgresql docker</blockquote>
