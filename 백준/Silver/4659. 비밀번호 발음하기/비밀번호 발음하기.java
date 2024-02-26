import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        // 발음이 가능한 패스워드
        // 1. a, e, i, o, u 중 하나 꼭 포함
        // 2. 모음이나 자음이 연속 3개 오면 안됨
        // 3. 같은 글자가 연속으로 두번 오면 안되는데 ee랑 oo는 됨

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Boolean flag = true;

        while (flag) {
            String word = br.readLine();
            // end가 오면 반복 끝
            if(word.equals("end")) {
                flag = false;
                break;
            }

            // 단어의 길이
            int n = word.length();
            // char 배열
            char arr[] = new char[n];

            // 모음 있는지
            int aeiou = 0;
            // 모음 자음 3개 체크
            int mo = 0;
            int ja = 0;
            boolean three = true;
            // 같은 글자인지?
            boolean doubleCheck = true;

            for (int i = 0; i < arr.length; i++) {
                char a = word.charAt(i);
                arr[i] = a;
                // 모음이면
                if(a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') {
                    // 모음 카운트 ++
                    aeiou++;
                    // 모음 ++
                    mo++;
                    // 자음 초기화
                    ja = 0;
                    // 모음 3개면 false
                    if(mo == 3) {
                        three = false;
                    }
                }
                // 자음이면
                else {
                    // 자음 카운트 ++
                    ja++;
                    // 모음 초기화
                    mo = 0;
                    // 자음 3개면 false
                    if(ja == 3) {
                        three = false;
                    }
                }
                // e와 o가 아니며 같은 글자 연속된 경우 false
                if(i > 0 && (a != 'e' && a != 'o') && arr[i] == arr[i-1]) {
                        doubleCheck = false;
                }
            }

            // 조건 모두 충족할 때만 acceptable
            if(aeiou != 0 && three && doubleCheck) {
                sb.append("<" + word + "> is acceptable.\n");
            } else {
                sb.append("<" + word + "> is not acceptable.\n");
            }

        }

        System.out.println(sb);

    }

}