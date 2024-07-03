# Inlaze Prueba Técnica

Prueba técnica de Frontend Testing

Site: https://test-qa.inlaze.com

Documentación casos de prueba automatizados: https://versed-colby-df1.notion.site/Documentaci-n-automatizaci-n-Inlaze-Front-c81f2603382f415a8c73e0b82f80a321?pvs=4

Bug Tracking: https://versed-colby-df1.notion.site/e64b3e7e3f0e4c4f8c3a3fb1a272221f?v=1966f9c504ca41cdb3d5a0874030900d&pvs=4

## Instalar Framework

- Clonar repositorio a carpeta local

> git clone https://github.com/pipeotal89/Prueba-Tecnica.git

- Abrir la carpeta "seleniumframework" con un editor de código (VSCode preferiblemente)

![image](https://github.com/pipeotal89/Prueba-Tecnica/assets/91172603/d3f4800f-0da4-46cc-977c-27601e048303)

- Abrir un Terminal sobre la misma carpeta

- Instalar las dependencias de Maven

> mvn clean install

## Seleccionar Tests y ejecutar

- Abrir archivo "TestNGRunner.java"

![image](https://github.com/pipeotal89/Prueba-Tecnica/assets/91172603/5ef1ddd9-7fde-434a-bd9b-3d10961add33)

- Editar los tags dentro de "@CucumberOptions", acorde al tag de los test que se deseen ejecutar

- Si se desea seleccionar casos específicos, en los archivos ".feature" se puede modificar el tag individual de cada caso, y conjuntarlo con la etiqueta dentro del [TestNGRunner.java[

![image](https://github.com/pipeotal89/Prueba-Tecnica/assets/91172603/a20773bd-c204-460e-8479-3f0545f2e79d)

- Para ejecutar los tests, se escribe el siguiente comando en el terminal, siempre ubicado sobre "seleniumframework":

> mvn test


