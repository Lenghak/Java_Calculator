package helper.controller;

import org.jetbrains.annotations.NotNull;

public class SyntaxCtrl {

    /**
     * Negative handling method for preventing the confusion when two op collided.
     * @param string ~ the string input for searching
     * */
    public static @NotNull String negativeHandler(@NotNull String string) {

        if (string.contains("-") && string.charAt(string.lastIndexOf('-') + 1) != ' ' && string.lastIndexOf('-') - 1 > 0)
            if (string.charAt(string.lastIndexOf('-') - 1) != 'E')
                return string.substring(0, string.lastIndexOf('-')) + "(" + string.substring(string.lastIndexOf('-'), string.lastIndexOf("=") - 1) + ")";

        return string;

    }

}
