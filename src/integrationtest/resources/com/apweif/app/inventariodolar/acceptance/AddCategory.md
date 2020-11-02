# Agregar Categoría

El usuario podrá agregar una nueva categoría asi podrá organizar su lista de 
productos.

Para este fin debe ingresar los siguientes datos: nombre (_Requerido_), 
descripcion (_No Requerido_), 
color (_Requerido_). 

### [Ejemplo Valido](- "basic")

Se ingresa el nombre de la categoría [Bebida](- "#name"), 
una descripción [Categoría de bebidas liquidas](- "#description") y el 
color como [Orange](- "#color") y se 
[guarda](- "#result=addCategory(#name,#description,#color)") 
la categoría y el sistema retorna un estado [Exitoso](- "?=#result.estado") 
y un mensaje como [Categoría agregada con exito](- "?=#result.mensaje"). 
Y volverá a la pantalla de inicio. 

### [Ejemplo Invalido (Datos incompletos)](- "basic2")

No se ingresa el nombre de la categoría [](- "#name"), 
no se ingresa una descripción [Categoría de bebidas liquidas](- "#description") y el 
color como [Orange](- "#color") y se 
[guarda](- "#result=addCategory(#name,#description,#color)") 
la categoría y el sistema retorna un estado [No Exitoso](- "?=#result.estado") 
y un mensaje como [Ingrese los datos requeridos](- "?=#result.mensaje"). 
Y volverá a la pantalla de inicio. 