set JNDI_HOME=d:\JavaApp\fscontext-1_2-beta3
set classpath=.;%JNDI_HOME%\lib\fscontext.jar;%JNDI_HOME%\lib\providerutil.jar

javac Lookup.java
java -Djava.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory Lookup
