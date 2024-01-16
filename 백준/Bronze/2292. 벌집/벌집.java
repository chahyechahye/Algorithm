import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1 > 1 : 1개
        // 2 > 2 3 4 5 6 7 : 6개
        // 3 > 8 9 10 11 12 13 14 15 16 17 18 19 : 12개
        // 4 > 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 : 18개

        int room = Integer.parseInt(st.nextToken());
        int count = 1;
        int num = 2;

        if(room == 1) {
            System.out.println(1);
        } else {
            while(room >= num) {
                num = num + (6 * count);
                count++;
            }
            System.out.println(count);
        }
        
    }

}