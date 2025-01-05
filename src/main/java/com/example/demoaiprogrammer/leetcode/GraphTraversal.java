package com.example.demoaiprogrammer.leetcode;

import com.example.demoaiprogrammer.leetcode.NodeConnection;

import java.util.*;



public class GraphTraversal {
    public static void main(String[] args) {
        // Danh sách các liên kết
        List<NodeConnection> connections = Arrays.asList(
                new NodeConnection(1, 2), // Right branch
                new NodeConnection(1, 3), // Left branch
                new NodeConnection(2, 4), // Right branch
                new NodeConnection(3, 5), // Left branch
                new NodeConnection(4, 6), // Right branch
                new NodeConnection(5, 7) // Left branch
        );

        // Xây dựng danh sách kề
        Map<Integer, List<Integer>> adjacencyList = buildAdjacencyList(connections);

        // Xác định nhánh, cấp độ
        String branch = "right"; // Hoặc "left"
        int level = 2;           // Tìm các node ở bước thứ 2
        int startBranchNode = branch.equals("right") ? 2 : 3;

        // Tìm node ở level cụ thể trong nhánh
        List<Integer> result = bfsToNthLevel(adjacencyList, startBranchNode, level);
        System.out.println("Các node ở mức " + level + " từ nhánh " + branch + ": " + result);
    }

    // Hàm xây dựng danh sách kề
    private static Map<Integer, List<Integer>> buildAdjacencyList(List<NodeConnection> connections) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (NodeConnection connection : connections) {
            adjacencyList
                    .computeIfAbsent(connection.fromNode, k -> new ArrayList<>())
                    .add(connection.toNode);
        }
        return adjacencyList;
    }

    // Hàm BFS để tìm các node ở cấp độ cụ thể của nhánh
    private static List<Integer> bfsToNthLevel(Map<Integer, List<Integer>> graph, int startNode, int level) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> visitedLevel = new HashMap<>(); // Lưu mức độ của mỗi node

        queue.add(startNode);
        visitedLevel.put(startNode, 0);

        List<Integer> result = new ArrayList<>();

        // Xác định các node thuộc nhánh cụ thể
        Set<Integer> branchNodes = getBranchNodes(graph, startNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            int currentLevel = visitedLevel.get(currentNode);

            if (currentLevel == level) {
                if (branchNodes.contains(currentNode)) { // Chỉ thêm nếu thuộc nhánh
                    result.add(currentNode);
                }
                continue; // Không duyệt sâu hơn
            }

            // Duyệt các node liên kết
            List<Integer> neighbors = graph.getOrDefault(currentNode, Collections.emptyList());
            for (int neighbor : neighbors) {
                if (!visitedLevel.containsKey(neighbor)) {
                    visitedLevel.put(neighbor, currentLevel + 1);
                    queue.add(neighbor);
                }
            }
        }

        return result;
    }

    // Hàm để xác định các node thuộc một nhánh
    private static Set<Integer> getBranchNodes(Map<Integer, List<Integer>> graph, int startNode) {
        Set<Integer> branchNodes = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            branchNodes.add(currentNode);

            // Duyệt qua tất cả các node liên kết
            List<Integer> neighbors = graph.getOrDefault(currentNode, Collections.emptyList());
            queue.addAll(neighbors);
        }

        return branchNodes;
    }
}
