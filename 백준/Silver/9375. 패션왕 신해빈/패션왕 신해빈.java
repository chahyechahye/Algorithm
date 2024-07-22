import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            // hashmap 생성
            HashMap<String, Integer> hm = new HashMap<>();
            
            int n = Integer.parseInt(br.readLine());

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                // 옷의 이름은 중요하지 않으니 넘김
                st.nextToken();

                // 옷의 종류
                String cloth = st.nextToken();

                // 이미 있는 key의 경우 value에 + 1
                if(hm.containsKey(cloth)) {
                    hm.put(cloth, hm.get(cloth) + 1);
                } else {
                    // 그 외에는 새로운 key value에 1 부여
                    hm.put(cloth, 1);
                }

            }

            int answer = 1;

            // 안 입는 경우도 있으니 +1 값을 곱하기
            for (int val : hm.values()) {
                answer *= (val + 1);
            }

            System.out.println(answer - 1);

        }


    }

}