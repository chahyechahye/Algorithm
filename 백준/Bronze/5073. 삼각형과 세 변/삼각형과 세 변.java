import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 삼각형 세 변의 길이가 주어질 때
        // Equilateral : 세 변의 길이가 모두 같음
        // Isosceles : 두 변 길이만 같음
        // Scalene : 세 변이 모두 다름
        // 조건을 만족하지 못하면 Invalid

        int arr[] = new int[3];

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");

            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());

            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
                break;
            }

            if (arr[0]>=arr[1]+arr[2] || arr[1]>=arr[0]+arr[2] || arr[2]>=arr[1]+arr[0] ) {
                sb.append("Invalid\n");
            }else if (arr[0] == arr[1] && arr[1] == arr[2]) {
                sb.append("Equilateral\n");
            } else if ((arr[0] == arr[1]) || (arr[1] == arr[2]) || (arr[0] == arr[2])) {
                sb.append("Isosceles\n");
            } else if (arr[0] != arr[1] && arr[1] != arr[2] && arr[0] != arr[2]) {
                sb.append("Scalene\n");
            }

        }

        System.out.println(sb);

    }

}