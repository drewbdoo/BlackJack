package com.DrewBlackJack;


import java.util.Scanner;

public class BlackJack {
    public static final String ANSI_RESET  = "\u001B[0m";
    public static final String ANSI_BRIGHT_PURPLE = "\u001B[95m";
    public static final String ANSI_BLUE   = "\u001B[34m";
    public static final String ANSI_BRIGHT_CYAN   = "\u001B[96m";




    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n" + ANSI_BLUE+
                " ,ggg,      gg      ,gg                                                                                          \n" +
                "dP\"\"Y8a     88     ,8P         ,dPYb,                                                          I8                \n" +
                "Yb, `88     88     d8'         IP'`Yb                                                          I8                \n" +
                " `\"  88     88     88          I8  8I                                                       88888888             \n" +
                "     88     88     88          I8  8'                                                          I8                \n" +
                "     88     88     88  ,ggg,   I8 dP    ,gggg,    ,ggggg,     ,ggg,,ggg,,ggg,    ,ggg,         I8      ,ggggg,   \n" +
                "     88     88     88 i8\" \"8i  I8dP    dP\"  \"Yb  dP\"  \"Y8ggg ,8\" \"8P\" \"8P\" \"8,  i8\" \"8i        I8     dP\"  \"Y8ggg\n" +
                "     Y8    ,88,    8P I8, ,8I  I8P    i8'       i8'    ,8I   I8   8I   8I   8I  I8, ,8I       ,I8,   i8'    ,8I  \n" +
                "      Yb,,d8\"\"8b,,dP  `YbadP' ,d8b,_ ,d8,_    _,d8,   ,d8'  ,dP   8I   8I   Yb, `YbadP'      ,d88b, ,d8,   ,d8'  \n" +
                "       \"88\"    \"88\"  888P\"Y8888P'\"Y88P\"\"Y8888PPP\"Y8888P\"    8P'   8I   8I   `Y8888P\"Y888    88P\"\"Y88P\"Y8888P\"    \n");
        Thread.sleep(3000);
        System.out.println("\n" + ANSI_RESET + ANSI_BRIGHT_CYAN+
                " ____, ___,   ____, __    _,' ____ \n" +
                "(-|  \\(-|_)  (-|_, (-| | |   (-(__`\n" +
                " _|__/ _| \\_, _|__, _|_|_|    ____)\n" +
                "(     (      (     (         (     \n");
        Thread.sleep(3000);
        System.out.println("\n" + ANSI_BRIGHT_CYAN +
                "  _        _        _ _             _      _    \n" +
                " | |      | |      | | |           (_)    | |   \n" +
                " | |_ ___ | |_ __ _| | |_   _   ___ _  ___| | __\n" +
                " | __/ _ \\| __/ _` | | | | | | / __| |/ __| |/ /\n" +
                " | || (_) | || (_| | | | |_| | \\__ \\ | (__|   < \n" +
                "  \\__\\___/ \\__\\__,_|_|_|\\__, | |___/_|\\___|_|\\_\\\n" +
                "                         __/ |                  \n" +
                "                        |___/                   \n");
        Thread.sleep(3000);
        System.out.println("\n" + ANSI_BRIGHT_PURPLE+
                "     ...     ..            ..                             ..            .                                       ..      \n" +
                "  .=*8888x <\"?88h.   x .d88\"                        < .z@8\"`        .x88888x.                             < .z@8\"`      \n" +
                " X>  '8888H> '8888    5888R                          !@88E         :8**888888X.  :>                        !@88E        \n" +
                "'88h. `8888   8888    '888R         u           .    '888E   u     f    `888888x./        u           .    '888E   u    \n" +
                "'8888 '8888    \"88>    888R      us888u.   .udR88N    888E u@8NL  '       `*88888~     us888u.   .udR88N    888E u@8NL  \n" +
                " `888 '8888.xH888x.    888R   .@88 \"8888\" <888'888k   888E`\"88*\"   \\.    .  `?)X.   .@88 \"8888\" <888'888k   888E`\"88*\"  \n" +
                "   X\" :88*~  `*8888>   888R   9888  9888  9888 'Y\"    888E .dN.     `~=-^   X88> ~  9888  9888  9888 'Y\"    888E .dN.   \n" +
                " ~\"   !\"`      \"888>   888R   9888  9888  9888        888E~8888            X8888  ~ 9888  9888  9888        888E~8888   \n" +
                "  .H8888h.      ?88    888R   9888  9888  9888        888E '888&           488888   9888  9888  9888        888E '888&  \n" +
                " :\"^\"88888h.    '!    .888B . 9888  9888  ?8888u../   888E  9888.  .xx.     88888X  9888  9888  ?8888u../   888E  9888. \n" +
                " ^    \"88888hx.+\"     ^*888%  \"888*\"\"888\"  \"8888P'  '\"888*\" 4888\" '*8888.   '88888> \"888*\"\"888\"  \"8888P'  '\"888*\" 4888\" \n" +
                "        ^\"**\"\"          \"%     ^Y\"   ^Y'     \"P'       \"\"    \"\"     88888    '8888>  ^Y\"   ^Y'     \"P'       \"\"    \"\"   \n" +
                "                                                                    `8888>    `888                                      \n" +
                "                                                                     \"8888     8%                                       \n" +
                "                                                                      `\"888x:-\"                                         \n"+ ANSI_RESET);
        Thread.sleep(3000);

        System.out.println("Please provide the name for the player");
        String name = scan.nextLine();
        Thread.sleep(1000);
        System.out.println("Welcome to Drew's totally sick Blackjack, "+name+"\n"+"You begin play with $500"+"\n"+
                "Good luck!");
        Thread.sleep(1000);
        System.out.println("You're gonna need it...");
        Game blackjack = new Game(name);








    }
}
