import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        // 자신과 인접한 햄버거만 먹기 가능
        // 햄버거를 먹을 수 있는 사람의 최대 수
        // 맛있겠다.........

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int desk = Integer.parseInt(st.nextToken());
        int dis = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        char burger[] = new char[desk];
        int cnt = 0;

        for (int i = 0; i < desk; i++) {
            burger[i] = str.charAt(i);
        }

        for (int i = 0; i < desk; i++) {
            // 사람을 보면
            if (burger[i] == 'P') {
                // idx 왼쪽 설정
                int idx = Math.max(i - dis, 0);
                // 왼쪽에서 발견 여부 설정
                boolean found = false;
                // 햄버거 찾으면 O로 바꿔주고 cnt++
                for (int j = idx; j < i; j++) {
                    if (burger[j] == 'H') {
                        burger[j] = 'O';
                        cnt++;
                        found = true;
                        break;
                    }
                }
                // 왼쪽에서 못찾으면
                if (!found) {
                    // idx 오른쪽 설정
                    idx = Math.min(i + dis, desk - 1);
                    // 햄버거 찾으면 O로 바꿔주고 cnt++
                    for (int j = i + 1; j <= idx; j++) {
                        if (burger[j] == 'H') {
                            burger[j] = 'O';
                            cnt++;
                            break;
                        }
                    }
                }
            }

        }

        System.out.println(cnt);

    }

}