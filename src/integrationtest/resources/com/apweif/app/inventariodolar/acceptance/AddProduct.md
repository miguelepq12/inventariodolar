# Agregar Producto

El usuario podrá agregar un nuevo producto, asi podrá llevar un registro de
cada producto de su inventario y se podrá calcular su precio.

Para este fin debe ingresar los siguientes datos: Nombre (_Requerido_), 
categoria (_Requerido_), descripcion (_No Requerido_), 
precio en dolares (_No Requerido_). 

### [Ejemplo Valido](- "basic")

Se ingresa el nombre del producto [Harina pan](- "#name"), una categoría existente
como [Harinas](- "#category"), una descripción [Harina precocida para hacer 
arepas](- "#description") y el precio en dolares [2](- "#price")$ y se 
[guarda](- "#result=addProduct(#name,#description,#category,#price)") 
el producto y el sistema retorna un estado [Exitoso](- "?=#result.estado") 
y un mensaje como [Producto agregado con exito](- "?=#result.mensaje"). 
Y volverá a la pantalla de inicio. 

### [Ejemplo Invalido (Datos incompletos)](- "basic2")

No se ingresa el nombre del producto [](- "#name"), se ingresa una categoría 
existente como [Harinas](- "#category"), no se ingresa una descripción 
[](- "#descrption") y el precio en dolares es [0](- "#price")$ y se 
[guarda](- "#result=addProduct(#name,#description,#category,#price)") 
el producto y el sistema retorna un estado [No Exitoso](- "?=#result.estado") 
y un mensaje como [Ingrese los datos requeridos](- "?=#result.mensaje"). 
Y volverá a la pantalla de inicio. 
