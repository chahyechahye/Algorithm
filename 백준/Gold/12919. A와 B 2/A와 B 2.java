import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String args[]) throws IOException {

        // A와 B로만 이루어진 영단어 존재
        // AB, BAA, AA, ABBA 같은...
        // 문자열 바꿀 땐 두가지 연산만 가능
        // 1. 문자열의 뒤에 a를 추가한다.
        // 문자열의 뒤에 B를 추가하고 문자열을 뒤집는다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        Queue<String> que = new LinkedList<>();

        que.add(t);

        // 1. 둘이 같으면 return 1
        // 2. 뒤에 A가 있으면 A를 추가한 것이므로 A 제거
        // 3. 맨 앞에 B가 있으면 B를 추가하고 뒤집은거니 반대로 맨 앞을 제거하고 뒤집어서 큐 제거
        while(!que.isEmpty()) {
            String str = que.poll();
            if(str.equals(s)) {
                System.out.println(1);
                return;
            }
            if(str.length() >= 2 && str.charAt(str.length()-1) == 'A') {
                que.add(str.substring(0, str.length()-1));
            }
            if(str.length() >= 2 && str.charAt(0) == 'B') {
                // stringbuilder 객체로 변환. sb는 문자열을 변경가능한 형태로 다루는 클래스로 문자열을 뒤집을 수 있게 함
                // 문자열의 첫번째 문자를 제외하고 나머지 부분을 뒤집은 새로운 문자열 생성
                que.add(new StringBuilder(str.substring(1)).reverse().toString());
            }
        }

        System.out.println(0);

    }

}