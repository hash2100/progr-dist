export PATH=/home/honorius/projects/distr1/jms2/MessageQueue5.1/mq/bin:$PATH
imqobjmgr add -t qf -l "ConnectionFactory" -j java.naming.provider.url=file:///d:/Temp	-j java.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory 
rem imqobjmgr add -t tf -l "ConnectionFactory" -j java.naming.provider.url=file:///d:/Temp	-j java.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory 
imqobjmgr add -t q -l "queue" -j java.naming.provider.url=file:///d:/Temp	-j java.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory 
rem imqobjmgr add -t t -l "topic" -j java.naming.provider.url=file:///d:/Temp	-j java.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory 
