# Login

Para ingresar a la aplicación es necesario una pantalla de inicio de sesión
donde se ingresará un usuario y una contraseña.

Por lo tanto al ingresar un usuario o contraseña el sistema debe validarlo
y retornar una respuesta.


### [Ejemplo Valido](- "basic")

Se ingresa el usuario valido [miguelepq](- "#user") con la contraseña
valida [1234](- "#pass") asi que el sistema [retorna](- "#result= login(#user,#pass)") 
un estado [Exitoso](- "?=#result.estado").

### [Ejemplo Invalido](- "basic2")
Se ingresa el usuario valido [miguelepq](- "#user") con la contraseña
invalida [12](- "#pass") asi que el sistema [retorna](- "#result= login(#user,#pass)") 
un estado [No Exitoso](- "?=#result.estado") y el mensaje 
[Datos ingresados son invalidos](- "?=#result.mensaje").





