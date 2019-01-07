# Programare Distribuită

## Materiale
Suportul de curs este disponibil aici:
* materiale de curs la https://github.com/e-scheiber/DistributedProgramming1 , https://github.com/e-scheiber/DistributedProgramming2 
* suportul de curs, link direct, la https://github.com/e-scheiber/DistributedProgramming1/blob/master/DISTR1.pdf


## Exemple precompilate
Materialele pentru examen constau în următoarele programe rezolvate. Se vor alege 2 tehnologii distincte din fiecare capitol, în aşa fel încât suprapunerea temelor să fie minimă. Se vor modifica în aşa fel încât să implementeze tema aleasă.


### Cap.2 Programare cu socluri Java (folder-ul socluri)
* socket: cmmdc_simplu, cmmdc, maven, streaming (doar unul)
* datagram: cmmdc, broadcast, multicast
* AdreseIP
* channel: socket, datagram, selector
* asyncchannel

Se va alege socket şi asyncchannel, de exemplu, dar nu socket cmmdc şi socket maven.


### Cap.3 Regasirea obiectelor prin servicii de nume (JNDI) 
* jndi: fs_app, ldap

Ambele sunt obligatorii.


### Cap.4 Invocarea procedurilor la distanta
* cmmdc0, iiop
* corba: temporal (la compilare se foloseste `javac -cp ../i:.` ):
```
$ orbd -ORBInitialHost localhost -ORBInitialPort 1050
$ java -cp ../i:. CmmdcServer -ORBInitialHost localhost -ORBInitialPort 1050
$ java -cp ../i:. CmmdcClient -ORBInitialHost localhost -ORBInitialPort 1050
```

* corba: persistent
Va trebui sa stergeti folder-ul orb.db din server (daca exista).
```
$ orbd -ORBInitialPort 1050 -serverPollingTime 200
$ servertool -ORBInitialPort 1050
servertool > register -server PersistentServer -applicationName PersistentCmmdcServer -classpath .:../i
$ java -cp .:../i PersistentClient
```


### Cap.5 Mesaje in Java
* queueJNDI: (se instaleaza MessageQueue5.1 prin editarea fisierului de configurare) 
```
$ mq/bin/imqbrokerd
$ ant -f build.xml compile
$ sh mqaddobj.sh
$ ant -f build.xml run
$ sh mqdelobj.sh
```
* topicJNDI
* Cmmdc: (se customizeaza caile catre MessageQueue5.1 in fisierele .sh)
```
$ mq/bin/imqbrokerd
$ source cpath.sh (se seteaza classpath in environment)
$ javac -cp $classpath *.java
$ sh server.sh
$ sh sender.sh
$ sh receiver.sh
```


### Cap.9 HyperText Transfer Protocol
* servlet30: 
	* helloDescriptiv, helloProgramat, async (embedded, lambda), maven, myservlet
	* httpclient (merge cu myservlet-ul de mai sus)
	* servere inlantuite (apelati `http://localhost:8080/myservlet/verif.html` in myservlet, parametri nr. reale)
	* sesiune de lucru (acelasi myservlet)
	* cookie (myservlet, Apelari.java)
	* Timer
	* autentificare
	* graphgif (tot in myservlet)
	* upload
	* download
	* filtru: descriptiv, programat
	* listener


### Cap.10 Java Server Page
* jsp:
	* JSPApp: jsp/DataCalend.jsp, hello, cmmdc, prop, errhandler
	* jsphello
	* cmmdc
	* JSPApp: JSTLCore
	* JSPApp: JSTLsql
	* marcaje personale: 
	    * mytag (dateTag - fara atribute si fara corp)
	    * mytag (ziuaTag - cu atribute si fara corp)
	    * mytag (modTextTag - cu corp)
	    
	    
### Cap.11 Desfăşurarea în nor
* GAE: appcmmdc, appcmmdcjsp
* Docker:
    * instalarea s-a făcut sub Fedora Linux folosind:
```
$ sudo dnf install docker
```
urmată de verificare:
```
$ sudo service docker start
$ sudo docker run hello-world
```
Rularea lui jetty:
```
$ sudo docker pull docker.io/varsy/jetty
$ sudo docker run -p 8080:8081 -d -i -t docker.io/varsy/jetty /run-jetty.sh
$ sudo docker ps
$ sudo docker cp ../cap10/jsp/cmmdc/dist/JSPCmmdc.war 16cede499e20:/home/jetty/jetty-current/webapps
$ sudo docker kill 16cede499e20
```


### Cap.12 Java Web Start
* servlet: cmmdc-src/tojar.bat
	* se muta cmmdc.jar in ../cmmdc/app
	* se copiaza jnlp-servlet.jar in ../cmmdc/WEB-INF/lib
	* se creeaza cmmdc.war
	* pentru OpenJDK, se instaleaza pachetul icedtea-web ce furnizeaza javaws
	* se asociaza fisierul .jnlp cu javaws


### Cap.13 Web Socket
* websocket/tomcat-glassfish: CmmdcAD, CmmdcID, Params, clientJava
* websocket/glassfish: CmmdcADcoders


## Adrese de grup
* 10lf363 at googlegroups dot com
* 10lf362infoa at yahoogroups dot com
* grupa7264 at gmail dot com



