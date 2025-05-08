# Proyecto para Sistemas distribuidos

Los jars usados por el projecto están en la carpeta lib, configúrenlos en NetBeans

## Otra cosa importante

Acabo de modificar el código para usar UTF-8 en todas partes (también en la base de datos)  
Es posible que deban configurar sus servidores para manejar UTF-8 en sus conexiones  

Para Apache Tomcat, añadan URIEncoding en <Connector> en su server.xml y pongan "UTF-8"  
como argumento. Algo así:  

```
<Connector port="8080" protocol="HTTP/1.1"
           connectionTimeout="20000"
           redirectPort="8443"
           maxParameterCount="1000"
           URIEncoding="UTF-8"
           />
```  

No sé como es para Glassfish XD (si no tienen problemas con el encoding en Glassfish  
déjenlo así no más).