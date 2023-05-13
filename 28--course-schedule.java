class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            indegree[edge[0]]++;
        }
        int enrolled = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int node = 0; node < indegree.length; node++) {
            if (indegree[node] == 0) {
                queue.add(node);
                enrolled++;
            }
        }
        while (!queue.isEmpty()) {
            int currNode = queue.poll(); // current course
            for (int neighbor : adj.get(currNode)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                    enrolled++;
                }
            }
        }
        return (numCourses == enrolled);
    }
} // TC: O(V + E), SC: O(V)

/* [[0,4],[0,5],[1,4],[2,5],[1,3],[3,2]], 6 */
