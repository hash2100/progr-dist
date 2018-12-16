export PATH=/home/honorius/projects/dist1/labs/cap5/jms2/MessageQueue5.1/mq/bin:$PATH
imqobjmgr add -t qf -l "ConnectionFactory" -j java.naming.provider.url=file:///tmp -j java.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory 
imqobjmgr add -t q -l "queue" -j java.naming.provider.url=file:///tmp -j java.naming.factory.initial=com.sun.jndi.fscontext.RefFSContextFactory 
