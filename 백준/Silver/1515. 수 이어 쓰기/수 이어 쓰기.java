import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int original = 0;
        int loca = 0;

        while (original++ <= 30000) {
            // original 문자열 변환
            String originalStr = String.valueOf(original);

            for (int i = 0; i < originalStr.length(); i++) {
                // originalStr의 현재 위치 문자와 loca의 위치 문자의 일치여부 확인
                if(originalStr.charAt(i) == str.charAt(loca)) {
                    // 일치하면 증가
                    loca++;
                }
                // loca랑 str의 길이가 같으면 출력
                if(loca == str.length()) {
                    System.out.println(originalStr);
                    return;
                }
            }
        }

    }

}