import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 단어장 규칙
        // 자주 나오는 단어일 수록 앞에 배치
        // 해당 단어의 길이가 길수록 앞에 배치
        // 알바펫 사전 순으로 앞에 있는 단어일수록 앞에 배치
        // m보다 짧은 단어는 단어장에 쓰이지 않음.

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // map 선언
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i<n; i++) {
            String str = br.readLine();
            // m의 길이보다 긴 것만
            if(str.length() >= m) {
                // map에 담는데 str이 이미 있으면 +1 해줌 기본값은 0
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }

        // collections sort를 쓰기 위해 list에 map 단어들 저장
        List<String> words = new ArrayList<>(map.keySet());

        // words를 comparator를 통해 정렬
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // string들을 map에서 가져온 value로 비교해서 자주 등장하는 순으로 정렬
                if(Integer.compare(map.get(o1), map.get(o2)) != 0) {
                    return Integer.compare(map.get(o2), map.get(o1));
                }
                // 길이가 긴 단어가 먼저 오도록 정렬
                if(o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                }
                // 사전 순 정렬
                return o1.compareTo(o2);
            };
        });

        for(String answer : words) {
            sb.append(answer + "\n");
        }

        System.out.println(sb);

    }
}