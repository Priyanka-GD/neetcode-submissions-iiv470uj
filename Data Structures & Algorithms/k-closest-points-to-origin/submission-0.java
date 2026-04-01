class Solution {
    public int[][] kClosest(int[][] points, int k) {
        List<Point> pointList = new ArrayList<>();
        
        for(int[] coordinate : points){
            Point point = new Point(coordinate[0], coordinate[1]);
            pointList.add(point);   
        }
        Collections.sort(pointList);
        int[][] answer = new int[k][2];
        for(int idx = 0; idx < k; idx ++){
            answer[idx][0] = pointList.get(idx).x;
            answer[idx][1] = pointList.get(idx).y;
        }
        return answer;
    }

}
class Point implements Comparable<Point>{
    int x;
    int y;
    int dist;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
        this.dist = (x * x) + (y * y);
    }

    @Override
    public int compareTo(Point other){
        return this.dist - other.dist;
    }
}
