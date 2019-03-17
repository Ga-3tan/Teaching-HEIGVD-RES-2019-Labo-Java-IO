package ch.heigvd.res.labio.impl;

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
    String[] lineBreakType = {"\r\n", "\n", "\r"};
    String[] splittedLine = new String[2];
    if (lines.contains(lineBreakType[0])) {
      splittedLine = lines.split("\r\n", 2);
      splittedLine[0] =  splittedLine[0] + "\r\n";
    } else if (lines.contains(lineBreakType[1])) {
      splittedLine = lines.split("\n", 2);
      splittedLine[0] =  splittedLine[0] + "\n";
    } else if (lines.contains(lineBreakType[2])) {
      splittedLine = lines.split("\r", 2);
      splittedLine[0] =  splittedLine[0] + "\r";
    } else {
      splittedLine[0] = "";
      splittedLine[1] = lines;
    }
    return splittedLine;
  }

}
