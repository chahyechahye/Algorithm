import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

        // 0과 1로 이루어진 문자열 S
        // S가 포함하는 0의 개수와 S가 포함하는 1의 개수는 모두 짝수
        // S를 구성하는 문자 중 절반의 0과 1을 제거해서 새로운 문자열 S' 생성
        // S'로 가능한 문자열 중 사전 순 가장 빠른 것 구하기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Queue<Integer> one = new LinkedList<>();
        Queue<Integer> zero = new LinkedList<>();
        String ans = "";

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)-'0' == 1) {
                one.add(str.charAt(i) - '0');
            } else {
                zero.add(str.charAt(i) - '0');
            }
        }

        int oneSize = one.size();
        int zeroSize = zero.size();

        for (int i = 0; i < zeroSize/2; i++) {
            ans += "0";
        }
        for (int i = 0; i < oneSize/2; i++) {
            ans += "1";
        }

        System.out.println(ans);

    }

}