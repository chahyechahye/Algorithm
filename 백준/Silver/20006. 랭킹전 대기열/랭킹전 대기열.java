import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        // 비슷한 렙 플레이어 매칭
        // 입장 가능 방 있으면 정원 다 찰 때까지 대기
        // 입장 가능 방 여러개면 먼저 생긴 방
        // 정원이 모두 차면 게임 시작


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int playerCnt = Integer.parseInt(st.nextToken());
        int roomCnt = Integer.parseInt(st.nextToken());
        Player[] players = new Player[playerCnt];

        for (int i = 0; i < playerCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            players[i] = new Player(name, level);
        }

        // 방에 플레이어 배정
        for (int i = 0; i < playerCnt; i++) {
            ArrayList<Player> room = new ArrayList<>();

            if (!players[i].check) {
                for (int j = i; j < playerCnt; j++) {
                    if(room.size() == roomCnt) {
                        break;
                    }
                    String name = players[j].playerName;
                    int level = players[j].level;
                    if (!players[j].check && players[i].level - 10 <= level && players[i].level + 10 >= level) {
                        players[j].check = true;
                        room.add(new Player(name, level));
                    }
                }

                if(room.size() == roomCnt) {
                    sb.append("Started!\n");
                } else {
                    sb.append("Waiting!\n");
                }

                Collections.sort(room);

                for (Player player : room) {
                    sb.append(player.level).append(" ").append(player.playerName).append("\n");
                }

            }
        }

        System.out.println(sb);

    }

    public static class Player implements Comparable<Player> {
        String playerName;
        int level;
        boolean check;

        Player(String playerName, int level) {
            this.playerName = playerName;
            this.level = level;
        }

        @Override
        public int compareTo(Player o) {
            return playerName.compareTo(o.playerName);
        }

    }

}