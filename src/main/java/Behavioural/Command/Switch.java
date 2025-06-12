/*
 * (c) Midland Software Limited 2025
 * Name     : Switch.java
 * Author   : RoodbarakyK
 * Date     : 12 Jun 2025
 */
package Behavioural.Command;
//invoker
public class Switch {
    public void storeAndExecute(Command command) {
        command.execute();
    }
}
