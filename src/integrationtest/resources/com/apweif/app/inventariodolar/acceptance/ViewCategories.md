# Ver lista de categorías

El usuario podrá ver la lista de categorías y buscarlas por el nombre.

Por lo tanto el sistema pedirá un nombre de la categoría o texto para buscar 
la categoría que contenga ese texto, 

### [Ejemplo Valido](- "basic")

El usuario no ingresa un nombre de categoría [](- "#name"), 
por lo tanto el sistema [muestra](- "#result=getCategories(#name)") 
la lista de [3](- "?=#result") categorías. 

### [Ejemplo Valido 2](- "basic2")

El usuario ingresa un nombre de categoría [Bebidas](- "#name"),
por lo tanto el sistema [muestra](- "#result=getCategories(#name)") 
la lista de [2](- "?=#result") categorías que contengan ese nombre. 