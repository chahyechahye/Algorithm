import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 가희 블로그 운영 블로그 글 쓰려고 키워드 적음
        // 메모장에 써진 키워드 모두 다름, N개 존재
        // 새로운 글 작성시 최대 10개의 키워드에 대해 작성
        // 메모장에 있던 키워드는 가희가 글을 쓰고 나서 지워짐
        // 블로그에 글을 쓴 후 메모장에 남은 키워드 개수는?

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> hs = new HashSet<>();

        for(int i = 0; i<n; i++) {
            hs.add(br.readLine());
        }

        for(int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), ",");
            while(st.hasMoreTokens()) {
                String str = st.nextToken();
                if(hs.contains(str)) {
                    hs.remove(str);
                }
            }
            sb.append(hs.size()+"\n");
        }

        System.out.println(sb);

    }

}