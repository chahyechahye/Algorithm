import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        // 디제이맥스 게임 랭킹있음
        // 비오름차순 점수 저장
        // 랭킹 리스트 등수는 보통 위에서부터 몇번째 있는 점수인지로 결정
        // 같은 점수가 있으면 그 점수의 등수 중 가장 작은 등수가 됨
        // 랭킹 리스트 100 90 90 80 >> 1 2 2 4
        // 랭킹에 올라갈 점수 p개
        // 랭킹리스트가 이미 꽉차있다면 새 점수가 이전 점수보다 좋아야만 하는 조건 주의

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 리스트에 있는 점수 n개
        int n = Integer.parseInt(st.nextToken());
        // 새로 등록할 점수
        int newP = Integer.parseInt(st.nextToken());
        // 랭킹에 속할 수 있는 점수
        int list = Integer.parseInt(st.nextToken());

        // 랭킹을 등록하는 배열
        // 하나를 더 추가해줘서 배열 자체에 newP 넣을 예정
        int arr[] = new int[list+1];

        for (int i = 0; i < arr.length; i++) {
            arr[i]=-1;
        }

        // 둘째 줄은 n이 0보다 클 때만 주어짐
        if(n>0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }

        // newP 입성
        arr[n] = newP;

        // 정렬
        Arrays.sort(arr);

        // newP가 첫번째 점수와 같다면 랭킹에 들수 없음
        // 들어간 게 0개고 점수가 0이면 어쨌든 들어갈 순 있으니... n!=0 조건 추가
        if(arr[0]==newP && n!=0) {
            System.out.println(-1);
        } else {
            // 거꾸로 돌면서 newP와 같은 것 찾아 출력
            for (int i = arr.length-1; i >= 0; i--) {
                if(arr[i] == newP) {
                    System.out.println(arr.length-i);
                    break;
                }
            }
        }
    }

}