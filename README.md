# Programare Distribuită

## Materiale
Suportul de curs este disponibil aici:
* materiale de curs la https://github.com/e-scheiber/DistributedProgramming1
* suportul de curs, link direct, la https://github.com/e-scheiber/DistributedProgramming1/blob/master/DISTR1.pdf


## Exemple precompilate
Materialele pentru examen constau în următoarele programe rezolvate. Se vor alege 2 tehnologii distincte din fiecare capitol, în aşa fel încât suprapunerea temelor să fie minimă.


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
* corba: temporal (la compilare se foloseste `javac -cp ../i:.`
```
$ orbd -ORBInitialHost localhost -ORBInitialPort 1050
$ java -cp ../i:. CmmdcServer -ORBInitialHost localhost -ORBInitialPort 1050
$ java -cp ../i:. CmmdcClient -ORBInitialHost localhost -ORBInitialPort 1050
```

* corba: persistent
    va trebui sa stergeti folder-ul orb.db din server (daca exista)
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

Cap.10 Java Server Page
* jsp:
	* JSPApp: jsp/DataCalend.jsp, hello, cmmdc, prop, errhandler
	* jsphello
	* cmmdc
	* JSPApp: JSTLCore
	
	
## Adrese de grup:
	* 10lf363 at googlegroups dot com
	* 10lf362infoa at yahoogroups dot com
	* grupa7264 at gmail dot com



