# EasyLife

## ¿QUÉ? 

Presentamos EasyLife, el gestor personal que transforma la manera en que manejas tu vida diaria. Con una plataforma sencilla y funcional, EasyLife te ayuda a alcanzar el equilibrio perfecto entre bienestar físico. Organiza tu salud de forma fácil, accesible y eficiente. ¡Simplifica tu vida con EasyLife! 

  

## ¿POR QUÉ? 

Hoy en día, las personas enfrentan grandes dificultades para mantener el control sobre sus tareas cotidianas, en especial cuando se trata de gestionar su salud y su educación. Este tipo de desorganización afecta negativamente la vida de los individuos, generando estrés y reduciendo su calidad de vida: el no recordar citas médicas o tratamientos puede retrasar diagnósticos importantes y perjudicar el tratamiento continuo de enfermedades. Por otra parte, la mala gestión de actividades académicas puede resultar en un rendimiento académico problemático. Esta falta de organización y control es el núcleo de la problemática que abordamos. 

  

## ¿CÓMO? 

EasyLife ofrece una solución integral para abordar esta problemática. El programa combina dos funciones principales: la gestión de salud y la gestión académica. EasyLife permite a los usuarios configurar recordatorios para sus citas médicas, registrar sus tratamientos y acceder a su perfil médico de forma rápida y organizada. Esto garantiza que los usuarios se mantengan al día con sus necesidades médicas, evitando olvidos y manteniendo un registro actualizado de su historial de salud. 

Finalmente, en cuanto a la gestión académica, EasyLife proporciona una herramienta para registrar tareas y actividades, tanto realizadas como por realizar. Además, se podrán agregar a la aplicación las diversas materias que curse el estudiante, acompañadas de los porcentajes que el profesor asignó a cada corte o tipo de actividad. De esta manera, el estudiante podrá comprobar las notas que necesita para pasar un corte o realizar otras actividades universitarias. 

 

 

 

## Requerimientos funcionales 

El programa contará con un calendario visualizable que permitirá el registro de varios eventos, tanto tareas como citas médicas. Se podrán añadir citas médicas, con detalles de ubicación, motivos de la cita médica, especialidad que se visita y el médico en caso de tener el dato. El programa permitirá actualizar el perfil del usuario, tanto médico como personal, campo a campo. También permitirá ingresar los medicamentos que está tomando y modificando los existentes. El programa comprobará, teniendo en cuenta las restricciones del perfil médico y otros medicamentos si las nuevas dosis de medicamento pueden ser administradas. Por la parte educativa, el programa permitirá el registro de materias, con los porcentajes que vale cada tipo de trabajo y cada corte. Una vez registradas las materias, permitirá el registro de tareas, como eventos en el calendario. Estas tareas al tener notas y ser trabajos de algún tipo podrán ser asociadas con una materia para calcular la nota de los distintos tipos de trabajo, la nota del corte, y, con esta información, poder ofrecer una recomendación de estudio (nota mínima en algún tipo de trabajo para pasar el corte o la materia). Todas estas funcionalidades podrán accederse mediante un menú. 

 

### 1. Gestión de Perfil Médico del Usuario: 

- El sistema debe permitir al usuario crear y gestionar un perfil médico personal. 

- El perfil médico debe incluir información sobre enfermedades actuales y pasadas del usuario. 

- El perfil debe de poder actualizarlo el usuario en cualquier momento. 

  

### 2. Administración de Medicamentos: 

- El sistema debe permitir la gestión de medicamentos del usuario, incluyendo nombre del medicamento, dosis y frecuencia de administración. 

- Debe permitir registrar y gestionar la fecha de caducidad de cada medicamento. 

- El usuario debe poder ver la cantidad de medicamentos disponibles y recibir notificaciones cuando queden pocos. 

   

### 3. Calendario de Usuario: 

- El sistema debe ofrecer un calendario para gestionar eventos médicos, como citas médicas y recordatorios de toma de medicamentos. 

- El calendario también debe incluir la gestión de tareas académicas, permitiendo al usuario registrar tareas y fechas límite de las materias de la universidad. 

-   Debe poder agregar, modificar y eliminar eventos en el calendario de manera sencilla. 


  
### 4. Cálculo de Promedios Académicos: 

- El sistema debe permitir al usuario ingresar sus calificaciones de cada materia académica. 

- Debe calcular el promedio de cada materia automáticamente, y actualizarse cada vez que se añadan nuevas calificaciones. 

-El sistema debe dar recomendaciones de notas mínimas para pasar el corte o la materia. 

 

### 5. Persistencia de información: 

-El sistema debe de guardar la información para que esta persista en el tiempo. 

-El usuario al iniciar la aplicación debe de tener toda su información guardada y cargada en el sistema. 

 

## Requerimientos no funcionales 

El programa es fácilmente escalable para distintos tipos de tarea que se busquen agregar en un futuro. Esto se logra gracias a un programa en el cual cada clase y funcionalidad está bien estructurada y permite eliminar o añadir. Además, el programa es intuitivo y fácil de usar por el usuario, especialmente la parte de guardar y gestionar medicamentos, ya que podría ser usado por personas mayores que tal vez no tienen un manejo muy avanzado de los medios tecnológicos. Para esto utilizamos una interfaz visual que explica detalladamente cada funcionalidad con títulos claros y accesibles para cualquiera. A futuro se espera mejorar la seguridad de los datos ya que es importante proteger la privacidad de los usuarios, teniendo en cuenta que los eventos pueden guardar mucha información personal. 

 

 

 

 

## Funcionalidad

Este sistema implementa una clase Usuario que contiene toda la información relevante del usuario atendido. La clase almacena el perfil médico, las materias y el calendario de eventos personales del usuario, facilitando la gestión centralizada de estos datos. 

Perfil Médico: Incluye información sobre el seguro médico, medicamentos, restricciones y enfermedades del usuario. En esta sección, se verifica la compatibilidad de los medicamentos mediante una comparación entre las restricciones por alergias del usuario y los medicamentos agregados o por agregar. 

Materias: Según los porcentajes que el usuario indique, el sistema realiza cálculos automáticos a través de funciones específicas, permitiendo conocer la calificación que necesita para aprobar cada corte o alcanzar una nota específica en cada materia. 

Calendario de Eventos: Organiza una lista de eventos con fecha de inicio y fecha límite. Estos eventos pueden ser tareas, citas médicas u otros compromisos. El sistema permite almacenar y acceder fácilmente a la información de cada evento. 

Finalmente, para asegurar la persistencia de la información del usuario a lo largo del tiempo, se utiliza almacenamiento mediante archivos .txt y repositorios dedicados. Esta estructura garantiza que los datos se mantengan disponibles y actualizados, independientemente de reinicios o cierres del sistema. 
 
