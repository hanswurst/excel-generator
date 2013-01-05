package org.openhmis.xls.exception;

public class XlsFileNotWrittenException extends Exception {

    private static final long serialVersionUID = 1L;

    public XlsFileNotWrittenException(String exceptionMesage){
        super(exceptionMesage);
      }

      public XlsFileNotWrittenException(String exceptionMessage, Throwable t){
        super(exceptionMessage,t);
      }
}
