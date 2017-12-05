# EstoqueWS-web
Project to study and pratice SOAP service use on course Alura

Command to generate wsdl:
wsgen -wsdl -inlineSchemas -cp bin br.com.lopes.estoque.ws.services.EstoqueWS

Command to generate classes define in the wsdl - wildfly-8.2.0.Final
wsconsume.bat -k -n -o C:\workspace\estoque-web\src C:\workspace\estoque-web\src\EstoqueWSServiceCap5.wsdl
