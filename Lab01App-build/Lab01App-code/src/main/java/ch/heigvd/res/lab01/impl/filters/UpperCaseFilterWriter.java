package ch.heigvd.res.lab01.impl.filters;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.Character;

/**
 *
 * @author Olivier Liechti, Arthur Passuello
 */
public class UpperCaseFilterWriter extends FilterWriter {
  
  public UpperCaseFilterWriter(Writer wrappedWriter) {
    super(wrappedWriter);
  }

  @Override
  public void write(String str, int off, int len) throws IOException {
      write(str.toCharArray(), off, len);
  }

  @Override
  public void write(char[] cbuf, int off, int len) throws IOException {
      for(int i = off; i < len+off; i++){
        write(cbuf[i]);
      }
  }

  @Override
  public void write(int c) throws IOException {
    super.write(Character.toUpperCase(c));
  }

}
