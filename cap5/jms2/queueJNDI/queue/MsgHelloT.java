class MsgHelloT{
  public static void main(String[] args){
    int n=3;
    String queueName="queue";
    if(args.length>0)
      queueName=args[0];
    if(args.length>1)
      n=Integer.parseInt(args[1]);
    MsgSenderT sender=new MsgSenderT(queueName,n);
    //SyncMsgReceiverT receiver =new SyncMsgReceiverT(queueName);
    AsyncMsgReceiverT receiver =new AsyncMsgReceiverT(queueName);
    receiver.start();
    
    try{
       Thread.sleep(1000);
    }
    catch(Exception e){}
    
    sender.start();
  }
}
