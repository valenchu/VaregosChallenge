# VaregosChallenge 

## Atencion usar el json de docs con moockon para correr la api.


## Pasos para configurar y ejecutar la aplicación con Docker


### Paso 1 : Instala el docker en tu PC

### Paso 2 : Parate en el directorio raiz del proyecto que envie, en mi caso sería

- ```bash E:\Descargas\Programas\Exercise\varegos ```

### Paso 3 : Abra la consola en ese directorio o terminal

### Paso 4 : Ejecute el siguiente comando para buildear el docker y correr la app.

- ```bash docker build -f src/dockerfile -t varegos/valen-app . ```

### Paso 5: Verificar que la Imagen Docker fue Construida

- ```bash docker images ```

- Este comando te mostrará una lista de todas las imágenes Docker disponibles en tu máquina. Busca nombre-de-tu-aplicacion en la lista.

### Paso 6 : Ejecutar el Contenedor Docker

- ```bash docker run -p 8080:8080 varegos/valen-app ```

- -p 8080:8080 mapea el puerto 8080 de tu máquina local al puerto 8080 del contenedor, que es el puerto por defecto en el que Spring Boot ejecuta la aplicación.

- nombre-de-tu-aplicacion es el nombre de la imagen que construiste en el paso anterior.

### Paso 7 : link de swagger 

- ```bash http://localhost:8080/swagger-ui/index.html# ```

### Paso 8 : Correr mockon con el json

### Paso 9 : Editar mockon con cuit o cuil y abrir el proyecto en intellij idea

- Dentro del proyecto modificar en la clase CustomerService.java la linea 107 pasarle tambien el objeto getAgendaCBU, esto genera que sobrescriba un metodo y valide el documento y tipo de documento que se le pasa retornando el json que lo posee o los json que lo poseen.


### Paso 10 : Detener el Contenedor

- ```bash docker ps ```

- Este comando te mostrará una lista de los contenedores en ejecución. Luego, usa el siguiente comando para detener el contenedor:

- ```bash docker stop <container_id> ```

- Reemplaza <container_id> con el ID del contenedor que deseas detener.