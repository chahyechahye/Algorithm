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
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        int arr[] = new int[str.length()];
        int one = 0;
        int zero = 0;

        // one zero 갯수 세기
        // arr에 값 넣어두기
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) - '0' == 1) {
                one++;
            } else {
                zero++;
            }
            arr[i] = str.charAt(i) - '0';
        }

        // 절반씩 없애줄 예정이므로 1/2 값 설정
        one = one/2;
        zero = zero/2;

        // 앞에서부터 1인 경우 2로 치환
        // one의 갯수가 0이 될때까지 진행
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) - '0' == 1) {
                arr[i] = 2;
                one--;
            }
            if(one == 0) {
                break;
            }
        }

        // 앞에서부터 0인 경우 2로 치환
        // zero의 갯수가 0이 될때까지 진행
        for (int i = str.length() - 1 ; i >= 0; i--) {
            if(str.charAt(i) - '0' == 0) {
                arr[i] = 2;
                zero--;
            }
            if(zero == 0) {
                break;
            }
        }

        // arr[i]가 2가 아닐때만 sb에 더해줌
        for (int i = 0; i < str.length(); i++) {
            if(arr[i] != 2) {
                sb.append(arr[i]);
            }
        }

        System.out.println(sb);

    }

}