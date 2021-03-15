    class Solution {
        public List<List<Integer>> res = new ArrayList<List<Integer>>();
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            for (int i = 0; i < graph[0].length; i++) {
                getPath(List.of(0,graph[0][i]), graph);
             }
             return res;
        }
public void getPath(List<Integer> currPath, int[][] graph) {
//System.out.println(currPath + " " + currPath.get(currPath.size() - 1));
int latestNode = currPath.get(currPath.size() - 1);
if (latestNode == graph.length - 1) {
res.add(currPath);
} else {
for (int i = 0; i < graph[latestNode].length; i++) {
List<Integer> newList = new ArrayList<Integer>(currPath);
newList.add(graph[latestNode][i]);
getPath(newList, graph);
}
}
}
}