package CmmdcApp;

/**
* CmmdcApp/CmmdcHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Cmmdc.idl
* Sunday, November 25, 2018 7:51:26 PM EET
*/

public final class CmmdcHolder implements org.omg.CORBA.portable.Streamable
{
  public CmmdcApp.Cmmdc value = null;

  public CmmdcHolder ()
  {
  }

  public CmmdcHolder (CmmdcApp.Cmmdc initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CmmdcApp.CmmdcHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CmmdcApp.CmmdcHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CmmdcApp.CmmdcHelper.type ();
  }

}
