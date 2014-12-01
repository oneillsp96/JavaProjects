package functions.homework;

public class FunctionCallsAlphabet {

    public static void main(String[] args) {

        a();      // ???? a( ???? );    // displays a word beginning with A
        b();          // ???? b( ???? );    // returns the word to be displayed
        c(true);          // ???? c( ???? );    // pass it 'true' and it will display a word beginning with C
        d();         // ???? d( ???? );    // displays a word beginning with D
        e(9);          // ???? e( ???? );    // pass it the number of letters to display (9)
        f("Farmer");          // ???? f( ???? );    // displays the word you pass it beginning with "F"
        g();                  // ???? g( ???? );    // returns the word to be displayed
        h(1);                  // ???? h( ???? );    // tell it how many times to display the word (1)

        System.out.println();

        i(4);           // ???? i( ???? );    // pass it any integer and it will display a word beginning with I 
        j(2);           // ???? j( ???? );    // returns a different word depending on what you pass it (1-3)
        k();            // ???? k( ???? );    // displays a word beginning with K
        l(5 > 4, 8 > 4);          // ???? l( ???? );    // displays a different word depending on the two booleans you pass it
        m(4 > 5, 8 < 4);              // ???? m( ???? );    // displays a different word depending on the two booleans you pass it
        n("Narnia");          // ???? n( ???? );    // displays the word you pass it beginning with "N"
        o();            // ???? o( ???? );    // displays a word beginning with O and returns a useless value
        p();          // ???? p( ???? );    // returns the word to be displayed
        q();           // ???? q( ???? );    // displays the word
        System.out.println();

        r(true);                                       // ???? r( ???? );    // returns a different word depending on if you pass it 'true' or 'false'
        s(6);                                     // ???? s( ???? );    // pass it the number of letters to display (6)
        t("turtle");                                // ???? t( ???? );    // displays the word you pass it beginning with "T"
        u();                                        // ???? u( ???? );    // returns the word to be displayed
        v(1);                                   // ???? v( ???? );    // tell it how many times to display the word (1)
        w(3);                                  // ???? w( ???? );    // pass it any integer and it will display a word beginning with W 
        x(2);                                  // ???? x( ???? );    // returns a different word depending on what you pass it (1-2)
        y();                                  // ???? y( ???? );    // displays a word beginning with Y
        z((8 > 7), (6 > 4));	                    // ???? z( ???? );    // returns a different word depending on which two boolean values you pass it
        System.out.println();
    }

    /**
     * ************************************
     * Don't change anything below here!! *
	 ************************************
     */
    public static void a() {
        System.out.print("Ant ");
    }

    public static String b() {
        
                return "Banana ";
        
    }

    public static void c(boolean doit) {
        if (doit) {
            System.out.print("Crocodile ");
        }
    }

    public static void d() {
        System.out.print("Doggie ");
    }

    public static void e(int howmany) {
        String s;
        s = "Elephant ";
        int x = 0;
        while (x < howmany) {
            System.out.print(s.charAt(x));
            x = x + 1;
        }

    }

    public static void f(String word) {
        System.out.print(word + " ");
    }

    public static String g() {
        return "Gorilla ";
    }

    public static void h(int reps) {
        int x = 0;
        while (x < reps) {
            System.out.print("Horseradish ");
            x = x + 1;
        }

    }

    public static void i(int ignoredparameter) {
        ignoredparameter = 32;
        String space = Character.toString((char) ignoredparameter);
        System.out.print("Ice_cream" + space);
    }

    public static String j(int whichone) {
        if (whichone == 1) {
            return "Jambalaya ";
        } else if (whichone == 2) {
            return "Juniper ";
        } else {
            return "Jackrabbit ";
        }
    }

    public static void k() {
        // the bird OR the fruit
        System.out.print("Kiwi ");
    }

    public static void l(boolean a, boolean b) {
        if (a && b) {
            System.out.print("Lettuce ");
        } else {
            System.out.print("Lhasa_apso ");
        }
    }

    public static void m(boolean a, boolean b) {
        if (a || b) {
            System.out.print("Mango ");
        } else {
            System.out.print("Monkey! ");
        }
    }

    public static void n(String word) {
        System.out.print(word + " ");
    }

    public static int o() {
        System.out.print("Orangutan ");
        return 1;	// just for kicks; the return value doesn't mean anything
    }

    public static String p() {
        System.out.println("Parrot");   //added this because return wasn;t 
        
        return "Parrot ";                  //why isn't
    }

    public static void q() {
        System.out.print("Quail ");
    }

    public static String r(boolean first) {
        if (first) {
            return "Rabbit ";
        } else {
            return "Radish ";
        }
    }

    public static void s(int howmany) {
        String s;
        s = "Snake ";
        int x = 0;
        while (x < howmany) {
            System.out.print(s.charAt(x));
            x = x + 1;
        }
    }

    public static void t(String word) {
        System.out.print(word + " ");
    }

    public static String u() {
        
        System.out.println("ugly fruit");              //why doesnt return work?
       
    return "ugly fruitssss";
    }

    public static void v(int reps) {
        int x = 0;
        while (x < reps) {
            System.out.print("Valentine_candy ");
            x = x + 1;
        }
    }

    public static void w(int ignoredparameter) {
        ignoredparameter = 32;
        String space = Character.toString((char) ignoredparameter);
        System.out.print("Walrus" + space);
    }

    public static String x(int whichone) {
        if (whichone == 1) {
            return "X_files ";
        } else {
            return "X_men ";
        }
    }

    public static void y() {
        System.out.print("Yams ");
    }

    public static String z(boolean a, boolean b) {
        if (a || b) {
            return "Zanahorias ";
        } else {
            return "Zebra ";
        }
    }

}
