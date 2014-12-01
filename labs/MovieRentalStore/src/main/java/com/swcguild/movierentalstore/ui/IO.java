
package com.swcguild.movierentalstore.ui;

/**
 *
 * @author apprentice
 */
public interface IO {

    
    void print(String msg);
    
    void displayMessage(String message);

    double doubleBetweenPrompt(String message, double min, double max);

    double doublePrompt(String message);

    float floatBetweenPrompt(String message, float min, float max);

    float floatPrompt(String message);

    int intBetweenPrompt(String message, int min, int max);

    int integerPrompt(String message);

    String stringPrompt(String message);
    
}
