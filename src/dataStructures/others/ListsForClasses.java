package dataStructures.others;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListsForClasses {
    public static void main(String[] args) {
        try {
            //StreamTokenizer in = new StreamTokenizer (new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1")));
            StreamTokenizer in = new StreamTokenizer (new FileReader("C:\\Users\\anki0216\\Desktop\\informatics_solutions\\src\\dataStructures\\others\\input.txt"));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
            List<String> nine = new ArrayList<>();
            List<String> ten = new ArrayList<>();
            List<String> eleventh = new ArrayList<>();
            String nextline;
            int n;
            while (in.nextToken() != StreamTokenizer.TT_EOF) {
                 n = (int)in.nval;
                 in.nextToken();
                 nextline = in.sval;
                switch (n) {
                    case 9:
                        nine.add(n + " " + nextline);
                        break;
                    case 10:
                        ten.add(n + " " + nextline);
                        break;
                    case 11:
                        eleventh.add(n + " " + nextline);
                        break;
                }
            }
            for (String str : nine) {
                out.println(str);
            }
            for (String str : ten) {
                out.println(str);
            }
            for (String str : eleventh) {
                out.println(str);
            }
            out.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
