Probar las Rutas
### Acceder a la página pública:

URL: http://localhost:8080/publico
Deberías ver la página pública con enlaces para acceder a las páginas privadas y de administrador.
### Acceder a la página privada como usuario:

URL: http://localhost:8080/privado?token=usuario123
Deberías ver la página privada con el mensaje "Bienvenido a la página privada. Rol: usuario".
### Acceder a la página de administrador como administrador:

URL: http://localhost:8080/admin?token=admin123
Deberías ver la página de administrador con el mensaje "Bienvenido a la página de administrador. Rol: admin".
### Intentar acceder a la página de administrador como usuario:

URL: http://localhost:8080/admin?token=usuario123
Deberías ser redirigido a la página de error con el mensaje "Acceso denegado para usuarios no administradores".
### Intentar acceder a la página privada sin token:

URL: http://localhost:8080/privado
Deberías ser redirigido a la página de error con el mensaje "No autenticado".