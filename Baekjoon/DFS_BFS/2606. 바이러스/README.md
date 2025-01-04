## [S3] 2606 : 바이러스
> [백준 2606 - **`바이러스`** 바로가기 ](https://www.acmicpc.net/problem/2606)

### 📝 문제 설명
```
신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다.
한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.

예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자.
1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 2, 3, 5, 6 네 대의 컴퓨터는 웜 바이러스에 걸리게 된다.
하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.


```
![](https://velog.velcdn.com/images/jiwon3378/post/c4416977-8c6e-4e4f-90d3-fe5a49665b83/image.png)

```
어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다.
컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때,
1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.
```

---


**`입력`**
첫째 줄에는 컴퓨터의 수가 주어진다. (100 이하의 양의 정수)
둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다.
이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.

**`출력`**
1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.

**`입출력 예시`**
![](https://velog.velcdn.com/images/jiwon3378/post/de157730-ba29-4e74-862f-d8b6007c1c52/image.png)


---
### 문제 들여다 보기.. 👀
위 문제의 목적은 트리에서 두 노드 간의 양방향 간선을 추가하는 것이다.

먼저 입력으로 두 노드 번호 `left` 와 `right` 를 받은 후 두 노드를 서로 연결하는 간선을 `인접 리스트` 방식으로 저장할 것이다.

즉, 양방향 연결이므로
- tree.get(`left`).add(`right`)
- tree.get(`right`).add(`left`)

를 모두 수행한다.

예제 입력 1의 트리 상태 구조를 보았을 때 다음과 같이 나온다.
![](https://velog.velcdn.com/images/jiwon3378/post/856818ca-4c44-4f48-914b-b22ca75c8497/image.png)


나는 **`dfs(깊이 우선 탐색)`** 으로 풀어볼 예정이다.


---
### 코드 구현

**`1️⃣ 트리 입력 처리`**

```java
public class Main {
	static int n; // 컴퓨터의 수
    static int pair; // 연결된 컴퓨터 쌍의 수
    static List<List<Integer>> tree; // 트리 선언
    static boolean[] visited; // 방문 체크 배열
    static int count = 0; // 연결된 컴퓨터 (바이러스)
    
    ...



	// 트리 초기화
	tree = new ArrayList<>();
	for (int i = 0; i < n+1; i++) {
		tree.add(new ArrayList<>());
	}

```
- tree 배열은 각 노드와 연결된 간선을 저장하는 인접 리스트이다.
- 크기는 `n+1` 로 선언해 0번부터 n번 노드의 트리 리스트 초기화



```java
	// 입력 처리
	 for (int i = 0; i < pair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            
            tree.get(left).add(right);
            tree.get(right).add(left);
	}

```

- 위와같이 양방향 간선 표현

**`2️⃣ DFS를 이용한 탐색`**

``` java
visited[1] = ture;

```
- 바이러스가 걸린 노드 1을 TRUE 로 방문 처리 해준다.


``` java

//dfs
dfs(1);

```
- `dfs` 는 바이러스가 걸린 노드 1에서 시작하여 연결된 노드들을 모두 탐색한다.


```java


// DFS 함수
static void dfs(int node) {
	for (int nodes : tree.get(node))
		if (!visited[nodes]) {
			visited[nodes] = true;
			count++;
			dfs(nodes);
		}
	}
}
```

선택한 노드안에 연결된 노드 중 방문하지 않은 노드가 있다면
- 해당 노드를 방문 처리
- 방문한 노드의 개수(count)를 증가
- 해당 노드에 연결된 다른 노드들도 재귀적으로 탐색 (dfs 탐색)

---

### 📌 전체 코드

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n; // 컴퓨터의 수
    static int pair; // 연결된 컴퓨터 쌍의 수
    static List<List<Integer>> tree; // 트리 선언
    static boolean[] visited; // 방문 체크 배열
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 컴퓨터의 수 7
        pair = Integer.parseInt(br.readLine()); // 연결된 쌍 6

        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < pair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            tree.get(left).add(right);
            tree.get(right).add(left);
        }

        visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1);
        System.out.println(count);
    }

    static void dfs(int node) {
        for (int nodes : tree.get(node))
            if (!visited[nodes]) {
                visited[nodes] = true;
                count++;
                dfs(nodes);
            }
    }
}
````
