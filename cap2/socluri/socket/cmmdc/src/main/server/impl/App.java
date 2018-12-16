package server.impl;

public class App {
  // Functia indeplinita de server
  interface CmmdcService {
      long cmmdc(long m, long n);
  }


  // constructia de tip "anonymous inner class" este mai lunga
  //static CmmdcService cmmdcService = new CmmdcService() {
  //  public long cmmdc(long m, long n) { 

  // implementam interfata ca obiect static
  static CmmdcService cmmdcService = (long m, long n) -> { 
    long r,c;
    do {
      c = n;
      r = m % n;
      m = n;
      n = r;
    }
    while( r!=0 );

    return c;
  }; 
  
  /*
  public long cmmdc( long m, long n ){
    return cmmdcService.cmmdc( m, n );
  }	
  */
}
