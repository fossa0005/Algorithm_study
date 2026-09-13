package A형기출;

import java.util.HashMap;
import java.util.Scanner;

public class 헌터2 {

    static int[][] arr;

    // 각 대상의 선행 조건
    // 몬스터 : 0
    // 의뢰인 : 1
    static HashMap<Integer, Integer> indegree;

    // 각 대상의 좌표
    static HashMap<Integer, int[]> location;

    // 각 대상 방문 여부
    static HashMap<Integer, Boolean> visited;

    static int ans;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {

            int N = sc.nextInt();

            ans = Integer.MAX_VALUE;

            arr = new int[N][N];
            indegree = new HashMap<>();
            location = new HashMap<>();
            visited = new HashMap<>();

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {

                    arr[r][c] = sc.nextInt();

                    if (arr[r][c] != 0) {

                        int key = arr[r][c];

                        location.put(key, new int[] {r, c});

                        // 몬스터는 바로 방문 가능
                        // 의뢰인은 해당 몬스터를 먼저 방문해야 함
                        if (key > 0) {
                            indegree.put(key, 0);
                        } else {
                            indegree.put(key, 1);
                        }

                        visited.put(key, false);
                    }
                }
            }

            // 시작 위치 : (0, 0) = 문제에서 (1, 1)
            // key = 0은 시작점을 의미
            dfs(0, 0, 0);

            System.out.println("#" + tc + " " + ans);
        }
    }

    static void dfs(int key, int currDistance, int cnt) {

        // 현재 거리가 이미 최솟값보다 크거나 같으면 탐색할 필요 없음
        if (currDistance >= ans) {
            return;
        }

        // 모든 대상 방문 완료
        if (cnt == location.size()) {
            ans = currDistance;
            return;
        }

        // 다음에 방문할 대상 선택
        for (int next : indegree.keySet()) {

            // 아직 선행 조건을 만족하지 못함
            if (indegree.get(next) != 0) {
                continue;
            }

            // 이미 방문함
            if (visited.get(next)) {
                continue;
            }

            // 현재 위치 → 다음 대상까지 거리
            int distance = getShortCut(key, next);

            // next 방문
            visited.put(next, true);

            // next가 몬스터라면
            // 해당 의뢰인의 선행 조건을 제거
            if (next > 0) {
                indegree.put(
                    -next,
                    indegree.get(-next) - 1
                );
            }

            dfs(
                next,
                currDistance + distance,
                cnt + 1
            );

            // 원상복구
            if (next > 0) {
                indegree.put(
                    -next,
                    indegree.get(-next) + 1
                );
            }

            visited.put(next, false);
        }
    }

    // prior → next의 최단거리
    static int getShortCut(int prior, int next) {

        int[] priorLocation;

        // 시작 위치는 (0, 0)
        if (prior == 0) {
            priorLocation = new int[] {0, 0};
        } else {
            priorLocation = location.get(prior);
        }

        int[] nextLocation = location.get(next);

        return Math.abs(priorLocation[0] - nextLocation[0])
             + Math.abs(priorLocation[1] - nextLocation[1]);
    }
}