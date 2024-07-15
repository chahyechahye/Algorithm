import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k, p, x;
    static int [][] num = {{1, 1, 1, 0, 1, 1, 1}, //0
    {0, 0, 1, 0, 0, 1, 0}, //1
    {0, 1, 1, 1, 1, 0, 1}, //2
    {0, 1, 1, 1, 0, 1, 1}, //3
    {1, 0, 1, 1, 0, 1, 0}, //4
    {1, 1, 0, 1, 0, 1, 1}, //5
    {1, 1, 0, 1, 1, 1, 1}, //6
    {0, 1, 1, 0, 0, 1, 0}, //7
    {1, 1, 1, 1, 1, 1, 1}, //8
    {1, 1, 1, 1, 0, 1, 1}}; //9
    static int count = 0;

    public static void main(String[] args) throws IOException{

            // 1층 N층 사용 가능 엘리베이터
            // 층수를 보여주는 디스플레이에 K자리수 보임
            // 0으로 시작할수도 있음
            // 7개의 표시등 중 일부에 들어오며 표현 (디지털)
            // 최소 1개, 최대 P개를 반전시키기
            // 반전 이후 디스플레이에 올바른 수가 보여지며 1 이상 N이하가 되도록 바꿔 헷갈리게 하기
            // 실제 층 = X 층

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            // N층까지의 엘리베이터
            n = Integer.parseInt(st.nextToken());
            // 디스플레이 수 K
            k = Integer.parseInt(st.nextToken());
            // 최대 반전 수 P
            p = Integer.parseInt(st.nextToken());
            // 실제 층수 X
            x = Integer.parseInt(st.nextToken());
            
            // 자릿 수 분리
            int[] xNum = numDivide(x);
            check(xNum);
            System.out.println(count);
        
    }

    public static void check(int[] xNum) {
        // 1층부터
        for (int i = 1; i <= n; i++) {
            // 실제 층수는 하지 않음
            if(i == x) {
                continue;
            }
            if(reverse(i, xNum)) {
                count++;
            }
        }
    }

    public static int[] numDivide(int x) {
        // k 길이의 배열
        int[] divideNum = new int [k];
        // 가장 오른쪽 숫자부터 시작
        for (int i = k-1; i >=0; i--) {
            // x의 마지막 자리수를 배열 i에 저장
            divideNum[i] = x % 10;
            // 이동
            x /= 10;
        }
        return divideNum;
    }

    public static boolean reverse(int change, int[] xNum) {
        int [] changeNum = numDivide(change);

        // 반전 수
        int diff = 0;
        
        // 자릿수마다 반복
        for (int i = 0; i < k; i++) {
            // 각 디지털 led 마다 반복
            for (int j = 0; j < 7; j++) {
                if(num[xNum[i]][j] != num[changeNum[i]][j]) {
                    diff++;
                    if(diff > p) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}