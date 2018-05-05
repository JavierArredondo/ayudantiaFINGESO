# Ayudantía FINGESO: Entorno de desarrollo

En la ayudantía se ha visto como trabaja el entorno de desarrollo y cómo se desarrolla con este. El presente repositorio tiene la funcionalidad de servir como tutorial de Spring Framework y un repaso de conceptos que deben ser manejados en la asignatura Fundamentos de Ingeniería de Software.

## Herramientas
En el transcurso del semestre se desarrollará una aplicación web, por lo cual se recomienda utilizar las siguientes herramientas de desarrollo:
- **JDK 1.8:** Java Development Kit (herramientas de desarrollo de Java), es decir, un conjunto de herramientas, utilidades y documentación para desarrollar aplicaciones Java. [[_JDK_](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html?ssSourceSiteId=otnes)].
- **Gradle:** Es una herramienta que automatiza el proceso de construcción de nuestro código. [[_Gradle_](https://gradle.org/install/), se recomienda versión 4.6].
- Algún IDE (Recomendado [_IntelliJ IDEA_](https://www.jetbrains.com/idea/).)

### Herramientas específicas de este proyecto de prueba:

- **MySql:** Es un motor de base de datos relacional. Se recomienda utilizar la versión 5.7. [Para obtener MySql, se propone utilizar [_Docker_](https://www.docker.com/) (Investigar brevemente sobre esto)].
- **MySql Workbench:** Es un visualizador y gestor para MySql. [[_MySQL Workbench_](https://www.mysql.com/products/workbench/)].
- **Tester de APIs:** [_Advanced REST client (Extensión de Chrome)_](https://chrome.google.com/webstore/detail/advanced-rest-client/hgmloofddffdnphfgcellkdfbfbjeloo) o [_Postman_](https://www.getpostman.com/apps).

## Conocimientos previos
A continuación se presenta una serie de conceptos que deberían manejar y algunos que deberían haber investigado para la primera entrega.

### Programación Orientada a Objetos
- **Clase:**  Modelo o plantilla de un conjunto de objetos.
- **Objeto:** Instancia de una clase.
- **Interfaz:** Colección de métodos abstractos y propiedades constantes. En las interfaces se especifica qué se debe hacer pero no su implementación. 
- **Herencia:** Definir una clase tomando como base a otra clase ya existente.


### Framework
- **Framework:** Es un esquema para el desarrollo y/o la implementación de una aplicación.
- **Spring Framework:** [_Leer entrada_](http://curiotek.com/2017/06/16/java-que-es-spring/).
- **Spring boot:** [_Leer entrada_](https://www.arquitecturajava.com/que-es-spring-boot/).

### Otros
- **Anotaciones Java:** Es una forma de agregar metadatos a código en Java. Esto se hace a través de un `@`, por ejemplo `@Override`. A través de esta técnica podemos variar el comportamiento de ciertos métodos o atributos.
- **Dependencias:** Es una referencia a ciertos elementos, librerías o código externo que se incluye en el código propio. Por ejemplo, si se desea realizar la conexión a una base de datos, solo va a bastar con escribir a dónde se hará la conexión, en vez de modelar manualmente la conexión.

[Documentación de Spring Framework](https://spring.io/docs)

## Proyectos en Spring Framework

### Nuevo proyecto:
Para crear un nuevo proyecto existen dos pasos con la misma efectividad:

##### Con Spring Initializr 
- Dirigirse a [Spring Initializr](https://start.spring.io/).
- Definir los aspectos de la aplicación ( en la parte superior escoger Gradle Project en vez de Maven Project).
- Llenar los metadatos del proyecto.
- Escoger dependencias a utilizar (Generalmente se utilizan <span class="badge badge-primary">Web</span>, <span class="badge badge-danger">Rest Repository</span>, <span class="badge badge-success">Security</span>, etc). 
- Descargar proyecto.
- Abrir proyecto en IDE.

[Imagen](https://ibb.co/gDeZR7)

##### Con Intelij IDEA
- Dirigirse a la pestaña `File> New > Project...`
- Escoger la opción Spring Initializr y marcar la opción Default (Deben asegurarse de tener el JDK referenciado al que instalaron en su máquina).
- Definir los aspectos de la aplicación y llenar los metadatos de la aplicación.
- Escoger dependencias a utilizar.
- Generar proyecto.

[Imagen](https://ibb.co/nABQYn)


Es normal que para las dos opciones se demore al iniciar por primera vez, esto ocurre porque se están instalando las dependencias seleccionadas.

### Estructura de proyecto:

[Imagen](https://ibb.co/kfVPR7)

- **src:** Donde se encuentran las clases de Java.
  - **main**
    - **java:** Acá debe ir la definición de clases.
    - **resources:** Acá van los recursos de la aplicación. Además los elementos del front-end.
      - application.properties: Es el archivo más importante para las conexiones hacia el exterior de la aplicación, ya que se encarga de definir el puerto de la aplicación y las conexiones a las distintas bases de datos.
  - **test:** -
- **build.gradle:** Archivo de configuración para la compilación del proyecto. En este archivo, también se encuentra la definición de dependencias del proyecto.
- **gradlew.bat:** -
- **settings.gradle:** -

Los - (guiones) representan directorios o archivos que veremos mas adelante, ya que no tienen mayor incidencia en el proyecto, a no ser de que quieran realizar acciones más avanzadas.

## Cómo crear un servicio en pocos pasos con Spring Framework:
- Primero deben crear tres directorios en `src > java > com.example.demo`:
   - `models`: En este directorio definirán los modelos que han identificado en su problema (deben modelar la solución en base a clases de Java).
   - `repositories`: En este directorio se debe contruir los repositorios/operaciones que se harán sobre los modelos.
   - `services`: En este directorio se realizará la creación de los servicios, es decir, lo que se consumirá desde el front-end.
   - **Observación:** Estos directorios son solo recomendaciones, pueden perfectamente utilizar más o menos deestos, es solo para mantener orden. 
- Luego en `models` se deben definir todos los modelos identificados, esto contempla: atributos, constructores y métodos (incluyendo getter y setter). Por otro lado, se debe definir el modelo como `@Entity` en caso de ser Entidad (relacional) o `@Document` en caso de ser documento (no relacional).
- En `repositories` deben crear una `interface` para cada modelo, la cual debe heredar de `JPArepository` (investigar las diferencias de `CRUDrepository`, `PagingAndSortingRepositry` y `JPArepository`). A través de esta herencia, indicamos que el repositorio creado tendrá todos los métodos de la clase padre.
- Posteriormente se debe crear un servicio para cada modelo en `services`, en donde se debe indicar la `path` para el servicio y en casos específicos para las operaciones realizadas. Es en esta instancia donde se crea la conexión de la API como tal, se recomienda ver la estructura del servicio de este proyecto.
- Finalmente se debe habilitar el puerto de la aplicación en `application.properties`, además de realizar la conexión a las bases de datos correspondientes (observar como está definida `application.properties` en este proyecto).
- Probar con Advanced REST client o Postman los servicios creados a las direcciones correspondientes (`{protocol}://{domain}:[port]/{collection}/api/{version}/{resource}` o en español `http://localhost:[port]/{collection}`).

Lean las buenas prácticas de las API REST de [Pablo Ulloa](http://slides.com/prulloac/deck#/).

Siéntanse libres de ocupar la base de datos MySql con las siguientes credenciales:
```json
{
  "Hostname": "165.227.103.73",
  "Port": 3306,
  "Username": "root",
  "Password": "password"  
  }
``` 
Si quieren probar algunas APIs o saber como funcionan, les recomiendo ver:
- https://pokeapi.co/
- https://swapi.co/