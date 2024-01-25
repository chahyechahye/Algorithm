import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 알파벳 배열
        String alpha[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        // 카운트 배열
        int count[] = new int [26];
        // 최댓값
        int max = 0;

        // 알파벳과 비교해야하므로 소문자 변환
        String str = br.readLine().toLowerCase();

        // 문자 하나씩 뽑아 알파벳 범위에 있다면 해당 count배열의 값 올려줌
        for(int i = 0; i<str.length(); i++) {
            char a = str.charAt(i);
            if('a'<=a && a<='z') {
                count[a-'a']++;
            }
        }

        // 최댓값 찾기
        for(int i = 0; i<count.length; i++) {
            if(count[i]>max) {
                max=count[i];
            }
        }
        
        // 최댓값을 센 수
        int countmax = 0;
        // 위치
        int loca = 0;

        // 2개 이상 최대 알파벳이 있는지 확인하는 과정
        for(int i = 0; i<count.length; i++) {
            if(max == count[i]) {
                countmax++;
                loca = i;
            }
        }
        
        // countmax가 1보다 크면 중복이므로 ?를 출력, 이 외에는 찾은 알파벳을 대문자 출력
        System.out.println(countmax > 1 ? "?" : alpha[loca].toUpperCase());

    }
}