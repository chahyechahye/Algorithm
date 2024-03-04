import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        
        // 게임별 인원수 설정
        int play = 0;
        if(game.equals("Y")) {
            play = 1;
        } else if (game.equals("F")) {
            play = 2;
        } else {
            play = 3;
        }

        // 중복제거
        Set<String> user = new HashSet<>();

        for (int i = 0; i < t; i++) {
            user.add(br.readLine());
        }

        int answer = user.size() / play;

        System.out.println(answer);

    }
}