package com.example.testcodeinjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M, V
        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수
        int v = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점 번호


        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            graph.get(left).add(right);
            graph.get(right).add(left);
        }

        // 각 정점의 인접 리스트 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        boolean[] visited = new boolean[n + 1];
        dfs(graph, visited, v);
        System.out.println();

        visited = new boolean[n + 1];
        bfs(graph, visited, v);
    }

    static void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int nextNode : graph.get(node)) {
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                dfs(graph, visited, nextNode);
            }
        }
    }

    static void bfs(List<List<Integer>> graph, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int child : graph.get(node)) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.add(child);
                }
            }
        }
    }
}