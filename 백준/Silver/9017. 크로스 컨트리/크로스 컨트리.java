import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        // 주자들이 자연적인 야외의 지형에 만들어진 코스를 달리는 운동 경기
        // 일반적으로 4~12km
        // 숲이나 넓은 땅을 통과하는 풀과 흙으로 된 지면 / 언덕 / 평평한 지형
        // 한팀 여섯명
        // 팀 점수 = 상위 네명 주자의 점수 합
        // 결승을 통과한 순서대로 점수
        // 가장 낮은 점수가 우승
        // 여섯 명 참가 못한 팀은 제외
        // 동점은 다섯 번째 주자가 가장 빨리 들어온 팀

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken());

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            // 선수 등수 저장
            int arr[] = new int[num];
            // 각 팀의 등수 카운트
            Map<Integer, Integer> count = new HashMap<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr.length; j++) {
                int team = Integer.parseInt(st.nextToken());
                // 배열에 선수 등수 저장
                arr[j] = team;
                // 각 팀의 등수를 카운트 해서 저장
                count.put(team, count.getOrDefault(team, 0) + 1);
            }

            // 다섯 번째 선수 등수 저장하는 배열
            int fifthGoal[] = new int[count.size() + 1];
            // 각 팀 등수 합 저장
            Map<Integer, Integer> score = new HashMap<>();
            // 각 팀 등수 카운트 저장
            Map<Integer, Integer> plus = new HashMap<>();

            // 더할 숫자
            int cnt = 1;

            for (int j : arr) {
                // 팀의 선수가 6명 이상이면
                if(count.get(j) == 6) {
                    // 더할 등수 카운트 저장
                    plus.put(j, plus.getOrDefault(j, 0) + 1);

                    // 네번째 선수까지만 score에 합 저장
                    if(plus.get(j) <= 4) {
                        score.put(j, score.getOrDefault(j, 0) + cnt);
                    }

                    // 다섯 번째 선수 저장
                    if(plus.get(j) == 5) {
                        fifthGoal[j] = cnt;
                    }

                    cnt++;

                }
            }

            // 등수 합이 있는 key들만 저장
            List<Integer> key = new ArrayList<>(score.keySet());

            key.sort((x, y) -> {
                // 등수 합이 같으면 다섯번째 선수 등수로 비교해서 정렬
                if(Objects.equals(score.get(x), score.get(y))) {
                    return fifthGoal[x] - fifthGoal[y];
                }
                // 그 외에는 등수 합으로 비교 정렬
                else {
                    return score.get(x) - score.get(y);
                }
            });

            sb.append(key.get(0) + "\n");

        }

        System.out.println(sb);

    }

}