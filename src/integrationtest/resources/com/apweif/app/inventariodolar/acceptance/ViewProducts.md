# Ver lista de productos y busqueda

El usuario podrá ver la lista de los productos buscarlos por nombre, 
por categorías o podrá verlos todos.

Por lo tanto el sistema pedirá la categoría de lista de productos y el nombre
si no se ingresa ninguno de esos datos se buscará todo.

### [Ejemplo Valido](- "basic")

El usuario no ingresa un nombre de busqueda [](- "#name"), ninguna 
categoría [](- "#category"), por lo tanto el sistema 
[muestra](- "#result=getProducts(#category,#name)") la lista de 
[3](- "?=#result") productos completa separada por un paginador. 

### [Ejemplo Valido 2](- "basic2")

El usuario ingresa un nombre de busqueda [Harina](- "#name") ninguna 
categoría [](- "#category"), por lo tanto el sistema 
[muestra](- "#result=getProducts(#category,#name)") la lista de 
[2](- "?=#result") productos con ese nombre o que lo contenga.

### [Ejemplo Valido 3](- "basic3")

El usuario no ingresa un nombre de busqueda [](- "#name") la  
categoría [Bebidas](- "#category"), por lo tanto el sistema 
[muestra](- "#result=getProducts(#category,#name)") la lista de 
[1](- "?=#result") productos con esa categoría.