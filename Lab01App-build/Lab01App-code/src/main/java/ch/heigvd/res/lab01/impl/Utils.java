package ch.heigvd.res.lab01.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Olivier Liechti
 */
public class Utils {

  private static final Logger LOG = Logger.getLogger(Utils.class.getName());

  /**
   * This method looks for the next new line separators (\r, \n, \r\n) to extract
   * the next line in the string passed in arguments. 
   * 
   * @param lines a string that may contain 0, 1 or more lines
   * @return an array with 2 elements; the first element is the next line with
   * the line separator, the second element is the remaining text. If the argument does not
   * contain any line separator, then the first element is an empty string.
   */
  public static String[] getNextLine(String lines) {

    String[] result = new String[2];

    result[0] = "";
    result[1] = lines;

    int lineSep = -1;

    for(int i = 0; i < lines.length(); i++){

      if(lines.charAt(i) == '\r'){
        lineSep = i + 1;

        try{
          if(lines.charAt(i + 1) == '\n')
            lineSep++;
        }catch(IndexOutOfBoundsException e){
            LOG.log(Level.SEVERE, null, e);
        }
        break;
      }
      if(lines.charAt(i) == '\n'){
        lineSep = i + 1;
        break;
      }
    }

    if(lineSep > 0){
      result[0] = lines.substring(0, lineSep);
      result[1] = lines.substring(lineSep);
    }

    return result;
  }

}
