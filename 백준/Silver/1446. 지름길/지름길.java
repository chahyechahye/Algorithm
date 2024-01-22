import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    // 지름길 정보 저장
    static ArrayList<spot>[] shortWay;


    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // D킬로미터 길이의 고속도로
        // 커브 너무 많음 근데 지름길 근데 일방통행 역주행 불가

        st = new StringTokenizer(br.readLine());
        // 지름길 갯수 n 고속도로 길이 d
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        // 출발 지점부터 각 지점까지의 최단 거리를 저장하는 배열
        int distance[] = new int[d+1];

        shortWay = new ArrayList[10001];

        // distance를 최댓값으로 저장
        //distance[0] = 0
        //distance[1] = 최대값
        //distance[2] = 최대값
        //...
        //distance[150] = 최대값
        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int i = 0; i<10001; i++) {
            shortWay[i] = new ArrayList<>();
        }

        for(int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            // 지름길인 경우만 저장
            //shortWay[50] -> (0, 10), (0, 20)
            //shortWay[100] -> (50, 10)
            //shortWay[151] -> (100, 10)
            //shortWay[140] -> (110, 90)
            if(e-s > dis) {
                shortWay[e].add(new spot(s, dis));
            }
        }

        // 다익스트라
        // distance[0]을 0으로 초기화
        distance[0] = 0;
        // 1부터 d까지 반복하며 최단거리 갱신
        //
        for(int i = 1; i<=d; i++) {
            // 각 지점마다 지름길이 있다면
            if(shortWay[i].size()>0) {
                // 해당 지름길을 이용하는 게 더 좋은지 검사와 갱신
                for(spot s : shortWay[i]) {
                    // 거리가 더 크면 컨티뉴
                    if(distance[s.start] + s.dist > distance[i]) {
                        continue;
                    }
                    // 최솟값으로 갱신
                    distance[i] = Math.min(distance[i-1]+1, distance[s.start] + s.dist);
                }
                continue;
            }
            distance[i] = distance[i-1]+1;
        }

        //distance[0] = 0
        //distance[1] = 1
        //distance[2] = 2
        //...
        //distance[50] = 50
        //distance[100] = 20 (0->50, 50->100 지름길 이용)
        //distance[110] = 30 (0->50, 50->100 지름길 이용)
        //...
        //distance[140] = 60 (50->100, 100->151 지름길 이용,110->140 지름길 x)
        //distance[151] = 71 (0->50, 50->100, 100->151 지름길 이용)
        //...
        //distance[150] = 70 (0->50, 50->100 지름길 이용 + 100->150 = 50)

        System.out.println(distance[d]);

    }

    static class spot {
        int start;
        int dist;
        spot(int start, int dist) {
            this.start = start;
            this.dist = dist;
        }
    }

}