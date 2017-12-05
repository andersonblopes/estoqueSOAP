# EstoqueWS-web
Project to study and pratice SOAP service use on course Alura

Command to generate wsdl:
wsgen -wsdl -inlineSchemas -cp bin br.com.lopes.estoque.ws.services.EstoqueWS

Command to generate classes define in the wsdl - wildfly-8.2.0.Final
wsconsume.bat -k -n -o C:\workspace\estoque-web\src C:\workspace\estoque-web\src\EstoqueWSServiceCap5.wsdl

Command to generate classes from cliente define in the wsdl - JDK
wsimport -s src -p br.com.caelum.estoque.cliente    http://localhost:8080/estoque/EstoqueWS?wsdl


http://www.correios.com.br/webservices/ - WebService Correios
wsdl: http://ws.correios.com.br/calculador/CalcPrecoPrazo.asmx?WSDL