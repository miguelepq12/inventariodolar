# Registro

Si la persona que ingresará a la aplicación no tiene usuario debe registrarse
en la misma. 

Para este fin el sistema pedira datos como el usuario, el corrreo, la contraseña
y repetir esa contraseña.

### [Ejemplo Valido](- "basic")

Se ingresa el usuario inexistente en el sistema [miguelepq](- "#user"), la 
contraseña de minimo 4 digitos [1234](- "#pass"), se repite la contraseña para 
confirmar [1234](- "#passrepeat"). Tambien se ingresa el correo
electronico inexistente [miguel@gmail.com](- "#email") del nuevo usuario. 
Al ingresar esos datos el nuevo usuario se  [registrará](- "#result=register(#user,#pass,#passrepeat,#email)") 
y el sistema retornará un estado [Exitoso](- "?=#result.estado").

### [Ejemplo Invalido 1](- "basic2")

Se ingresa el usuario existente en el sistema [miguelepq12](- "#user"), la 
contraseña de minimo 4 digitos [1234](- "#pass"), se repite la contraseña para 
confirmar [1234](- "#passrepeat"). Tambien se ingresa el correo
electronico existente [miguel12@gmail.com](- "#email") del nuevo usuario. 
Al ingresar esos datos el nuevo usuario se  [registrará](- "#result=register(#user,#pass,#passrepeat,#email)") 
y el sistema retornará un estado [No Exitoso](- "?=#result.estado") y el mensaje
[El usuario o correo ya existe. Ingrese uno nuevo](- "?=#result.mensaje").

### [Ejemplo Invalido 2](- "basic3")

Se ingresa el usuario inexistente en el sistema [miguelepq](- "#user"), la 
contraseña de menos de 4 digitos [12](- "#pass"), se repite la contraseña para 
confirmar [12](- "#passrepeat"). Tambien se ingresa el correo
electronico inexistente [miguel@gmail.com](- "#email") del nuevo usuario. 
Al ingresar esos datos el nuevo usuario se  [registrará](- "#result=register(#user,#pass,#passrepeat,#email)") 
y el sistema retornará un estado [No Exitoso](- "?=#result.estado") y el mensaje
[La contraseña no es valida](- "?=#result.mensaje").
