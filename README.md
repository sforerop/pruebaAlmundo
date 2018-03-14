# pruebaAlmundo

1. Se debe clonar el proyecto en git con el siguiente comando ´git clone https://github.com/sforerop/pruebaAlmundo.git´
2. Instalar proyecto con Maven: mvn clean install
3. Se ejecutaran los casos de prueba con Junit al compilar con Maven


# Resolución del problema
1. Se crea la clase Dispatcher con el metodo dispatchCall.
2. El sistema tiene la capacidad de procesar hasta 10 llamadas concurrentes, este valida la cantidad de llamadas en curso.
3. Para asignar un tiempo a la llamada se utiliza un numero random entre 5 y 10 y se convierten a milisegundos.
4. Se crean los Test unitarios para comprobar la ejecución de las 10 llamadas concurrentes.

# Solución de Puntos Adicionales

1. Cuando no se encuentran empleados libres la llamada es encolada y procesada posteriormente cuando algun empleado vuelve a estar disponible.
2. Cuando hay más de 10 llamadas concurrentes el sistema encola las siguientes llamadas hasta que puedan ser recibidas.
3. Se realiza la documentación del codigo.

Ver el diagrama de clase 