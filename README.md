# Camunda BPM and REST service example

## Tecnologies

1. Camunda apache tomcat
2. MySQL
3. Maven
4. IDE of your choice

## Installing

1. Simple maven build `mvn clean install`
2. Copy the generated WAR file to `<camunda_folder>/server/apache-tomcat-{version}/webapps`

## Testing

1. On the camunda task list: `[Tasklist] (http://localhost:8080/camunda/app/tasklist/default/#/login)`, you can:
 1. Start new process and select `Lizo Camunda App`
 2. Next you'll see the form task created in the left side
 
2. Use the REST interface to **create** and **list** tasks/processes instances.
 1. **POST** on [http://localhost:8080/lizo-camunda/rest/processes] (http://localhost:8080/lizo-camunda/rest/processes) without any parameters
 2. **GET** on [http://localhost:8080/lizo-camunda/rest/processes?page=1&size=2] (http://localhost:8080/lizo-camunda/rest/processes?page=1&size=2) passing:
  1. **page** as int parameter
  2. **size** as int parameter
